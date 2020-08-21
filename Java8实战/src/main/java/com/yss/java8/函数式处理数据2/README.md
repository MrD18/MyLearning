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