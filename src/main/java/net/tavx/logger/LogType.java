package net.tavx.logger;

public enum LogType {

    LOG("LOG", "&a"),
    DEBUG("DEBUG", "&b"),
    WARNING("WARNING", "&6"),
    ERROR("ERROR", "&c");

    private final String name, color;

    LogType(String name, String color) {
        this.name = name;
        this.color = color;
    }

    public String getName() {
        return this.name;
    }

    public String getColor() {
        return this.color;
    }

}
