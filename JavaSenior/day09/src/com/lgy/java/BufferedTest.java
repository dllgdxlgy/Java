package com.lgy.java;

import org.junit.Test;

import java.io.*;

/**
 * @author LGY
 * @create 2021-09-07 12:46
 */
public class BufferedTest {

    @Test
    public void BufferedStreamTest(){
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;

        try {
            //1,造文件
            File srcFile = new File("爱情与友情.jpg");
            File desFile = new File("爱情与友情6.jpg");

            //2.造流
            //2.1造节点流
            FileInputStream fis = new FileInputStream(srcFile);
            FileOutputStream fos = new FileOutputStream(desFile);
            //2.2造缓冲流（处理流）
            bis = new BufferedInputStream(fis);
            bos = new BufferedOutputStream(fos);


            //3.复制的细节：读取和写入的过程
            byte[] buffer = new byte[10];
            int len;
            while ((len = bis.read(buffer))!=-1) {
                bos.write(buffer,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4.资源关闭，要求，先关闭外层的流，在关闭内层的流
            if(bos!=null){
                try {
                    bos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (bis!=null) {
                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            //关闭外层流的同时，内层流也会自动进行关闭，关于内层流的关闭，我们可以省略。
//        fos.close();
//        fis.close();
        }


    }
}
