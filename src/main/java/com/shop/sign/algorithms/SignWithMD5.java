package main.java.com.shop.sign.algorithms;

import main.java.com.shop.sign.SignAlgorithm;
import main.java.com.shop.sign.util.HexUtils;
import main.java.com.shop.sign.util.StringUtils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;




/**
 * 提供{@code MD5}方式的签名
 * 
 * @author sunaolin
 * 
 */
public class SignWithMD5 implements SignAlgorithm {

    private static final String SIGN_ALGORITHM = "MD5";

    @Override
    public String sign(String content, String key, String charset) {
        String message = content + key;

        MessageDigest digest = getDigest(SIGN_ALGORITHM);
        digest.update(StringUtils.getBytes(message, charset));

        byte[] signed = digest.digest();

        return HexUtils.toHexString(signed);
    }

    @Override
    public boolean verify(String sign, String content, String key, String charset) {
        String mysign = sign(content, key, charset);

        if (mysign.equals(sign)) {
            return true;
        }
        else {
            return false;
        }
    }

    /**
     * 返回实现指定摘要算法的 {@code MessageDigest} 对象。
     * 
     * @param algorithm 信息摘要算法名称
     * 
     * @return 返回摘要算法对象
     */
    private static MessageDigest getDigest(String algorithm) {
        try {
            return MessageDigest.getInstance(algorithm);
        }
        catch (final NoSuchAlgorithmException ex) {
            throw new IllegalArgumentException("Not support:" + algorithm, ex);
        }
    }
}
