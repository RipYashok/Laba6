package commands;

import model.Route;

import java.io.IOException;
import java.util.ArrayList;

public class Average_of_distance extends Command{
    public Average_of_distance(){
        setTitle("average_of_distance");
        setDescription(" - вывести любой объект из коллекции, значение поля coordinates которого является минимальным");
    }

    public String execute(ArrayList<Route> collection, String value, Route route) throws IOException {
        double avg = collection.stream()
                .mapToDouble(Route::getDistance)
                .average()
                .orElse(0); // Если коллекция пустая, возвращаем 0
        return "Среднее значение дистанции в коллекции: " + avg;
    }
}
