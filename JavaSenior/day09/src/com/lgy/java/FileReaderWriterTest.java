package com.lgy.java;

import org.junit.Test;

import java.io.*;

/**
 * @author LGY
 * @create 2021-09-06 20:11
 */

public class FileReaderWriterTest {

    @Test
    public void  testFileReader() throws IOException {

        File file = new File("hello.txt");

        FileReader fr = new FileReader(file);

        int data = fr.read();

        while (data != -1){
            System.out.print((char)data);
            data = fr.read();
        }
        fr.close();
    }

    //测试从内存中写出数据到硬盘文件里
    @Test
    public void testFileWriter()  {

        //1. 提供File类的对象，指明要写出的文件，如果文件不存在，这时候会自动创建文件
        //如果存在，就是对原有文件的覆盖
        FileWriter fw = null;
        try {
            File file = new File("lgyhello1.txt");//此时文件一定要存在

            //2. 提供FileWriter的对象，用于文件的写出
            fw = new FileWriter(file);

            //3. 写出的操作
            fw.write("我要挣钱了");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {

            if (fw != null)
                try {
                    fw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }

        //4.流的关闭




    }


    //读入文件然后进行写出文件
    @Test
    public void testFileReaderFileWriter()  {
        FileReader fileReader = null;
        FileWriter fileWriter = null;

        try {
            //1.创建File类的对象，指明读入和写入的文件
            File srcfile = new File("hello.txt");
            File desfile = new File("hello2.txt");

            //2.创建输入流和输出流的对象

            fileReader = new FileReader(srcfile);
            fileWriter = new FileWriter(desfile);


            //3.数据的读入和写入操作

            char[] cbuf = new char[5];

            int len = 0;

            while ((len = fileReader.read(cbuf))!= -1){

                //每次写出len个字符
                fileWriter.write(cbuf,0,len );
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4.关闭流资源
            try {
                fileReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                fileWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }





    }


}
