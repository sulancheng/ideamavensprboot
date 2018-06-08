package com.light.springboot.websocketconfig;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by Administrator
 * on 2018/6/6.
 */
public class SocketServer {
    static ServerSocket serverSocket = null;

    /**
     * 启动服务监听，等待客户端连接
     */
    public static void startService() {
        if (serverSocket != null) return;
        try {
            // 创建ServerSocket
            serverSocket = new ServerSocket(9999);
            System.out.println("--开启服务器，监听端口 9999--");

            // 监听端口，等待客户端连接
            while (true) {
                System.out.println("--等待客户端连接--");
                Socket socket = serverSocket.accept(); //等待客户端连接
                System.out.println("得到客户端连接：" + socket);

                startReader(socket);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 从参数的Socket里获取最新的消息
     */
    private static void startReader(final Socket socket) {

        new Thread() {
            @Override
            public void run() {
                DataInputStream reader;
                try {
                    // 获取读取流
                    reader = new DataInputStream(socket.getInputStream());
                    while (true) {
                        System.out.println("*等待客户端输入*");
                        // 读取数据
                        String msg = reader.readUTF();
                        System.out.println("获取到客户端的信息：" + msg);
                        //发送反馈给客户端
                        OutputStream out = null;
                        out = socket.getOutputStream();
                        out.write("包裹已收到".getBytes());
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }.start();
    }
}
