package com.yss.other.加密解密;

import com.rh.cipher.sm4.SM4Util;
import org.bouncycastle.pqc.math.linearalgebra.ByteUtils;


/**
 * @author: duhao
 * @date: 2021/1/26 9:59
 */
public class SMConstant {
    private SMConstant() {
        //此为无参构造器
    }


    private static SMConstant OBJ= new SMConstant();

    /**
     * SM4CBC 加密
     * @param key
     * @param iv
     * @param data
     * @return
     */
    public static String SM4EncryptCbc(String key, String iv, String data) {
        String encryptCbcStr = "";
        try {
            byte[] keyBytes = key.getBytes();
            byte[] ivBytes = iv.getBytes();
            byte[] dataBytes = data.getBytes();
            byte[] cipherEncryptCbc = SM4Util.encryptCbc(keyBytes, ivBytes,dataBytes);
            encryptCbcStr = ByteUtils.toHexString(cipherEncryptCbc);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return encryptCbcStr;
    }

    /**
     * SM4CBC 解密
     * @param key
     * @param iv
     * @param data
     * @return
     */
    public static String SM4DecryptCbc(String key, String iv, String data) {
        String dataStr = "";
        try {
            byte[] keyBytes = key.getBytes();
            byte[] ivBytes = iv.getBytes();
            byte[] ciphe = ByteUtils.fromHexString(data);
            byte[] decryptedByteCbc = SM4Util.decryptCbc(keyBytes, ivBytes,ciphe);
            dataStr = new String(decryptedByteCbc, "GBK");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dataStr;
    }

    public static String SM4DecryptCbcUtf8(String key, String iv, String data) {
        String dataStr = "";
        try {
            byte[] keyBytes = key.getBytes();
            byte[] ivBytes = iv.getBytes();
            byte[] ciphe = ByteUtils.fromHexString(data);
            byte[] decryptedByteCbc = SM4Util.decryptCbc(keyBytes, ivBytes,ciphe);
            dataStr = new String(decryptedByteCbc, "UTF-8");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dataStr;
    }

    public static void main(String[] args) {
        //另类投资加密Key值
        String LLTZKeyStr = "LLt!KEY#e$r1#2@3";
        //另类投资加密IV值
        String LLTZIvStr = "LLt!n@IVS$r1#2@3";
        //加密
   /*     String dataStrEnc = SM4EncryptCbc(LLTZKeyStr,LLTZIvStr,"11000014");
        System.out.println(dataStrEnc);*/
//    解密
        String dataStrDec = SM4DecryptCbc(LLTZKeyStr,LLTZIvStr,"cd9746ee3ccd8acb557bee52e61d6d55");
        System.out.println(dataStrDec);
    }





}

