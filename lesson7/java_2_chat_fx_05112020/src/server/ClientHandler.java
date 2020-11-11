package server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Arrays;

public class ClientHandler {
    private Server server;
    private Socket socket;
    private DataInputStream in;
    private DataOutputStream out;

    private String nickname;

    public ClientHandler(Server server, Socket socket) {
        try {
            this.server = server;
            this.socket = socket;
            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());

            new Thread(() -> {
                try {
                    //цикл аутентификации
                    while (true) {
                        String str = in.readUTF();

                        if (str.startsWith("/")) {

                            if (str.startsWith("/auth ")) {
                                String[] token = str.split("\\s",3);
                                if( !server.isUser( token[1] ) ) {
                                    String newNick = server.getAuthService()
                                            .getNicknameByLoginAndPassword(token[1], token[2]);
                                    if (newNick != null) {
                                        nickname = newNick;
                                        out.writeUTF("/authok "+nickname);
                                        server.subscribe(this);
                                        break;
                                    } else {
                                        out.writeUTF("Неверный логин / пароль");
                                    }
                                } else {
                                    out.writeUTF("Такой пользователь уже в сети");
                                }
                            }
                        }
                    }

                    //Цикл работы
                    while (true) {
                        String str = in.readUTF();

                        if (str.equals("/end")) {
                            out.writeUTF("/end");
                            break;
                        } else if (str.startsWith("/w ")) {
                            String[] privatMess = str.split("\\s",3);
                            server.privateMessage( this, privatMess[1], privatMess[2] );
                        } else {
                            server.broadcastMsg(this, str);
                        }

                    }
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    System.out.println("Client disconnected!");
                    server.unsubscribe(this);
                    try {
                        socket.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sendMsg(String msg) {
        try {
            out.writeUTF(msg);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getNickname() {
        return nickname;
    }
}
