package commands;

import model.Route;

import java.io.IOException;
import java.util.ArrayList;

public class Min_by_coordinates extends Command{
    public Min_by_coordinates(){
        setTitle("min_by_coordinates");
        setDescription(" - вывести любой объект из коллекции, значение поля coordinates которого является минимальным");
    }


    public String execute(ArrayList<Route> collection, String value, Route route) throws IOException {
        String answer = "";
        Show show = new Show();

        Route minRoute = collection.stream()
                .min((r1, r2) -> {
                    double sumCoor1 = r1.getCoordinates().getX() + r1.getCoordinates().getY();
                    double sumCoor2 = r2.getCoordinates().getX() + r2.getCoordinates().getY();
                    return Double.compare(sumCoor1, sumCoor2);
                })
                .orElse(null);

        if (minRoute == null) {
            answer = "Коллекция пуста.";
            }
        else {
            ArrayList<Route> minRouteList = new ArrayList<>();
            minRouteList.add(minRoute);
            answer = show.execute(minRouteList, value, route);
        }

        ArrayList<Route> minRouteList = new ArrayList<>();
        minRouteList.add(minRoute);

        return answer;
    }
}
