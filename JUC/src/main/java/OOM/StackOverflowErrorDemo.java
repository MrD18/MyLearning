package OOM;

/**经典错误  StackoverFlowError ：栈溢出
 * @author: duhao
 * @date: 2020/6/30 14:53
 */
// 堆栈溢出,程序递归太深, 深度的方法调用
// 栈一般是512k, 不断的深度调用,直到栈被撑破
public class StackOverflowErrorDemo {
    public static void main(String[] args) {
        stackOverflowError();
    }
    /**
     * 栈一般是512K，不断的深度调用，直到栈被撑破
     * Exception in thread "main" java.lang.StackOverflowError
     */
private static  void stackOverflowError(){
        stackOverflowError();
}

}
/**常见原因:
 *  无限递归循环调用(常见)
 *  执行大量方法,导致线程空间耗尽
 *  方法内声明了海量的局部变量
 * 解决方法:
 *    排查解决死循环问题
 *    将栈空间增大
 *    -Xss, 正常取值128K~256K, 如果仍然不够可以进行加大, 这个选项对性能影响比较大，需要严格测试
 */