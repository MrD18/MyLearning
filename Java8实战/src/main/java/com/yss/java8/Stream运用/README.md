## 方法引用
- 方法引用时结合Lambda表达式的一种语法特性
- 静态方法引用


        类型名称.方法名称()--> 类型名称::方法名称
                  Collections.sort(list, Person::compareByAge);// 这个方法是在Person中定义的方法, 但是Comparator 中本来就就有静态方法
                    System.out.println(list);
 
- 实例方法引用
         
         
        创建类型对应的一个对象-->对象应用::实例方法名称 
         PersonUtil pu = new PersonUtil();
             Collections.sort(list,pu::comprareByName);
                list.forEach(System.out::println);
- 构造方法引用
          
          
          
          接口中抽象方法需要指定类型的构造方法初始化对象数据-->对象应用::抽象方法名称
            IPerson p1=Person::new;
                  Person person = p1.getPerson("tom", "男", 18);
                  System.out.println(person);


## Stream API
- 聚合操作
- 处理流程
  - 数据源
  - 数据转换
  - 获取结果
- 获取Stream对象
  - 从集合或者数组中获取
     - Collection.stream()
     - Collection.parallelStream()  并发的获取
     - Arrays.Stream(T t) 
   - BufferReader
     - BufferReader.lines()->stream()
   - 静态工厂
     - java.util.stream.IntStream.range()
     - java.nio.file.Files.walk()...
   - 自定义构建
     - java.util.Spliterator
   - 更多方式
- 中间操作API
   - 操作结果是一个Stream,中间操作可以有一个或者多个连续的中间操作,中间操作知识记录操作方式,不具体执行,直到结束时才发生才会做数据的最终处理
     中间操作:就是业务逻辑处理.
   - 中间操作过程: 
      - 无状态:数据处理时,不受前置中间操作的影响: map(遍历)/filter(过滤)/peek/parallel/sequential/unordered
      - 有状态: 数据处理时,受前置中间操作的影响: distinct(找不重复元素)/sort(排序)/limit(返回流前n个元素)/skip(跳过流前n个元素)
- 结束操作
需要注意:一个Stream对象,只能有一个Terminal操作,这个操作一旦发生,就会真实的处理数据
   - 非短路操作: 当前的Stream对象必须处理完集合中所有数据,才会得到处理结果: forEach(循环操作)/forEachOrder/toArray/reduce/collect/min,max(找流中最大,最小)/count(返回流元素总数)/iterator
   - 短路操作: 当前的Stream对象在处理过程中,一旦满足某个条件,就可以得到结果: anyMatch(流中只要一个元素符合传入predicate,返回true)/allMatch(流中全部元素传入predicate,返回true)/noneMatch(流没有一个元素符合传入的 predicate，返回 true)
              /findFirst/findAny/
           
## Stream 操作原理
- 
## 操作集合元素