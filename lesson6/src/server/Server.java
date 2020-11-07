package server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {

    private static ServerSocket server;
    private static Socket socket;
    private static final int PORT = 80;

    private static DataInputStream in;
    private static DataOutputStream out;
    private static Scanner scanner;

    public static void main(String[] args) {
        try {
            server = new ServerSocket( PORT );
            System.out.println(" Сервер запущен ");
            socket = server.accept();
            System.out.println("Клиент подлючен "+ socket.getRemoteSocketAddress());
            in = new DataInputStream(socket.getInputStream() );
            out = new DataOutputStream(socket.getOutputStream() );
            scanner = new Scanner( System.in );

            new Thread(() -> {
                try {
                    while (true) {
                        String strClient = in.readUTF();
                        if (strClient.equals("/end")) {
                            break;
                        }

                        System.out.println("Клиент: " + strClient);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    try {
                        server.close();
                        socket.close();
                        scanner.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }).start();

            while (true) {
                String str = scanner.nextLine();
                System.out.println("Вы: " + str);
                out.writeUTF( str );
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
