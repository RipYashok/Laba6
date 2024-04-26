package commands;

import model.Route;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;

public class Save extends Command{

    public Save(){
        setTitle("save");
        setDescription(" - сохранить коллекцию в файл");
    }

    public String execute(ArrayList<Route> collection, String fileCollection) {

        try (FileOutputStream fileOutputStream = new FileOutputStream(fileCollection)) {
            for (int i = 0; i < collection.size(); i++) {
                fileOutputStream.write(collection.get(i).toString().getBytes());
                fileOutputStream.write("\n".getBytes());
            }
        } catch (IOException e) {
            // Обработка возможных исключений ввода-вывода
            e.printStackTrace();
        }
        Collections.sort(collection);
        System.out.println("Изменения в коллекции сохранены.");
        return null;
    }
}
