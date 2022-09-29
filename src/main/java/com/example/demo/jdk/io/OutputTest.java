package com.example.demo.jdk.io;

import java.io.*;
import java.nio.charset.StandardCharsets;

/**
 * @author dou.guo
 * @version InputTest, v 0.1 2022-09-27 2:10 下午 dou.guo Exp $
 */
public class OutputTest {

    //获取字节流
    static void outputStream() throws IOException {
        //由编译器来关闭字资源
        try (OutputStream outputStream = new FileOutputStream("src/io")){
            outputStream.write("outputStream".getBytes("UTF-8"));
        }
    }

    //获取字符流
    static void writer() throws IOException {
        try (Writer writer = new FileWriter("src/io")){
            writer.write("writer");
        }
    }


    public static void main(String[] args) throws IOException {
        writer();
        outputStream();
    }
}
