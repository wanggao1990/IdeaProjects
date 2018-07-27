package socketPkg;

import java.net.*;
import java.io.*;
import java.util.Date;

public class GreetingClient
{
    public static void main(String [] args)
    {
        String serverName = /*args[0]*/ "localhost";   // IP地址
        int port = Integer.parseInt(/*args[1]*/ "6066");
        try
        {
            System.out.println("连接到主机 " + serverName + " ，端口号 " + port);

            Socket client = new Socket(serverName, port);  // 连接成功返回
            System.out.println("远程主机地址 " + client.getRemoteSocketAddress());

            System.out.print("(延时5s) ");
            try { Thread.sleep(5000);}catch(InterruptedException e){ e.printStackTrace();}

            // 发现消息到服务端
            System.out.println("发送消息到客户端.");
            OutputStream outToServer = client.getOutputStream();
            DataOutputStream out = new DataOutputStream(outToServer);
            out.writeUTF("Hello from " + client.getLocalSocketAddress());

            // 等到接收服务端的消息
            System.out.print("等待接收客户端消息：");
            InputStream inFromServer = client.getInputStream();
            DataInputStream in = new DataInputStream(inFromServer);
            System.out.println("服务器响应： " + in.readUTF());

            // 关闭连接
            System.out.println("关闭当前连接.");
            client.close();
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }

    }
}