package UDP;

import java.net.*;

/**
 * 发送端
 * 1. 使用DatagramSocket 指定端口 创建接发送端
 * 2. 准备数据  一定转成字节数组
 * 3. 封装成DatagramPacket 包裹,需要指定目的地
 * 4. 发送包裹send(DatagramPacket p)
 * 5. 释放资源
 *
 * @author: duhao
 * @date: 2020/6/17 22:05
 */
public class UdpClient {
    public static void main(String[] args) throws Exception {
        System.out.println("开始发送");
        // 1. 使用DatagramSocket 指定端口 创建接发送端
        DatagramSocket datagramSocket = new DatagramSocket(8888);
        // 2. 准备数据  一定转成字节数组
        String data="都昊小学生";
        byte[] dataBytes = data.getBytes();
        // 3. 封装成DatagramPacket 包裹,需要指定目的地
        DatagramPacket datagramPacket = new DatagramPacket(dataBytes,0,dataBytes.length,
                 new InetSocketAddress("localhost",6666));
        // 4. 发送包裹send(DatagramPacket p)
          datagramSocket.send(datagramPacket);
    // 5. 释放资源
        datagramSocket.close();

    }
}
