package com.hanyuling.jvm;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;

public class HttpServer {
    /**
     * WEB_ROOT是HTML和其它文件存放的目录. 这里的WEB_ROOT为工作目录下的webroot目录
     */
    public static final String WEB_ROOT = System.getProperty("user.dir") + File.separator + "webroot";

    // 关闭服务命令
    private static final String SHUTDOWN_COMMAND = "/SHUTDOWN";

    public static void main(String[] args) {
        HttpServer server = new HttpServer();
        //等待连接请求
        server.await();
    }

    public void await() {
        ServerSocket serverSocket = null;
        int port = 8080;
        try {
            //服务器套接字对象
            serverSocket = new ServerSocket(port, 1, InetAddress.getByName("127.0.0.1"));
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }

        // 循环等待一个请求
        while (true) {
            Socket socket = null;
            InputStream input = null;
            OutputStream output = null;
            try {
                //等待连接，连接成功后，返回一个Socket对象
                socket = serverSocket.accept();
                input = socket.getInputStream();
                output = socket.getOutputStream();
                byte[] buffer = new byte[25];
                int len = -1;
                int read = 0;
                while ((read = input.read()) != -1) {
                    System.out.println("===========" + (byte)read);
                }
                System.out.println("===========");
                System.out.println(Thread.currentThread().getName());
                output.write(Arrays.copyOf(buffer, buffer.length));
                // 关闭 socket 对象
//                socket.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
