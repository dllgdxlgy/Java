package com.lgy.java;

import org.junit.Test;

import java.io.*;

/**
 * @author LGY
 * @create 2021-09-07 09:47
 */
public class FileInputOutputStreamTest {




    //用字节流FileInputStream处理文件，可能出现乱吗
    //比如中国人，一个汉字在utf-8里面占3个字节，我们一次取5个，
    //就可能产生乱码。
    @Test
    public void testFileInputStream()  {


        FileInputStream fileInputStream = null;
        try {
            //1.造文件
            File file = new File("hello.txt");

            //2.造流
            fileInputStream = new FileInputStream(file);
            //3.读数据
            byte[] buffer = new byte[5];
            int len;//记录每次读取字节的个数

            while ((len = fileInputStream.read(buffer))!=-1){
                String s = new String(buffer,0,len);
                System.out.print(s);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileInputStream!=null)
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }
    }

    //使用字节流实现对图片对复制
    @Test
    public void Test()  {
        FileInputStream fis = null;//要复制的
        FileOutputStream fos = null;//复制到哪？

        try {
            //造文件
            File srcfile = new File("爱情与友情.jpg");

            File desfile = new File("爱情与友情5.jpg");

            //2.造流
            fis = new FileInputStream(srcfile);
            fos = new FileOutputStream(desfile);

            //复制到过程
            byte[] buffer = new byte[5];
            int len;

            while ((len = fis.read(buffer))!= -1){
                fos.write(buffer,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(fos!=null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fis!=null){
            try {
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        }

    }



    //进一步，指定路径下对文件对复制
    public void  copyFile(String srcPath,String desPath){
        FileInputStream fis = null;//要复制的
        FileOutputStream fos = null;//复制到哪？

        try {
            //造文件
            File srcfile = new File(srcPath);

            File desfile = new File(desPath);

            //2.造流
            fis = new FileInputStream(srcfile);
            fos = new FileOutputStream(desfile);

            //复制到过程
            byte[] buffer = new byte[1024];
            int len;

            while ((len = fis.read(buffer))!= -1){
                fos.write(buffer,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(fos!=null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fis!=null){
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    @Test
    public void testCopyFile(){
        long start = System.currentTimeMillis();
        String srcPath ="";
        String desPath = "";
        copyFile(srcPath,desPath);
        long end = System.currentTimeMillis();
        System.out.println("复制操作花费对时间为"+(end-start));
    }
}
