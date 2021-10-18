package com.lgy.java1;

import org.junit.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *使用TCP网络编程
 * 客户端发送文件给服务端，服务端将文件保存在本地
 *
 * @authorLGY
 * @create 2021-10-13 08:30
 */
public class TCPTest2 {

    /**
     * 这里涉及端异常，并没有处理
     * @throws Exception
     */
    @Test
    public void client() throws Exception{

        //1.创建socket
        InetAddress inetAddress = InetAddress.getByName("127.0.0.1");
        Socket socket = new Socket(inetAddress,9090);

        //2.获取输出流
        OutputStream os = socket.getOutputStream();

        //3.获取输入流
        FileInputStream fis = new FileInputStream(new File("beauty.jpg"));

        //4.读写过程
        byte[] buffer = new byte[1024];
        int len;
        while ((len=fis.read(buffer))!=-1){
            os.write(buffer,0,len);
        }

        //5。资源关闭
        fis.close();
        os.close();

        socket.close();
    }


    /**
     * 这里涉及端异常，并没有处理
     * @throws Exception
     */
    @Test
    public void server() throws Exception{

        ServerSocket serverSocket = new ServerSocket(9090);

        //表示可以接收来自于客户端端socket
        Socket socket = serverSocket.accept();

        //从socket里面读入输入流
        InputStream is = socket.getInputStream();

        FileOutputStream fos = new FileOutputStream(new File("beautylgy.jpg"));
        byte[] buffer = new byte[1024];

        int len;
        while ((len = is.read(buffer))!=-1){
            fos.write(buffer,0,len);
        }

        serverSocket.close();
        socket.close();
        is.close();
        fos.close();

    }

}
