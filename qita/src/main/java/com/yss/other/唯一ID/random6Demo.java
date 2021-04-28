package com.yss.other.唯一ID;

import java.util.Random;

/**
 * @author: duhao
 * @date: 2021/4/22 10:22
 */
public class random6Demo {
    public static void main(String[] args) {

        for (int i = 0; i <= 100; i++) {
            int flag = new Random().nextInt(999999);
            if (flag < 100000) {
                flag += 100000;
            }
            System.out.println(flag);
        }
    }
}