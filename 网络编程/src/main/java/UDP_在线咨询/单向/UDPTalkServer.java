package UDP_在线咨询.单向;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 *  * 多次接收端
 *  * 1. 使用DatagramSocket 指定端口 创建接收端
 *  *  * 2. 准备容器 封装成DatagramPacket 包裹
 *  *  * 3. 阻塞式接收包裹receive(DatagramPacket p)
 *  *  * 4. 分析数据
 *  *  *      byte[] getData()
 *  *  *             getLength()
 *  *  * 5. 释放资源
 * @author: duhao
 * @date: 2020/6/18 21:27
 */
public class UDPTalkServer {
    public static void main(String[] args) throws IOException {
        System.out.println("开始接收...");
        DatagramSocket datagramSocket = new DatagramSocket(6666);
        while (true) {
            //2.准备容器  都是字节数组
            byte[] container = new byte[1024];
            DatagramPacket packet = new DatagramPacket(container, 0, container.length);
            datagramSocket.receive(packet);
            //4.分析数据
            int length = packet.getLength();
            byte[] datas = packet.getData();
            String data = new String(datas, 0, length);
            System.out.println(data);
            if (data.equals("Bye")){
                  break;
            }
        }
        // 释放资源
        datagramSocket.close();
    }
}
