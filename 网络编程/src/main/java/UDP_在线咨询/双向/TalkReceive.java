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
        while (true) {

            try {
                //2.准备容器  都是字节数组
                byte[] container = new byte[1024];
                DatagramPacket packet = new DatagramPacket(container, 0, container.length);
                //4.分析数据
                int length = packet.getLength();
                byte[] datas = packet.getData();
                String data = new String(datas, 0, length);
                System.out.println(data);
                if (data.equals("Bye")){
                    break;
                }
                server.receive(packet);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        // 释放资源
        server.close();
    }
}
