package com.yss.other.鉴权URL加密;

import cn.hutool.core.codec.Base64;
import jodd.util.StringUtil;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: duhao
 * @date: 2021/3/17 15:38
 */
public class SignDemo {
    public static void main(String[] args) {
       String signurl="/aim/aimJudgment/aimDecisionsPassDatail";
        System.out.println("需要创建签名的URL:"+signurl);
        Map<String, String> resultMap = new HashMap<>(2);
        String signResult = null;
        //加密
        if (StringUtil.isNotBlank(signurl)){
                    signResult = aesEncryptParam(signurl);
               }
        System.out.println("创建的签名为:"+signResult);
        resultMap.put("signResult",signResult);
        System.out.println(resultMap);
        // 解密
        String decodeStr = null;
        if (StringUtil.isNotBlank(signResult)){
           decodeStr = decodeStr(signResult);
        }
        System.out.println("解密后的URL:"+decodeStr);

        System.out.println("------------------------");
        //校验,加密后的返回给前端, 前端传过来在对比

        Map  resultMap2=new HashMap<>(2);
        Boolean signResult2=false;
        if (StringUtil.isNotBlank(signurl)&&StringUtil.isNotBlank(signResult)){
            String encryptStr = aesEncryptParam(signurl);
            System.out.println("需要校验的URL加密字符串:"+encryptStr);
            if (encryptStr.equals(signResult)){
                signResult2=true;
            }
        }
        resultMap2.put("signResult2",signResult2);
        System.out.println(resultMap2);
    }


 public static String aesEncryptParam(String str){
     String encode = Base64.encode(str);
     return encode;
 }

 public static String decodeStr (String str){
        String decodeStr  = Base64.decodeStr(str);
        return decodeStr;
    }


}
