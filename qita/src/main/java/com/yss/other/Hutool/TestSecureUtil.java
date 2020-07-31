package com.yss.other.Hutool;

import cn.hutool.crypto.SecureUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**加密解密工具类，可用于MD5加密。
 * @author: duhao
 * @date: 2020/7/13 17:58
 */
public class TestSecureUtil {
    private final static Logger logger = LoggerFactory.getLogger(TestSecureUtil.class);

    public static void main(String[] args) {
        //MD5加密
        String str = "123456";
        String md5Str = SecureUtil.md5(str);
        logger.info("secureUtil md5:{}", md5Str);//secureUtil md5:e10adc3949ba59abbe56e057f20f883e
    }
}
