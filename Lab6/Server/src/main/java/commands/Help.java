package commands;

import model.Route;
import sereverChannel.CreateCommands;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

public class Help extends Command{
    public Help(){
        setTitle("help");
        setDescription(" - вывести справку по доступным командам");
    }

    public String execute(ArrayList<Route> collection, Route value) {
        String answer = "";
        Map<String, Command> commandList = CreateCommands.commands();

        for (String name  : commandList.keySet()){
            answer += commandList.get(name).getTitle() + commandList.get(name).getDescription() + "\n";
        }
        return answer;
    }
}
