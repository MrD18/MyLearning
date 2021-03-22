package com.yss.other.万能token;

import org.apache.commons.codec.binary.Hex;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author: duhao
 * @date: 2021/1/6 18:22
 */

public class Generator16ID {
    //    public static String getIdByUUId() {
//
//        int machineId = 1;
//        int hashCodeV = UUID.randomUUID().toString().hashCode();
//
//        if(hashCodeV < 0) {
//            //有可能是负数
//            hashCodeV = - hashCodeV;
//        }
//        System.out.println(hashCodeV);
//        return machineId + String.format("%015d", hashCodeV);
//    }

    public static String getIdByUUId() {
        long time= System.currentTimeMillis();
        int random = (int)(Math.random()*(9999-1000+1))+1000;
        String uuid=String.valueOf(time)+String.valueOf(random);
        return uuid;
    }

    public static String string2SHA256(String str) {
        MessageDigest messageDigest;
        String encodeStr = "";
        try {
            messageDigest = MessageDigest.getInstance("SHA-256");
            byte[] hash = messageDigest.digest(str.getBytes("UTF-8"));
            encodeStr = Hex.encodeHexString(hash);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return encodeStr;
    }

    public static void main(String[] args) {
        System.out.println(getIdByUUId());
        // System.out.println(getIdByUUIdn());
        System.out.println(System.currentTimeMillis());

        long time=System.currentTimeMillis();
        String token = string2SHA256("alternative-gsgf-jkb"+"11000116"+"8\"$J}i2O"+time);
       // String token = string2SHA256("alternative-gsgf-oa"+"11000014"+"240~G6t2"+time);
        System.out.println(time);
        System.out.println(token);

    }
}
