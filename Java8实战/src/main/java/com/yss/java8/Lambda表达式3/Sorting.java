package com.yss.java8.Lambda表达式3;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author: duhao
 * @date: 2020/8/12 17:32
 */
public class Sorting {

    public static void main(String[] args) {
        // 1
        List<Apple> inventory = new ArrayList<>(Arrays.asList(new Apple(80, "green"), new Apple(155, "green"), new Apple(30, "red")));
     // inventory.sort(new Apple.AppleComparator());
        System.out.println(inventory);
     // 2
        inventory.set(1,new Apple(30,"green"));
        System.out.println(inventory);
       //3  进行排序
        inventory.sort(Comparator.comparing(Apple::getWeight));
        System.out.println(inventory);
        //4. 逆着排序
        inventory.sort(Comparator.comparing(Apple::getWeight).reversed());
        System.out.println(inventory);
        //5. 比较器链  先按照重量排, 相同的按照颜色排
        inventory.sort(Comparator.comparing(Apple::getWeight).reversed().thenComparing((Apple::getColor)));
        System.out.println(inventory);
    }


}

@Data
@AllArgsConstructor
  class Apple {
    private Integer weight = 0;
    private String color = "";

//
//    static class AppleComparator implements Comparator<Apple> {
//        @Override
//        public int compare(Apple a1, Apple a2){
//            return a1.getWeight().compareTo(a2.getWeight());
//        }
//    }

}