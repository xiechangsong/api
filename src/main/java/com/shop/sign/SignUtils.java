package main.java.com.shop.sign;

import main.java.com.shop.sign.algorithms.SignWithRSA;
import org.apache.commons.lang3.Validate;

import java.security.PrivateKey;
import java.security.PublicKey;

/**
 * 签名工具类
 * 
 * @author sunaolin
 * 
 */
public class SignUtils extends SignWithRSA {

    /**
     * 禁止实例化
     */
    private SignUtils() {}

    /**
     * 使用默认提供的{@code MD5}方式和平台默认编码进行签名
     * 
     * @param content   需要签名的内容
     * @param key       签名的密钥
     * 
     * @return 返回签名后的字符串
     */
    public static String signWithMd5(String content, String key) {
        return signWithMd5(content, key, null);
    }

    /**
     * 使用默认提供的{@code MD5}方式进行签名
     * 
     * @param content   需要签名的内容
     * @param key       签名的密钥
     * @param charset   编码方式
     * 
     * @return 返回签名后的字符串
     */
    public static String signWithMd5(String content, String key, String charset) {
        return sign(SignAlgorithm.MD5, content, key, charset);
    }

    /**
     * 使用默认提供的{@code SNK}方式和平台默认编码进行签名
     * 
     * @param content   需要签名的内容
     * @param key       签名的密钥
     * 
     * @return 返回签名后的字符串
     */
    public static String signWithSNK(String content, String key) {
        return signWithSNK(content, key, null);
    }

    /**
     * 使用默认提供的{@code SNK}方式进行签名
     * 
     * @param content   需要签名的内容
     * @param key       签名的密钥
     * @param charset   编码方式
     * 
     * @return 返回签名后的字符串
     */
    public static String signWithSNK(String content, String key, String charset) {
        return sign(SignAlgorithm.RSA_SNK, content, key, charset);
    }

    /**
     * 使用指定的签名算法和平台默认编码进行签名
     * 
     * @param algorithm 签名算法
     * @param content   需要签名的内容
     * @param key       签名的密钥
     * 
     * @return 返回签名后的字符串
     */
    public static String sign(SignAlgorithm algorithm, String content, String key) {
        return sign(algorithm, content, key, null);
    }

    /**
     * 使用指定的签名算法进行签名
     * 
     * @param algorithm 签名算法
     * @param content   需要签名的内容
     * @param key       签名的密钥
     * @param charset   编码方式
     * 
     * @return 返回签名后的字符串
     */
    public static String sign(SignAlgorithm algorithm, String content, String key, String charset) {
        Validate.notEmpty(key);
        Validate.notEmpty(content);
        Validate.notNull(algorithm);

        return algorithm.sign(content, key, charset);
    }

    /**
     * 使用默认提供的{@code MD5}方式和平台默认编码进行验证签名
     * 
     * @param sign      签名后的字符串
     * @param content   需要签名的内容
     * @param key       签名的密钥
     * 
     * @return 返回签名后的字符串
     */
    public static boolean verifyWithMd5(String sign, String content, String key) {
        return verifyWithMd5(sign, content, key, null);
    }

    /**
     * 使用默认提供的{@code MD5}方式进行验证签名
     * 
     * @param sign      签名后的字符串
     * @param content   需要签名的内容
     * @param key       签名的密钥
     * @param charset   编码方式
     * 
     * @return 返回签名后的字符串
     */
    public static boolean verifyWithMd5(String sign, String content, String key, String charset) {
        return verify(SignAlgorithm.MD5, sign, content, key, charset);
    }

    /**
     * 使用默认提供的{@code SNK}方式和平台默认编码进行验证签名
     * 
     * @param sign      签名后的字符串
     * @param content   需要签名的内容
     * @param key       签名的密钥
     * 
     * @return 返回签名后的字符串
     */
    public static boolean verifyWithSNK(String sign, String content, String key) {
        return verifyWithSNK(sign, content, key, null);
    }

    /**
     * 使用默认提供的{@code SNK}方式进行验证签名
     * 
     * @param sign      签名后的字符串
     * @param content   需要签名的内容
     * @param key       签名的密钥
     * @param charset   编码方式
     * 
     * @return 返回签名后的字符串
     */
    public static boolean verifyWithSNK(String sign, String content, String key, String charset) {
        return verify(SignAlgorithm.RSA_SNK, sign, content, key, charset);
    }

    /**
     * 使用指定的签名算法和平台默认编码进行验证签名
     * 
     * @param algorithm 签名算法
     * @param sign      签名后的字符串
     * @param content   需要签名的内容
     * @param key       签名的密钥
     * 
     * @return 返回签名后的字符串
     */
    public static boolean verify(SignAlgorithm algorithm, String sign, String content, String key) {
        return verify(algorithm, sign, content, key, null);
    }

    /**
     * 使用指定的签名算法进行验证签名
     * 
     * @param algorithm 签名算法
     * @param sign      签名后的字符串
     * @param content   需要签名的内容
     * @param key       签名的密钥
     * @param charset   编码方式
     * 
     * @return 返回签名后的字符串
     */
    public static boolean verify(SignAlgorithm algorithm, String sign, String content, String key, String charset) {
        Validate.notNull(key);
        Validate.notNull(sign);
        Validate.notNull(content);
        Validate.notNull(algorithm);

        return algorithm.verify(sign, content, key, charset);
    }

	@Override
	protected PrivateKey getPrivateKey(String privateKey) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected PublicKey getPublicKey(String publicKey) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
}
