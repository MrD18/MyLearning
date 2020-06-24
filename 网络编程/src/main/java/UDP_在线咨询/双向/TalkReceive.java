package UDP_在线咨询.双向;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**接收端
 * @author: duhao
 * @date: 2020/6/18 22:17
 */
public class TalkReceive implements Runnable {
    private DatagramSocket server;

  public TalkReceive(int port){
      try {
          server = new DatagramSocket(port);
      } catch (SocketException e) {
          e.printStackTrace();
      }
  }
    @Override
    public void run() {
        System.out.println("开始接收...");

        while (true) {
            DatagramPacket packet;
            try {
                //2.准备容器  都是字节数组
                byte[] container = new byte[1024];
                packet  = new DatagramPacket(container, 0, container.length);
                server.receive(packet);
                //4.分析数据
                int length = packet.getLength();
                byte[] datas = packet.getData();
                String data = new String(datas, 0, length);
                System.out.println(data);
                if (data.equals("Bye")){
                    break;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        // 释放资源
        server.close();
    }
}
