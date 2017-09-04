package main.java.com.shop.sign;


/**
 * 所有请求对象必须实现该接口
 * 
 * @author sunaolin
 * 
 */
public interface SPayRequest extends SPayObject {

    /**
     * 设置平台商户号
     * 
     * @param merchantNo 平台商户号
     */
    void setMerchantNo(String merchantNo);

    /**
     * 设置签名信息
     * 
     * @param sign 签名信息
     */
    void setSign(String sign);

    /**
     * 获取签名字符串
     * 
     * @return 返回签名字符串
     */
    String getSignStr();
}