package com.lgy.java1;

import org.junit.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 关于TCP网络编程
 * 从客户端发送文件给服务器，服务端保存到本地，并返回"发送成功"给客户端
 *
 * @author LGY
 * @create 2021-10-13 08:50
 */
public class TCPTest3 {

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

        //告诉服务器，我已经传完了
        socket.shutdownOutput();




        //5.将服务器返回端数据进行展示，接收服务器端的数据
        InputStream is = socket.getInputStream();
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        byte[] buffer1 = new byte[20];
        int len1;
        while ((len1=is.read(buffer1))!=-1){
            baos.write(buffer,0,len1);
        }
        System.out.println(baos.toString());



        //6.资源关闭
        fis.close();
        os.close();
        socket.close();

        baos.close();
    }


    @Test
    public void server() throws Exception{

        ServerSocket serverSocket = new ServerSocket(9090);

        //表示可以接收来自于客户端端socket
        Socket socket = serverSocket.accept();

        //从socket里面读入输入流
        InputStream is = socket.getInputStream();

        FileOutputStream fos = new FileOutputStream(new File("beautylgy3.jpg"));
        byte[] buffer = new byte[1024];

        int len;
        while ((len = is.read(buffer))!=-1){
            fos.write(buffer,0,len);
        }


        //服务器端给客户端反馈

        OutputStream os = socket.getOutputStream();
        os.write("你好，服务器端，数据我已收到".getBytes());


        //关闭资源
        serverSocket.close();
        socket.close();
        is.close();
        fos.close();

        os.close();
    }


}
