package Java并发编程基础.狂神说.Lambda衍变;

/**
 * 来衍变Lambda的一步一步推到
 *
 * @author: duhao
 * @date: 2021/4/19 19:45
 */
public class TestLambda {
    // 3. 静态内部类--->static 修饰, 在大类里面(之前测试是在外面放着)
    static class Love2 implements ILove {

        @Override
        public void love(int a) {
            System.out.println("I love you->" + a);
        }
    }

    public static void main(String[] args) {
        //2.1测试
        ILove love = new Love();
        love.love(520);

        //3.1测试静态内部类
        love = new Love2();
        love.love(521);

        // 4. 局部内部类-->在方法内部类
        class Love3 implements ILove {

            @Override
            public void love(int a) {
                System.out.println("I love you->" + a);
            }
        }
        //4.1测试局内部类
        love = new Love3();
        love.love(522);

        // 5. 匿名内部类
        love = new ILove() {
            @Override
            public void love(int a) {
                System.out.println("I love you->" + a);
            }
        };
        //5.1 测试匿名内部类
        love.love(523);

        //6. 匿名内部类简写
        love = (int a) -> {
            System.out.println("I love you->" + a);
        };
        // 6.1 测试简写
        love.love(525);

        // 7. 匿名继续简写
        love = a -> {
            System.out.println("I love you->" + a);
        };
        // 7.1 简写测试

        love.love(530);
    }

    /**总结:
     * 1.接口中只有一个方法,是函数式编程
     * 2.如果只有一个参数的,可以不写类型
     * 3.如果只有一个输出体的话,可以不写{}
     * 4. 两个参数,要么都写类型(int a,int b)->{},要么都不写(a,b)->{}
     * 5.Lambda表达式只能有一行代码的情况下,才能简化成一行,如果是多行,那么就用代码块包裹
     *
     */

}

//1.定义一个函数式接口
interface ILove {
    void love(int a);
}

//2.实现类
class Love implements ILove {

    @Override
    public void love(int a) {
        System.out.println("I love you->" + a);
    }
}