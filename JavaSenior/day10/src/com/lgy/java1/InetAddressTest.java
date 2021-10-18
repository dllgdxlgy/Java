package com.lgy.java1;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * 网络编程中要解决的问题是
 * 1. 如何准确的定位到网络上一台或者多台主机，定位主机上的应用
 * 2. 找到主机后如何可靠性高效的传输
 *
 * 对应问题一：提供IP和端口号
 * 对应问题二：提供网络通信协议：TCP/IP（应用层、传输层、网络层。。。）
 *
 * IP：唯一的标示一台主机
 * InetAddress类代表IP
 *
 * 域名：www.baidu.com
 *
 *
 * 端口号：正在计算机上运行的进程
 *
 *
 *
 * @author LGY
 * @create 2021-10-12 20:17
 */
public class InetAddressTest {

    public static void main(String[] args) {
        try {

            //类似于 File file = new File("Hello.txt");
            InetAddress inetAddress = InetAddress.getByName("192.168.31.39");
            System.out.println(inetAddress);


            //域名
            InetAddress inetAddress1 = InetAddress.getByName("www.baidu.com");
            System.out.println(inetAddress1);

            InetAddress inetAddress2 = InetAddress.getByName("127.0.0.1");
            System.out.println(inetAddress2);

            //直接获取本机的地址
            InetAddress inetAddress3 = InetAddress.getLocalHost();
            System.out.println(inetAddress3);

            //获取主机域名
            System.out.println(inetAddress1.getHostName());

            //获取主机的地址
            System.out.println(inetAddress1.getHostAddress());


        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }






}
