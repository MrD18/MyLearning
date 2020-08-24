package com.yss.java8.Stream运用;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**方法的引用:
 *
 * 1. 静态方法引用的使用
 *     类型名称.方法名称()--> 类型名称::方法名称
 * 2. 实例方法引用的使用
 *      创建类型对应的一个对象-->对象应用::实例方法名称
 * 3. 构造方法引用
 *      接口中抽象方法需要指定类型的构造方法初始化对象数据-->对象应用::抽象方法名称
 * @author: duhao
 * @date: 2020/8/24 14:58
 */
public class Test {
    public static void main(String[] args) {
        ArrayList<Person> list = new ArrayList<>();
        list.add(new Person("shuke", "男", 29));
        list.add(new Person("tom", "男", 16));
        list.add(new Person("jerry", "男", 20));
        list.add(new Person("beita", "女", 1));

        // 1. 匿名内部类实现排序:
        Collections.sort(list, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.getAge() - o2.getAge();
            }
        });
        System.out.println(list);

        Collections.sort(list, Comparator.comparingInt(Person::getAge));

        // 2. Lambda 表达式实现
        Collections.sort(list, (p1, p2) -> p1.getAge() - p2.getAge());
        System.out.println();
        System.out.println(list);
        // 3. 静态方法的引用
        Collections.sort(list, Person::compareByAge);// 这个方法是在Person中定义的方法, 但是Comparator 中本来就就有静态方法
        System.out.println(list);

        System.out.println();
        System.out.println();
        // 4. 实例方法引用
     PersonUtil pu = new PersonUtil();
     Collections.sort(list,pu::comprareByName);
        list.forEach(System.out::println);
        // 5. 构造方法引用: 绑定函数式接口
        IPerson p1=Person::new;
        Person person = p1.getPerson("tom", "男", 18);
        System.out.println(person);


    }
}

@Data
@AllArgsConstructor
@NoArgsConstructor
class Person {
    private String name;
    private String gender;
    private int age;

    // 内部静态方法引用
    public static int compareByAge(Person p1, Person p2) {
        return p1.age - p2.age;
    }
}

class PersonUtil {
    // 实例方法引用
    public int comprareByName(Person p1, Person p2) {
        return p1.getName().hashCode() - p2.getName().hashCode();
    }
}

// 构造方法  必须绑定函数式接口
@FunctionalInterface
interface IPerson {
    // 抽象方法: 通过指定类型的构造方法初始化对象数据
    Person getPerson(String name, String gender, int age);
}