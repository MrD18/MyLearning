package com.yss.java8.Stream运用;


import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * * <p>Stream常见操作API介绍
 * *  1. 聚合操作
 * *
 * *  2. stream的处理流程
 * *      数据源
 * *      数据转换
 * *      获取结果
 * *  3. 获取Stream对象
 * *      1. 从集合或者数组中获取[**]
 * *          Collection.stream()，如accounts.stream()
 * *          Collection.parallelStream()
 * *          Arrays.stream(T t)
 * *      2. BufferReader
 * *          BufferReader.lines()-> stream()
 * *      3. 静态工厂
 * *          java.util.stream.IntStream.range()..
 * *          java.nio.file.Files.walk()..
 * *      4. 自定构建
 * *          java.util.Spliterator
 * *      5. 更多的方式..
 * *          Random.ints()
 * *          Pattern.splitAsStream()..
 * *   4. 中间操作API{intermediate}
 * *      操作结果是一个Stream，中间操作可以有一个或者多个连续的中间操作，需要注意的是，中间操作
 * *          只记录操作方式，不做具体执行，直到结束操作发生时，才做数据的最终执行。
 * *          中间操作：就是业务逻辑处理。
 * *      中间操作过程：无状态：数据处理时，不受前置中间操作的影响。
 * *                      map/filter/peek/parallel/sequential/unordered
 * *                  有状态：数据处理时，受到前置中间操作的影响。
 * *                      distinct/sorted/limit/skip
 * *   5. 终结操作|结束操作{Terminal}
 * *      需要注意：一个Stream对象，只能有一个Terminal操作，这个操作一旦发生，就会真实处理数据，生成对应的处理结果。
 * *      终结操作：非短路操作：当前的Stream对象必须处理完集合中所有 数据，才能得到处理结果。
 * *                  forEach/forEachOrdered/toArray/reduce/collect/min/max/count/iterator
 * *              短路操作：当前的Stream对象在处理过程中，一旦满足某个条件，就可以得到结果。
 * *                  anyMatch/allMatch/noneMatch/findFirst/findAny等
 * *                  Short-circuiting，无限大的Stream-> 有限大的Stream。
 *
 * @author: duhao
 * @date: 2020/8/24 17:06
 */
public class Test3 {
    public static void main(String[] args) {
        // 1.批量插入数据->Stream对象
        // 多个数据

        Stream<String> stream = Stream.of("admin", "tom", "damu");
        // 数组
        String[] strArrays = {"xueqi", "biyao"};
        Stream<String> stream2 = Arrays.stream(strArrays);
        stream2.forEach(System.out::println);
        // 列表
        List<String> list = new ArrayList<>();
        list.add("少林");
        list.add("武当");
        list.add("青城");
        list.add("崆峒");
        list.add("峨眉");
        Stream<String> stream3 = list.stream();
        // 集合
        Set<String> set = new HashSet<>();
        set.add("少林罗汉拳");
        set.add("武当长拳");
        set.add("青城剑法");
        Stream stream4 = set.stream();
        // Map
        Map<String, Integer> map = new HashMap<>();
        map.put("tom", 1000);
        map.put("jerry", 1200);
        map.put("shuke", 1000);
        Stream stream5 = map.entrySet().stream();
        // 2. Stream对象对于基本数据类型的功能封装
        // int / long / double
        IntStream.of(new int[]{10, 20, 30}).forEach(System.out::println);// 并行执行
        IntStream.of(10, 20, 30).forEachOrdered(System.out::println);// 按照顺序执行
        System.out.println();
        IntStream.range(1, 5).forEach(System.out::print);// [1,5)
        System.out.println();
        IntStream.rangeClosed(1, 5).forEach(System.out::println);//[1,5]

        // 3. Stream对象 --> 转换得到指定的数据类型
        // 数组
        /*String[] objx = stream.toArray(String[]::new);*/
        // 字符串
      /*  String str = stream.collect(Collectors.joining(",","[","]"));// 这个TM太方便了[admin,tom,damu]
        System.out.println(str);*/
       /* String str2 = stream.collect(Collectors.joining("|", "", "")); //admin|tom|damu
        System.out.println(str2);*/
        // 列表 -->数组转list[admin, tom, damu]
      /*  List<String> stringList = stream.collect(Collectors.toList());
        System.out.println(stringList); */
        // 集合-->数组转Set [tom, admin, damu]
      /*  Set<String> stringSet = stream.collect(Collectors.toSet());
        System.out.println(stringSet);*/
        // Map-->数组转Map {tom=valuetom, admin=valueadmin, damu=valuedamu}
        Map<String, String> mapx = (Map<String, String>) stream.collect(Collectors.toMap(x -> x, y -> "value" + y));
        System.out.println(mapx);
    }

}
