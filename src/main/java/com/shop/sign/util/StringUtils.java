package main.java.com.shop.sign.util;

import java.io.UnsupportedEncodingException;

/**
 * 字符编码工具类
 * 
 * @author sunaolin
 * 
 */
public final class StringUtils {

    /**
     * 禁止实例化
     */
    private StringUtils() {};

    /**
     * 把给定的字符串按照指定编码方式生成字节数组
     * 
     * @param str 要编码的字符串
     * @param charset 编码方式
     * 
     * @return 返回编码后的字节数组
     */
    public static byte[] getBytes(String str, String charset) {
        if (str == null || str.length() == 0) {
            return str.getBytes();
        }

        try {
            return str.getBytes(charset);
        }
        catch (UnsupportedEncodingException ex) {
            throw new IllegalArgumentException("Not support:" + charset, ex);
        }
    }
}
