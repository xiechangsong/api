package main.java.com.shop.sign;


/**
 * 所有异步通知都必须实现该接口
 * 
 * @author sunaolin
 * 
 */
public interface SPayNotify extends SPayObject {

    /**
     * 获取签名字符串
     * 
     * @return 返回签名字符串
     */
    String getSignStr();

    /**
     * 获取签名信息
     * 
     * @return 返回签名信息
     */
    String getSign();
}