package test.java.com.api;

import main.java.com.shop.utils.Keys;
import main.java.com.shop.utils.RSACoder;
import org.junit.Test;

import java.util.*;

/**
 * Created by 牛逼的小菜鸟 on 2017/8/28.
 */
public class Tests {
    private String publicKey;
    private String privateKey;
    @Test
    public void T_RSA() {
        Map<String, Object> keyMap;
        try {
            keyMap = Keys.initKey();
            String publicKey =  Keys.getPublicKey(keyMap);
            System.out.println(publicKey);
            String privateKey =  Keys.getPrivateKey(keyMap);
            System.out.println(privateKey);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Test
    public void test() throws Exception {
        System.err.println("公钥加密——私钥解密");
        String inputStr = "abc";
        byte[] data = inputStr.getBytes();

        byte[] encodedData = RSACoder.encryptByPublicKey(data, publicKey);

        byte[] decodedData = RSACoder.decryptByPrivateKey(encodedData,
                privateKey);

        String outputStr = new String(decodedData);
        System.err.println("加密前: " + inputStr + "\n\r" + "解密后: " + outputStr);
        //assertEquals(inputStr, outputStr);

    }

    @Test
    public void testSign() throws Exception {
        System.err.println("私钥加密——公钥解密");
        String inputStr = "sign";
        byte[] data = inputStr.getBytes();

        byte[] encodedData = RSACoder.encryptByPrivateKey(data, privateKey);

        byte[] decodedData = RSACoder
                .decryptByPublicKey(encodedData, publicKey);

        String outputStr = new String(decodedData);
        System.err.println("加密前: " + inputStr + "\n\r" + "解密后: " + outputStr);
        //assertEquals(inputStr, outputStr);

        System.err.println("私钥签名——公钥验证签名");
        // 产生签名
        String sign = RSACoder.sign(encodedData, privateKey);
        System.err.println("签名:\r" + sign);

        // 验证签名
        boolean status = RSACoder.verify(encodedData, publicKey, sign);
        System.err.println("状态:\r" + status);
        //assertTrue(status);

    }

    @Test
    public void array() {
        String []a={"0","1","2","3","4","5","6"};
        String []b={"1","3","5"};
//Set是不允许重复的，所以将数组的值全部放在Set对象中
        Set set = new HashSet<Integer>();
        for(int i = 0; i < a.length ; i++){
            set.add(a[i]);
        }
        for(int i = 0; i < b.length ; i++){
            set.add(b[i]);
        }
//得到的是不重复的值，Set的长度
        System.out.println(set.size());
        Iterator i = set.iterator();
        int[] arrays = new int[set.size()];
        int num=0;
        while(i.hasNext()){
            int value = (Integer)i.next();
            arrays[num] = value;
            num = num + 1;
            System.out.println(num);
        }
        for(int s = 0; s < arrays.length ; s++){
            System.out.println(arrays[s]);
        }
//对结果进行排序
        Arrays.sort(arrays);
        for(int s = 0; s < arrays.length ; s++){
            System.out.println(arrays[s]);
        }
    }
}
