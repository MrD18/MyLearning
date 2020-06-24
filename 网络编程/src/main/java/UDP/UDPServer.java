package UDP;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * 接收端
 * 1. 使用DatagramSocket 指定端口 创建接收端
 *  * 2. 准备容器 封装成DatagramPacket 包裹
 *  * 3. 阻塞式接收包裹receive(DatagramPacket p)
 *  * 4. 分析数据
 *  *      byte[] getData()
 *  *             getLength()
 *  * 5. 释放资源
 * @author: duhao
 * @date: 2020/6/17 22:03
 */
public class UDPServer {
    public static void main(String[] args) throws Exception {
        System.out.println("开始接收....");
        DatagramSocket datagramSocket = new DatagramSocket(6666);
        byte[] container = new byte[1024];
        DatagramPacket packet = new DatagramPacket(container,0,container.length);
          datagramSocket.receive(packet);
        //4. 分析数据
        byte[] datas = packet.getData();
        int len = packet.getLength();
        System.out.println(new String(datas,0,len));


    }
}
