package Service;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class AndroidServer implements Runnable {
    @Override
    public void run() {
        try {
            ServerSocket serverSocket = new ServerSocket(80);
            while (true){
                System.out.println("等待接收用户连接...");
                Socket client = serverSocket.accept();
                //接收信息
                BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
                String str = in.readLine();
                PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(client.getOutputStream())),true);
                out.println("return  "+str);
                in.close();
                out.close();
                client.close();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
