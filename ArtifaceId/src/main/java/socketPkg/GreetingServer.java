package socketPkg;

import java.net.*;
import java.io.*;
import java.util.Date;



public class GreetingServer extends Thread
{
    private ServerSocket serverSocket;

    public GreetingServer(int port) throws IOException
    {
        serverSocket = new ServerSocket(port);
        serverSocket.setSoTimeout(10000);
    }

    public void run()
    {
        while(true)
        {
            try
            {
                System.out.println("等待远程连接，端口号为 " + serverSocket.getLocalPort() + "...");

                // 等待客户端连接后返回
                Socket server = serverSocket.accept();
                System.out.println("远程主机地址 " + server.getRemoteSocketAddress() );

                // 等待接收客户端的消息
                System.out.print("等待接收客户端消息：");
                DataInputStream in = new DataInputStream(server.getInputStream());
                System.out.println(in.readUTF());

                System.out.print("(延时3s) ");
                try { Thread.sleep(3000);}catch(InterruptedException e){ e.printStackTrace();}

                // 发送消息到客户端
                System.out.println("发送消息到客户端.");
                DataOutputStream out = new DataOutputStream(server.getOutputStream());
                out.writeUTF("谢谢连接我, " + server.getLocalSocketAddress() + ". Goodbye!");

                // 关闭连接
                System.out.println("关闭当前连接.");
                server.close();
            }
            catch(SocketTimeoutException s){ System.out.println("Socket timed out!");    break; }
            catch(IOException e){ e.printStackTrace();break;}
        }
    }

    public static void main(String [] args)
    {

        int port = Integer.parseInt(/*args[0]*/  "6066");
        try
        {
            Thread t = new GreetingServer(port);
           // t.run();
            t.start();

//            GreetingServer ser = new GreetingServer(port);
//            ser.run();



        }catch(IOException e)
        {
            e.printStackTrace();
        }
    }
}
