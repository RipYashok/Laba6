package clientChannel.utils;

import commands.Command;
import model.Route;

import java.io.Serializable;
import java.util.List;

public class Packet implements Serializable {
    private Command command;
    private Route route;
    private String value;

    public Packet() {}


    public Command getCommand() {
        return command;
    }

    public void setCommand(Command command) {
        this.command = command;
    }

    public Route getRoute() {
        return route;
    }

    public void setRoute(Route route) {
        this.route = route;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
