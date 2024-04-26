package commands;

import model.Route;

import java.io.IOException;
import java.util.ArrayList;

public class Count_less_then_distance extends Command{
    public Count_less_then_distance(){
        setTitle("count_less_then_distance");
        setDescription("{distance} - вывести количество элементов, значение поля distance которых меньше заданного");
    }
    public String execute(ArrayList<Route> collection, String value, Route route_value) throws IOException {
        String answer = "";
        try {
            long distanceValue = Long.parseLong(value);

            long count = collection.stream()
                    .filter(route -> route.getDistance() < distanceValue)
                    .count();
            answer = "Количество элементов, у которых значение поля distance меньше " + value + ": " + count;
        }catch (NumberFormatException e){
            answer = "Нужно ввести дистанцию. Дистанция является целым числом!";
        }
        return answer;
    }
}
