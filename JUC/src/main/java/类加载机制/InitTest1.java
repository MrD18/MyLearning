package 类加载机制;

/**初始化阶段
 * @author: duhao
 * @date: 2020/8/26 14:00
 */
public class InitTest1 {

    static {
      int i=0;
        System.out.println(i);
    }
    static  int i=1;
}
