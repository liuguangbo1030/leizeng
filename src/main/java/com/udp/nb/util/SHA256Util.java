package com.udp.nb.util;

import java.security.NoSuchAlgorithmException;

import javax.crypto.KeyGenerator;
import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.annotation.adapters.HexBinaryAdapter;

/**
 * @author cloudy
 * @version 1.0
 * @date 2016/9/1
 */
public class SHA256Util {

    /**
     * 判断字符串是否为空
     *
     * @param str
     * @return
     */
    public static boolean isStrEmpty(String str) {
        if (str != null && !str.isEmpty()) {
            return false;
        }
        return true;
    }

    /**
     *
     */
    public static byte[] initHmacSHA256Key() throws NoSuchAlgorithmException {
        KeyGenerator generator = KeyGenerator.getInstance("HmacSHA256");
        SecretKey secretKey = generator.generateKey();
        byte[] key = secretKey.getEncoded();
        return key;
    }


    public static String encodeHmacSHA256(byte[] data, byte[] key) throws Exception {
        SecretKey secretKey = new SecretKeySpec(key, "HmacSHA256");
        Mac mac = Mac.getInstance(secretKey.getAlgorithm());
        mac.init(secretKey);
        byte[] digest = mac.doFinal(data);
        return new HexBinaryAdapter().marshal(digest);//转为十六进制的字符串
    }

}
