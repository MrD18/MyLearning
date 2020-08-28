package com.yss.other.策略模式;

/**创建 Context 类
 * @author: duhao
 * @date: 2020/8/25 14:27
 */
public class Context {
    private  Strategy strategy;

    public Context(Strategy strategy) {
        this.strategy = strategy;
    }

    public  int executeStrategy(int num1, int num2){
        return strategy.doOperation(num1,num2);
    }
}
