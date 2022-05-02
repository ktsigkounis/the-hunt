package com.lotr.hunt.util;

/**
 * @author Konstantinos Tsigkounis
 * @date 01/05/2022
 */
public enum PlayerAction {
    EXIT("E","Exit"),
    ATTACK("A", "Attack"),
    INFO("I", "Hero's information"),
    MOVE_FORWARD("MF", "Move forward"),
    MOVE_BACK("MB", "Move back"),
    SEARCH_CHEST("S", "Search chest");

    PlayerAction(String command, String display){
        this.command = command;
        this.display = display;
    }

    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }

    public String getDisplay() {
        return display;
    }

    public void setDisplay(String display) {
        this.display = display;
    }

    private String command;
    private String display;
}
