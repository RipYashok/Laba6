package sereverChannel;

import commands.Command;
import commands.Exit;
import commands.Save;
import model.Route;
import sereverChannel.utils.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ServerMain {

    public Packet Server(ArrayList<Route> collection, String fileCollection){
        try {
            final int PORT = 666;
            ByteBuffer buffer = ByteBuffer.allocate(1048576);
            DatagramChannel serverChannel = DatagramChannel.open();
            serverChannel.configureBlocking(false);
            serverChannel.socket().bind(new InetSocketAddress(PORT));
            System.out.println("Сервер запущен на порту " + PORT);
            BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
            while (true) {
                SocketAddress clientAddress = serverChannel.receive(buffer);
                if (clientAddress != null) {
                    Packet packet = ServerMain.readClient(buffer);

                    ServerMain.sendToClient(buffer, packet, collection, serverChannel, clientAddress);
                } else{
                    Log.logger("Сервер ожидает запрос.");
                    Thread.sleep(5000);
                }

                if (consoleReader.ready()) {
                    ServerMain.readTerminat(consoleReader, collection, fileCollection);
                }
            }
        } catch(IOException e){
            e.printStackTrace();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (NumberFormatException e){
            throw new RuntimeException(e);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    public static Packet readClient(ByteBuffer buffer) throws Exception {
            buffer.flip();
            byte[] receivedBytes = new byte[buffer.remaining()];
            buffer.get(receivedBytes);
            buffer.clear();
            Packet packet = JsonDeserializer.deserialize(receivedBytes, Packet.class);
        return packet;
    }
    public static void sendToClient(ByteBuffer buffer, Packet packet, ArrayList<Route> collection, DatagramChannel serverChannel, SocketAddress clientAddress) throws Exception {
        Answer answer = new Answer();
        answer.setAnswer(((Command) CreateCommands.commands().get(packet.getCommand().getTitle())).execute(collection, packet.getValue(), packet.getRoute()));
        byte[] jsonBytes = JsonSerializer.serialize(answer);
        buffer.put(jsonBytes);
        buffer.flip();
        serverChannel.send(buffer, clientAddress);
        buffer.clear();
        answer.clear();
    }

    public static void readTerminat(BufferedReader consoleReader, ArrayList<Route> collection, String fileCollection) throws IOException {
        Save save = new Save();
        Exit exit = new Exit();
        String consoleInput = consoleReader.readLine().trim();
        List<String> input = new ArrayList<>(Arrays.asList(consoleInput.split(" ")));
        if (input.get(0).equals(save.getTitle())){
            save.execute(collection, fileCollection);
        } else if (input.get(0).equals(exit.getTitle())) {
            save.execute(collection, fileCollection);
            System.out.println("Завершение работы.");
            System.exit(0);
        }

    }
}



