package UDP_在线咨询.双向;

/**加入多线程,实现双向交流,模拟在线咨询
 * @author: duhao
 * @date: 2020/6/18 22:34
 */
public class TalkStudent {
    public static void main(String[] args) {
        new Thread(new TalkSend(7777,"localhost",9999)).start();//发送
        new Thread(new TalkReceive(6666)).start();//接受
    }
}
