package com.lgy.java1;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 实现TCP的网络编程
 * 例子1：客户端发送一段话给服务端，服务端将数据显示在控制台
 *
 * @author LGY
 * @create 2021-10-12 20:46
 */
public class TCPTest1 {


    //客户端
    @Test
    public void client()  {
        Socket socket = null;
        OutputStream os = null;


        try {

            //1.创建Socket对象，指明服务端端地址
            //这里放的是服务器的地址
            InetAddress inetAddress = InetAddress.getByName("127.0.0.1");

            //指明服务器端口号
            //创建Socket，传服务器地址和端口号
            socket = new Socket(inetAddress,8899);


            //2.获取输出流，用于输出数据
            os = socket.getOutputStream();

            //3.写出数据操作
            os.write("你好，我是客户端妹妹".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {

            //4.关闭资源
            if (os!=null){
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (socket!=null){
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }


        }

    }

    //服务端
    @Test
    public void server() {
        ServerSocket serverSocket = null;
        Socket socket = null;
        InputStream is = null;
        ByteArrayOutputStream byteArrayOutputStream = null;

        try {

            //1.创建服务器端端Socket（serverSocket），指明自己的端口号就可以，自己的IP自己知道
            //参数是指明自己的端口号
            serverSocket = new ServerSocket(8899);

            //2.调用ccept()方法，表示接收来自于客户端的socket
            //说明可以接收客户端的socket
            socket = serverSocket.accept();

            //3.获取输入流
            is = socket.getInputStream();


            //不建议这样写，可能会出现乱码
//        byte[] buffer = new byte[20];
//
//        int len;
//        while ((len = is.read(buffer)) != -1){
//            String str = new String(buffer,0,len);
//            System.out.println(str);
//        }

            //4.读取输入流中的数据
            byteArrayOutputStream = new ByteArrayOutputStream();

            byte[] buffer = new byte[5];
            int len;
            while ((len = is.read(buffer)) != -1){
                String str = new String(buffer,0,len);
                byteArrayOutputStream.write(buffer,0,len);
            }

            System.out.println(byteArrayOutputStream.toString());


            System.out.println(socket.getInetAddress());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {

            //5.资源的关闭
            if (byteArrayOutputStream!=null){
                try {
                    byteArrayOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (is!=null){
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (socket!=null){
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
            if (serverSocket!=null){

                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }


}
