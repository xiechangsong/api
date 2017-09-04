package main.java.com.shop.sign;


import main.java.com.shop.sign.algorithms.SignWithMD5;
import main.java.com.shop.sign.algorithms.SignWithSNK;

/**
 * 签名算法接口
 * 
 * @author sunaolin
 * 
 */
public interface SignAlgorithm {

    /**
     * 提供默认{@code MD5}方式的签名
     */
    SignAlgorithm MD5 =  new SignWithMD5();

    /**
     * 提供默认{@code SNK}格式的{@code RSA}方式的签名
     */
    SignAlgorithm RSA_SNK = new SignWithSNK();

    /**
     * 对指定内容进行签名并返回签名后的字符串
     * 
     * @param content   需要签名的内容
     * @param key       签名的密钥
     * @param charset   编码方式
     * 
     * @return 返回签名后的字符串
     */
    String sign(String content, String key, String charset);

    /**
     * 验证指定内容的签名是否合法
     * 
     * @param sign      签名后的字符串
     * @param content   原始签名内容
     * @param key       签名的密钥
     * @param charset   编码方式
     * 
     * @return  {@code true}：表示签名合法
     */
    boolean verify(String sign, String content, String key, String charset);
}
