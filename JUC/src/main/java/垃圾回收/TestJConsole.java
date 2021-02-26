package 垃圾回收;

import java.util.ArrayList;
import java.util.List;

/**测试JConsole 监视代码
 * @author: duhao
 * @date: 2020/12/18 12:02
 */
public class TestJConsole {
    static  class OOMObject {

        public byte[] placeholder = new byte[64 * 1024];
    }

    public  static void fillHeap(int num) throws InterruptedException {
        List<OOMObject> list = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            //稍作延迟,令监视曲线的变化更明显
            Thread.sleep(50);
            list.add(new OOMObject());
        }
        System.gc();
    }

    public static void main(String[] args) throws InterruptedException {
        fillHeap(1000);
    }
}
