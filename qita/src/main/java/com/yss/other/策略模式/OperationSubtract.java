package com.yss.other.策略模式;

/*创建实现类接口
 * @author: duhao
 * @date: 2020/8/25 14:24
 */
public class OperationSubtract implements  Strategy{
    @Override
    public int doOperation(int num1, int num2) {
        return num1-num2;
    }
}
