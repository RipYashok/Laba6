package commands;

import model.Route;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Add extends Command {

    public Add() {
        setTitle("add");
        setDescription(" - добавить новый элемент в коллекцию");
    }

    public void newID(ArrayList<Route> collection, Route route) {
        List<Integer> IdList = new ArrayList<>();
        for (Route object : collection){
            IdList.add(object.getId());
        }
        Collections.sort(IdList);
        int ID = 1;
        for (Integer id : IdList){
            if (ID == id){
                ID++;
            }
            else {
                route.setId(ID);
                break;
            }
        }
        if (ID > IdList.size()){
            route.setId(ID);
        }
    }

    public void newTime(Route route) {
        route.setCreationDate(LocalDate.now());
    }


    public String execute(ArrayList<Route> collection, String value, Route route) {
        newID(collection, route);
        newTime(route);
        collection.add(route);
        Collections.sort(collection);
        return "Коллекция обновлена.";
    }
}
