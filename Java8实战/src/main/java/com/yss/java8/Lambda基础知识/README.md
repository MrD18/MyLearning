## 函数式接口
- java类型系统中的接口
- 只包含一个接口方法的特殊接口
- @Functionallnterface 语义检测注解
- 里面可以包含: 默认方法  静态方法
  - 默认方法使用场景: 在接口中有这默认方法(公共的方法),那么实现它的子类都能实现这个功能---- 需要实现类对象调用
  - 静态方法使用场景: 在接口中有静态方法,那么子类在进行判断的时候,不用再自己类中进行判断,直接调用接口中的静态方法进行判断----需要接口调用

## Lambda语法及应用
- java.util.function.Predicate<T>
  - 接收参数对象T, 返回一个boolen类型的结果
- java.util.function.Comsumer<T>  
  - 接收参数对象T,不返回结果
- java.util.function.Function<T,R>
  - 接收参数对象T, 返回结果对象R 
- java.util.function.Supplier<T>
  - 不接受参数, 提供T对象的创建工厂,或者说直接通过get()获取指定的对象  
- java.util.function.UnaryOperator<T>
  - 接收参数对象T,执行业务处理后,返回更新后结果对象T  
- java.util.function.BinaryOperator<T>
  - 接收两个T对象,执行业务处理后,返回一个T对象结果

## Lambda表达式运行原理
- Lambda表达式基本语法: [接口声明]=(参数)->{执行代码块}
  - 声明:就是和Lambda表达式绑定的接口类型
  - 参数:() 和绑定的接口中的抽象方法中的参数个数及顺序一致
  - 操作符:->
  - 执行代码块:{} 
- 带参数的Lambda表达式
```
ILambda2 i3=(String name,int age)->{
            System.out.println("姓名是:"+name+" 年龄是:"+age);
        };
        i3.test("dddd",28);
```
- 带返回值的Lambda表达式
```
   ILambda3 i4=(a, b)->{
            int z= a+b;
            return z;
        };
        System.out.println(i4.test(1,3));

        // 简化后的写法
        ILambda3 i5= (a,b)->a+b;
        System.out.println(i5.test(100,200));
    }
```
总结:
 - Lambda表达式,必须和接口进行绑定
 - Lambda表达式的参数,可以是0个也可以是n个参数,括号中的参数类型可以不用指定,jvm在运行时，会自动根据绑定的抽象方法中电参数进行推导。
 - Lambda表达式的返回值,如果代码块只有一行,并且没有大括号，不用写return关键字，单行代码的执行结果，会自动返回。
   如果添加了大括号，或者有多行代码，必须通过return关键字返回执行结果。
   
## 变量捕获
- 匿名内部类中的变量捕获


     String s1 = "全局变量";
    // 1. 匿名内部类型中对于变量的访问
    public void testInnerClass() {
        String s2 = "局部变量";

        new Thread(new Runnable() {
            String s3 = "内部变量";
            @Override
            public void run() {
              // s1="hello";  这局部变量可以修改
                // 访问全局变量
                System.out.println(s1);
                // 访问局部变量
              //  s2="hello";
                System.out.println(s2);// 局部变量的访问，~不能对局部变量进行数据的修改[final]
                System.out.println(s3);
                // 访问内部变量
                s3="修改内部变量";
                System.out.println(this.s3);
            }
        }).start();
        


- Lambda表达式中的变量捕获 


        // 2. lambda表达式变量捕获
      public  void testLambda(){
        String s2="局部变量";
        new Thread(()->{
            String s3="内部变量";
            System.out.println();
            System.out.println();
            System.out.println(s1);
            System.out.println(s2);
            System.out.println(this.s1);// this点的是全局变量
            System.out.println(s3);
            s3 = "labmda 内部变量直接修改";
            System.out.println(s3);
        }).start();
        
总结: Lambda中的this关键字,表示的是所属方法所在的类型的对象, 即Lambda表达式所在的地方不在创建对象级的作用域,
Lambda表达式简化了对变量的访问.

## Lambda类型检查
- 表达式类型检查

  
    (x,y)->{..} --> test(param) --> param==MyInterface --> lambda表达式-> MyInterface类型
        这个就是对于lambda表达式的类型检查，MyInterface接口就是lambda表达式的目标类型(target typing)
       --检查出来类型是一个MyInterface接口-->这个接口就是lambda表达式的目标类型

- 参数型检查类

     
    (x,y)->{..} --> MyInterface.strategy(T r, R r)--> MyInterface<String, List> inter
                --> T==String R==List --> lambda--> (x, y) == strategy(T t , R r)--> x==T==String  y==R==List
                lambda表达式参数的类型检查
      -- 针对这个接口,lambda表达式会自动检查参数类型: T==String R==List  对应的   lambda--> (x, y)-->x==T==String  y==R==List
      
## 方法重载的问题
- java 类型中的方法重载

- 方法重载的实现

- 当方法重载遇上Lambda表达式     
  
         
     /* // 使用lambda报错, 原因是lambda表达式存在类型检查->自动会推导lambda表达式的目标类型
     // lambdaMethod() -> 方法 -> 重载方法
              且存在 Param1  Param2  函数式接口
              调用方法->传递Lambda表达式->自动推导识别出2个函数式接口,不能确定该用哪个
              所以,针对方法重载的参数类型都是函数式接口类型, 则需要使用匿名内部类的实现替代lambda表达式.
          app5.lambdaMethod((String info)->{
              System.out.println(info);
          });
     */ 
  
## 深入理解lambda表达式
- 底层解析运行原理

    
    
    public class APPTest {
    
        public static void main(String[] args) {
            IMarkUp mu=(message)-> System.out.println(message);
            mu.markUp("Lambda测试....");
    
        }
    }
    interface IMarkUp{
        void markUp(String msg);
    }
    
    //对上述代码实现实现反编译 cmd javap -p APPTest.class 或者直接用idea打开
     public class com.yss.java8.ʽ2.APPTest {
     public com.yss.java8.ʽ2.APPTest();
     public static void main(java.lang.String[]);
     private static void lambda$main$0(java.lang.String); // Lambda表达式在JVM底层解析成私有静态方法和匿名内部类型。
      通过实现接口的匿名内部类型中的接口方法调用静态实现方法，完成lambda表达式的执行
      }

- JVM底层解析成私有静态方法和匿名内部类型
- 通过实现接口的匿名内部类型中接口方法调用静态实现方法,完成Lambda表达式的执行
总结: Lambda表达式在JVM底层解析成私有静态方法和匿名内部类型。
     通过实现接口的匿名内部类型中的接口方法调用静态实现方法，完成lambda表达式的执行