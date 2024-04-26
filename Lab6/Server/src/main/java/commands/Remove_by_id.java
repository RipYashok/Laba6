package commands;

import model.Route;
import sereverChannel.utils.Answer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Remove_by_id extends Command{
    public Remove_by_id(){
        setTitle("remove_by_id");
        setDescription(" {id} - удалить элемент из коллекции по его id");
    }

    public String execute(ArrayList<Route> collection, String value, Route route) throws IOException {
        String answer = "";
        try {
            int idValue = Integer.parseInt(value);
            Route foundRoute = collection.stream()
                    .filter(r -> r.getId().equals(idValue))
                    .findFirst()
                    .orElse(null);

            if (foundRoute != null) {
                collection.remove(foundRoute);
                answer = "Маршрут с Id = " + value + " удален";
            } else {
                answer = "Маршрута с Id = " + value + " нет в коллекции";
            }
        } catch (NumberFormatException e) {
            answer = "Id является числом!";
        }
        return answer;
    }
}
