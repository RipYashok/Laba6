package commands;

import model.Route;
import sereverChannel.CreateCommands;

import java.util.ArrayList;
import java.util.Map;

public class Help extends Command{
    public Help(){
        setTitle("help");
        setDescription(" - вывести справку по доступным командам");
    }

    public String execute(ArrayList<Route> collection, String value, Route route) {
        Map<String, Command> commandList = CreateCommands.commands();

        return commandList.values().stream()
                .map(command -> command.getTitle() + command.getDescription())
                .reduce("", (acc, str) -> acc + str + "\n");
    }
}
