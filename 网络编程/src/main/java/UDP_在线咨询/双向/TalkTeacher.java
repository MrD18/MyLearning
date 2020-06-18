package UDP_在线咨询.双向;

/**加入多线程,实现双向交流,模拟在线咨询
 * @author: duhao
 * @date: 2020/6/18 22:35
 */
public class TalkTeacher {
    public static void main(String[] args) {
//        new Thread(() -> {
//                  new TalkReceive(9999);
//                }, "接收").start();
//
new Thread(new TalkReceive(9999)).start();    //接收
    }
}
