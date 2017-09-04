package main.java.com.shop.sign.algorithms;

import main.java.com.shop.sign.SignAlgorithm;
import main.java.com.shop.sign.util.Base64;
import main.java.com.shop.sign.util.StringUtils;

import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;



/**
 * 提供{@code RSA}方式的签名的基类
 * 
 * @author sunaolin
 * 
 */
public abstract class SignWithRSA implements SignAlgorithm {

    private static final String SIGN_ALGORITHM = "MD5withRSA";

    @Override
    public final String sign(String content, String key, String charset) {
        try {
            Signature signature = Signature.getInstance(SIGN_ALGORITHM);

            signature.initSign(getPrivateKey(key));
            signature.update(StringUtils.getBytes(content, charset));

            return Base64.encode(signature.sign());
        }
        catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public final boolean verify(String sign, String content, String key, String charset) {
        try {
            Signature signature = Signature.getInstance(SIGN_ALGORITHM);

            signature.initVerify(getPublicKey(key));
            signature.update(StringUtils.getBytes(content, charset));

            return signature.verify(Base64.decode(sign));
        }
        catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    /**
     * 把指定的字符串转换成私钥信息
     * 
     * @param privateKey 需要转码的字符串
     * 
     * @return 返回私钥信息
     */
    protected abstract PrivateKey getPrivateKey(String privateKey) throws Exception;

    /**
     * 把指定的字符串转换成公钥信息
     * 
     * @param privateKey 需要转码的字符串
     * 
     * @return 返回公钥信息
     */
    protected abstract PublicKey getPublicKey(String publicKey) throws Exception;
}
