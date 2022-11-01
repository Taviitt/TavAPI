package net.tav;

import com.google.common.base.Strings;
import org.bukkit.ChatColor;

public class NumberUtil {
    private static NumberUtil instance;

    public static NumberUtil getInstance() {
        if(instance == null) instance = new NumberUtil();
        return instance;
    }

    public String getProgressBar(int current, int max, int totalBars) {
        float percent = (float) current / max;
        int progressBars = (int) (totalBars * percent);

        return Strings.repeat("" + ChatColor.GREEN + "|", progressBars)
                + Strings.repeat("" + ChatColor.GRAY + "|", totalBars - progressBars);
    }

    public String getProgressBar(int current, int max, int totalBars, ChatColor completedColor,
                                 ChatColor notCompletedColor) {
        float percent = (float) current / max;
        int progressBars = (int) (totalBars * percent);

        return Strings.repeat("" + completedColor + "|", progressBars)
                + Strings.repeat("" + notCompletedColor + "|", totalBars - progressBars);
    }

    public String getProgressBarWithPercentage(int current, int max, int totalBars, ChatColor completedColor,
                                               ChatColor notCompletedColor) {
        float percent = (float) current / max;
        int progressBars = (int) (totalBars * percent);

        return Strings.repeat("" + completedColor + "|", progressBars)
                + Strings.repeat("" + notCompletedColor + "|", totalBars - progressBars) + " " + ChatColor.GRAY + (getPercentage(current, max) + "%");
    }

    /**
     *
     * Return a percentage
     *
     * @param current | current status
     * @param max | max status
     * @return a percentage
     */
    public int getPercentage(int current, int max) {
        int percent = current * 100 / max;
        return (int) (Math.round(percent * 10.0) / 10.0);
    }

    /**
     *
     * Generate a random number between specified range
     *
     * @param min | minimum number
     * @param max | maximum number
     * @return random number between specified range
     */
    public int generateRandomNumber(int min, int max) {
        return (int) (Math.random() * (max - min + 1) + min);
    }
}
