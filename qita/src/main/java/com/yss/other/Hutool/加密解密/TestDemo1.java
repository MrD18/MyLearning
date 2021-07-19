package com.yss.other.Hutool.加密解密;

import cn.hutool.core.util.RandomUtil;
import cn.hutool.crypto.SecureUtil;
import cn.hutool.crypto.symmetric.AES;
import cn.hutool.crypto.symmetric.DES;
import cn.hutool.crypto.symmetric.SymmetricAlgorithm;
import lombok.Data;

import java.util.Random;
import java.util.UUID;

/**
 * @Author: dhao
 * @Date: 2021/6/7 10:49 上午
 */
public class TestDemo1 {


    static AES aes = SecureUtil.aes();
    public static void main(String[] args) {
/*
        String content = "test中文";

//随机生成密钥
        byte[] key = SecureUtil.generateKey(SymmetricAlgorithm.AES.getValue()).getEncoded();

//构建
        AES aes = SecureUtil.aes(key);

//加密
        byte[] encrypt = aes.encrypt(content);
//解密
        byte[] decrypt = aes.decrypt(encrypt);
//        //构建
//        DES des = SecureUtil.des(key);
////加密为16进制表示
//        String encryptHex = des.encryptHex(content);
////解密为原字符串
//        String decryptStr = des.decryptStr(encryptHex);
        System.out.println(new String(encrypt));
        System.out.println(new String(decrypt));*/


            String encry = aes.encryptHex("沉默王二");
            System.out.println(encry);
            String oo = aes.decryptStr(encry);
            System.out.println(oo);

        TestUser testUser = new TestUser();
        testUser.setAge(1);
        testUser.setUserId(11);
        String s = aes.encryptHex(testUser.getAge().toString());
        System.out.println(s);
        String s1 = aes.decryptStr(s);
        System.out.println(s1);

      Random r = new Random();
        System.out.println("--->"+r.nextInt());

        System.out.println("uuid-->"+ UUID.randomUUID().toString());
        System.out.println("RandomUtil--》"+ RandomUtil.randomString(16));

    }
}
@Data
class TestUser{

    Integer age ;
    Integer userId;
}