package commands;

import model.Route;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Shuffle extends Command{
    public Shuffle(){
        setTitle("shuffle");
        setDescription(" - перемешать элементы коллекции в случайном порядке");
    }

    public Route execute(Scanner scanner, String value) {
        return null;
    }
}
