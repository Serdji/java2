package client;


import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    private static ServerSocket server;
    private static Socket socket;
    private static final int PORT = 80;
    private static final String IP = "localhost";

    private static DataInputStream in;
    private static DataOutputStream out;
    private static Scanner scanner;

    public static void main(String[] args) {

        try {
            socket = new Socket( IP, PORT );
            in = new DataInputStream(socket.getInputStream() );
            out = new DataOutputStream(socket.getOutputStream() );
            scanner = new Scanner( System.in );

            new Thread( () -> {
                try {
                    while (true) {
                        String strServer = in.readUTF();
                        if (strServer.equals("/end")) {
                            break;
                        }
                        System.out.println("Сервер: " + strServer);

                    }
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    try {
                        socket.close();
                        scanner.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            } ).start();

            while ( true ) {
                String str = scanner.nextLine();
                System.out.println("Вы: " + str);
                out.writeUTF( str );
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
