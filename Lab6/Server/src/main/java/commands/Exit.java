package commands;

import model.Route;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Класс команды завершения программы
 */
public class Exit extends Command{

    public Exit(){
        setTitle("exit");
        setDescription(" - завершить программу (без сохранения в файл)");
    }

    public String execute(ArrayList<Route> collection, String value, Route route) throws IOException {
        return null;
    }
}
