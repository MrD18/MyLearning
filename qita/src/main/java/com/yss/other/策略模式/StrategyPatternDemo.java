package com.yss.other.策略模式;

/**使用 Context 来查看当它改变策略 Strategy 时的行为变化
 * @author: duhao
 * @date: 2020/8/25 14:30
 */
public class StrategyPatternDemo {
    public static void main(String[] args) {
        Context context = new Context(new OperationAdd());
        System.out.println(context.executeStrategy(10,5));


        context = new Context(new OperationSubtract());
        System.out.println("10 - 5 = " + context.executeStrategy(10, 5));

        context = new Context(new OperationMultiply());
        System.out.println("10 * 5 = " + context.executeStrategy(10, 5));

    }
}
