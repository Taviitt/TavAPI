package net.tavx.logger;

import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public class LoggerAPI {

    /**
     *
     * log message sent to console
     *
     * @param log | log message
     */
    public static void log(Class<?> clazz, LogType type, String log) {
        JavaPlugin plugin = JavaPlugin.getProvidingPlugin(clazz);
        plugin.getServer().getConsoleSender().sendMessage(
                ChatColor.translateAlternateColorCodes('&', type.getColor() + "[" + getPluginName(clazz) + "] " + type.getName() + " | " + log)
        );
    }

    /**
     *
     * Get name of JavaPlugin
     *
     * @param clazz | class that extends JavaPlugin
     * @return name of plugin
     */
    private static String getPluginName(Class<?> clazz) {
        JavaPlugin plugin = JavaPlugin.getProvidingPlugin(clazz);
        return plugin.getName();
    }

}
