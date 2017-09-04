package test.java.com.api;

import main.java.com.shop.Application;
import main.java.com.shop.service.UserService;
import main.java.com.shop.sign.util.SPaySignUtils;
import main.java.com.shop.utils.RSACoder;
import org.apache.tomcat.util.codec.binary.Base64;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.crypto.Cipher;
import java.security.*;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class RSATest {
	public static final String src = "我你大爷第三个时代大厦所的";

	@Autowired
	private UserService userService;
	
	@Test
	public void jdkRSA()
	{		
		try 
		{
			// 1.初始化发送方密钥
			KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
			keyPairGenerator.initialize(1024);
			KeyPair keyPair = keyPairGenerator.generateKeyPair();
			RSAPublicKey rsaPublicKey = (RSAPublicKey) RSACoder.getPublicKey(RSACoder.PUBLIC_KEY);
			RSAPrivateKey rsaPrivateKey = (RSAPrivateKey) RSACoder.getPrivateKey(RSACoder.PRIVATE_KEY);
			/*RSAPublicKey rsaPublicKey = (RSAPublicKey) keyPair.getPublic();
			RSAPrivateKey rsaPrivateKey = (RSAPrivateKey) keyPair.getPrivate();*/
			System.out.println("Public Key:" + Base64.encodeBase64String(rsaPublicKey.getEncoded()));
			System.out.println("Private Key:" + Base64.encodeBase64String(rsaPrivateKey.getEncoded()));
			
			// 2.私钥加密、公钥解密 ---- 加密
			PKCS8EncodedKeySpec pkcs8EncodedKeySpec = new PKCS8EncodedKeySpec(rsaPrivateKey.getEncoded());
			KeyFactory keyFactory = KeyFactory.getInstance("RSA");
			PrivateKey privateKey = keyFactory.generatePrivate(pkcs8EncodedKeySpec);
			Cipher cipher = Cipher.getInstance("RSA");
			cipher.init(Cipher.ENCRYPT_MODE, privateKey);
			byte[] result = cipher.doFinal(src.getBytes());
			System.out.println("私钥加密、公钥解密 ---- 加密:" + Base64.encodeBase64String(result));
			
			// 3.私钥加密、公钥解密 ---- 解密
			X509EncodedKeySpec x509EncodedKeySpec = new X509EncodedKeySpec(rsaPublicKey.getEncoded());
			keyFactory = KeyFactory.getInstance("RSA");
			PublicKey publicKey = keyFactory.generatePublic(x509EncodedKeySpec);
			cipher = Cipher.getInstance("RSA");
			cipher.init(Cipher.DECRYPT_MODE, publicKey);
			result = cipher.doFinal(result);
			System.out.println("私钥加密、公钥解密 ---- 解密:" + new String(result));
			
			
			
			// 4.公钥加密、私钥解密 ---- 加密
			X509EncodedKeySpec x509EncodedKeySpec2 = new X509EncodedKeySpec(rsaPublicKey.getEncoded());
			KeyFactory keyFactory2 = KeyFactory.getInstance("RSA");
			PublicKey publicKey2 = keyFactory2.generatePublic(x509EncodedKeySpec2);
			Cipher cipher2 = Cipher.getInstance("RSA");
			cipher2.init(Cipher.ENCRYPT_MODE, publicKey2);
			byte[] result2 = cipher2.doFinal(src.getBytes());
			System.out.println("公钥加密、私钥解密 ---- 加密:" + Base64.encodeBase64String(result2));
			
			// 5.私钥解密、公钥加密 ---- 解密
			PKCS8EncodedKeySpec pkcs8EncodedKeySpec5 = new PKCS8EncodedKeySpec(rsaPrivateKey.getEncoded());
			KeyFactory keyFactory5 = KeyFactory.getInstance("RSA");
			PrivateKey privateKey5 = keyFactory5.generatePrivate(pkcs8EncodedKeySpec5);
			Cipher cipher5 = Cipher.getInstance("RSA");
			cipher5.init(Cipher.DECRYPT_MODE, privateKey5);
			byte[] result5 = cipher5.doFinal(result2);
			System.out.println("公钥加密、私钥解密 ---- 解密:" + new String(result5));
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
	}
	@Test
	public void sign() {
		//对数据签名并进行验证
		try {
			Map<String,String> map =new HashMap<String, String>();
			map.put("userName","老谢");
			map.put("id","1");
			String param = SPaySignUtils.createLinkString(map);//将参数安装ASCILL码进行排序
			System.out.println("param1:"+param);
			String sign = RSACoder.sign(param.getBytes(),RSACoder.PRIVATE_KEY);//签名
			map.put("sign",sign);
			boolean bool = userService.validate(map);
			System.out.println("sign:" + sign);
			/*boolean bool = RSACoder.verify(src.getBytes(),RSACoder.PUBLIC_KEY,sign);*/
			if( bool ) {
				System.out.println("true");
			}else {
				System.out.println("false");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
