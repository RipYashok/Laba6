package commands;

import model.Route;

import java.util.ArrayList;
import java.util.Date;

public class Info extends Command{
    public Info(){
        setTitle("info");
        setDescription(" - вывести в стандартный поток вывода информацию о коллекции");
    }


    public String execute(ArrayList<Route> collection, String value, Route route) {
        String answer = "";
        Date initTime = new Date();
        answer = "Тип коллекции: ArrayList" + "\n" +
                "Дата инициализации: " + initTime + "\n" +
                "Количество элементов: " + collection.size();
        return answer;
    }
}
