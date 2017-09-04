package main.java.com.shop.sign.algorithms;

import main.java.com.shop.sign.snk.SNKReader;

import java.security.PrivateKey;
import java.security.PublicKey;


/**
 * 提供{@code SNK}格式的{@code RSA}方式的签名
 * 
 * @author sunaolin
 * 
 */
public class SignWithSNK extends SignWithRSA {

    @Override
    protected PrivateKey getPrivateKey(String privateKey) throws Exception {
        return SNKReader.getPrivateKey(privateKey);
    }

    @Override
    protected PublicKey getPublicKey(String publicKey) throws Exception {
        return SNKReader.getPublicKey(publicKey);
    }
}
