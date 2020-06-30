package com.yss.other.装饰者模式.咖啡;

/**模拟咖啡
 * 1. 抽象组件: 需要装饰的抽象对象(接口或抽象父类)
 * 2. 具体组件:需要装饰的对象
 * 3. 抽象装饰类:包含了抽象组件的引用以及装饰着共有的方法
 * 4. 具体装饰类:被装饰的对象
 * @author: duhao
 * @date: 2020/6/30 21:43
 */
public class DecorateTest {
    public static void main(String[] args) {
        Drink coffee = new Coffee();
        Drink suger=new Suger(coffee); //装饰
        System.out.println(suger.info()+"-->"+suger.cost());
        Drink milk = new Milk(coffee);//装饰
        System.out.println(milk.info()+"-->"+milk.cost());
// 在不改变原来的代码上, 直接运用装饰丢进去,来完成新的功能

    }
}

//接口  抽象组件
interface  Drink{
    double cost();//费用
    String info();//说明
}
//具体组件
class Coffee implements Drink{
private  String name="原味咖啡";
    @Override
    public double cost() {
        return 10;
    }

    @Override
    public String info() {
        return name;
    }
}

//抽象装饰类  加牛奶 加糖
abstract class Decorate implements Drink{
   // 对抽象组件的引用
    private Drink drink;

    public Decorate(Drink drink) {
        this.drink = drink;
    }

    @Override
    public double cost() {
        return this.drink.cost();
    }

    @Override
    public String info() {
        return this.drink.info();
    }
}

//具体的抽象类
class Milk extends Decorate{

    public Milk(Drink drink) {
        super(drink);
    }

    @Override
    public double cost() {
        return super.cost()*4;
    }

    @Override
    public String info() {
        return super.info()+"加了牛奶";
    }
}

class Suger extends Decorate{

    public Suger(Drink drink) {
        super(drink);
    }

    @Override
    public double cost() {
        return super.cost()*2;
    }

    @Override
    public String info() {
        return super.info()+"加了糖";
    }
}
