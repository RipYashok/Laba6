package commands;

import model.Route;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Info extends Command{
    public Info(){
        setTitle("info");
        setDescription(" - вывести в стандартный поток вывода информацию о коллекции");
    }


    public String execute(ArrayList<Route> collection, Route value) {
        String answer = "";
        Date initTime = new Date();
        answer = "Тип коллекции: ArrayList" + "\n" +
                "Дата инициализации: " + initTime + "\n" +
                "Количество элементов: " + collection.size();
        return answer;
    }
}
