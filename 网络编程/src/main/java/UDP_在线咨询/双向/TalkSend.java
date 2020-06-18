package UDP_在线咨询.双向;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;

/**发送端
 * @author: duhao
 * @date: 2020/6/18 22:17
 */
public class TalkSend implements  Runnable{
        private  DatagramSocket client;
        private BufferedReader  reader;
        private  String toIP; //对方ip
        private  int toPort;//对方端口

    public TalkSend(int port, String toIP, int toPort) {
        this.toIP = toIP;
        this.toPort = toPort;
        // 1. 使用DatagramSocket 指定端口 创建接发送端
        try {
            client = new DatagramSocket(port);
            // 2. 准备数据  一定转成字节数组
            reader = new BufferedReader(new InputStreamReader(System.in));
        } catch (SocketException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void run() {
        while (true) {
            String data;
            try {
                data = reader.readLine();
                byte[] dataBytes = data.getBytes();
                // 3. 封装成DatagramPacket 包裹,需要指定目的地
                DatagramPacket datagramPacket = new DatagramPacket(dataBytes,
                                                                  0,
                                                                   dataBytes.length,
                                                                   new InetSocketAddress(this.toIP, this.toPort));
                // 4. 发送包裹send(DatagramPacket p)
                client.send(datagramPacket);
                if (data.equals("Bye")){
                    break;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        // 5. 释放资源
        client.close();
    }
}
