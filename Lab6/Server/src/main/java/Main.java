import model.Route;
import sereverChannel.ServerMain;
import sereverChannel.utils.FileScan;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        String fileCollection = System.getenv("Collection");
        ArrayList<Route> collection = FileScan.scan(fileCollection);
        ServerMain server = new ServerMain();
        server.Server(collection, fileCollection);
    }
}

