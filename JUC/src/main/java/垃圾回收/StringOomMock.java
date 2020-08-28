package 垃圾回收;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: duhao
 * @date: 2020/8/20 14:55
 */
public class StringOomMock {
    static String  base = "string";
    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        for (int i=0;i< Integer.MAX_VALUE;i++){
            String str = base + base;
            base = str;
            list.add(str.intern());
        }
    }


}
