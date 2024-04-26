package commands;

import model.Route;

import java.io.IOException;
import java.util.ArrayList;

public class Remove_last extends Command{
    public Remove_last(){
        setTitle("remove_last");
        setDescription(" - удалить последний элемент из коллекции");
    }

    public String execute(ArrayList<Route> collection, String value, Route route) throws IOException {
        collection.remove(collection.size()-1);
        return "Удален последний элемент коллекции.";
    }
}
