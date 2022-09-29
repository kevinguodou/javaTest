package com.example.demo.jdk.io;

import java.io.*;

/**
 * @author dou.guo
 * @version InputTest, v 0.1 2022-09-27 2:10 下午 dou.guo Exp $
 */
public class InputTest {

    //获取字节流
    static void inputStream() throws IOException {
        //由编译器来关闭字资源
        try (InputStream inputStream = new FileInputStream("src/io")){
            int n;
            while ((n=inputStream.read())!=-1){
                System.out.println(n);
            }
        }
    }

    //获取字符流
    static void reader() throws IOException {
        try (Reader reader = new FileReader("src/io")){
            int n;
            char[] buffer = new char[100];
            //缓冲区，一次读取多个字符到缓冲区
            while ((n=reader.read(buffer))!=-1){
                System.out.println(buffer);
            }
        }
    }


    public static void main(String[] args) throws IOException {
        reader();
        inputStream();
    }
}
