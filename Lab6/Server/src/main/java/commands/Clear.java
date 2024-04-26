package commands;

import model.Route;

import java.io.IOException;
import java.util.ArrayList;

public class Clear extends Command{
    public Clear(){
        setTitle("clear");
        setDescription(" - очистить коллекцию");
    }

    public String execute(ArrayList<Route> collection, String value, Route route) throws IOException {
        collection.clear();
        return "Коллекция очищена.";
    }
}
