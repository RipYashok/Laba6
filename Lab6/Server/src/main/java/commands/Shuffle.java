package commands;

import model.Route;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class Shuffle extends Command{
    public Shuffle(){
        setTitle("shuffle");
        setDescription(" - перемешать элементы коллекции в случайном порядке");
    }

    public String execute(ArrayList<Route> collection, String value, Route route) throws IOException {
        Collections.shuffle(collection);
        return "Коллекция перемешана.";
    }
}
