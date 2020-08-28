package com.yss.java8.基础知识1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * @author: duhao
 * @date: 2020/7/31 10:27
 */
public class FilteringApples {
    public static void main(String[] args) {

//        Comparator<Apple> byWeight =
//                (Apple a1, Apple a2) -> a1.getWeight().compareTo(a2.getWeight());




        // 现在 在inventory 这个列表中保存了 苹果的一些信息
        List<Apple> inventory = Arrays.asList(new Apple(80, "green"), new Apple(155, "green"), new Apple(120, "red"));

        // [Apple{color='green', weight=80}, Apple{color='green', weight=155}]
        List<Apple> greenApples = filterApples(inventory, FilteringApples::isGreenApple);
        System.out.println(greenApples);
        //[Apple{weight=155, color='green'}]
        List<Apple> heavyApples = filterApples(inventory, FilteringApples::isHeavyApple);
        System.out.println(heavyApples);
      //  [Apple{weight=80, color='green'}, Apple{weight=155, color='green'}]

        // 将方法作为值传递   java8 引入新的方法(匿名函数或者Lamda)
        List<Apple> greenApples2 = filterApples(inventory, (Apple a) -> "green".equals(a.getColor()));
        System.out.println(greenApples2);
     //  [Apple{weight=155, color='green'}]
        List<Apple> heavyApples2 = filterApples(inventory, (Apple a) -> a.getWeight() > 150);
        System.out.println(heavyApples2);
   // 还可以这样
        List<Apple> apples = filterApples(inventory, (Apple a) -> a.getWeight() < 80||"brown".equals(a.getColor()));
        System.out.println(apples);


        // 如果我要查绿色苹果-- 老方法
    //    filterGreenApples(inventory).forEach(System.out::println);
        // 查重量>150的苹果
    //    filterHeavyApples(inventory).forEach(System.out::println);

    }

    // 选择重量>150的苹果
    private static List<Apple> filterHeavyApples(List<Apple> inventory){

        List<Apple> result = new ArrayList<>(); // 用来存查出来的信息
        for (Apple apple : inventory) {
            if (apple.getWeight()>150){
                result.add(apple);
            }
        }
       return  result;
    }

    // 选择绿色苹果的老方法
    private static List<Apple> filterGreenApples(List<Apple> inventory) {
        List<Apple> result = new ArrayList<>(); // 用来存查出来的信息

        for (Apple apple : inventory) {
            if ("green".equals(apple.getColor())){
                result.add(apple);
            }
        }
        return result;
    }

    public  static  boolean isGreenApple(Apple apple){
        return  "green".equals(apple.getColor());
    }

    public  static  boolean isHeavyApple(Apple apple){
        return  apple.getWeight()>150;
    }
     // Predicate  常用方法test
   // 接受一个输入参数，返回一个布尔值结果。该接口包含多种默认方法来将Predicate组合成其他复杂的逻辑（比如：与，或，非）。
     // 可以用于接口请求参数校验、判断新老数据是否有变化需要进行更新操作。add--与、or--或、negate--非
    public  static  List<Apple> filterApples(List<Apple> inventory, Predicate<Apple> p){
         List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if (p.test(apple)){
                 result.add(apple);
            }
        }
           return  result;
    }



}






class Apple{
    private int weight = 0;
    private String color = "";

    @Override
    public String toString() {
        return "Apple{" + "weight=" + weight + ", color='" + color + '\'' + '}';
    }

    public Apple(int weight, String color) {
        this.weight = weight;
        this.color = color;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}