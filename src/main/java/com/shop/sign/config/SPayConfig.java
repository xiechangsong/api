package main.java.com.shop.sign.config;

/**
 * 盛付通配置信息
 * 
 * @author sunaolin
 * 
 */
public class SPayConfig {

    /** 配置项名称 */
    private String name;

    /** 商户号 */
    private String merchantNo;

    /** 编码方式 */
    private String charset;

    /** 商户私钥信息 */
    private String privateKey;

    /** 盛付通公钥信息 */
    private String publicKey;

    /** 本地地址 */
    private String baseAddress;

    /** 盛付通接口地址 */
    private String apiUrl;

    /** 盛付通页面跳转地址 */
    private String webUrl;

    /** 盛付通账户充值地址 */
    private String rechargeUrl;

    /** 盛付通账户手机端充值地址 */
    private String rechargeMobileUrl;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMerchantNo() {
        return merchantNo;
    }

    public void setMerchantNo(String merchantNo) {
        this.merchantNo = merchantNo;
    }

    public String getCharset() {
        return charset;
    }

    public void setCharset(String charset) {
        this.charset = charset;
    }

    public String getPrivateKey() {
        return privateKey;
    }

    public void setPrivateKey(String privateKey) {
        this.privateKey = privateKey;
    }

    public String getPublicKey() {
        return publicKey;
    }

    public void setPublicKey(String publicKey) {
        this.publicKey = publicKey;
    }

    public String getBaseAddress() {
        return baseAddress;
    }

    public void setBaseAddress(String baseAddress) {
        this.baseAddress = baseAddress;
    }

    public String getApiUrl() {
        return apiUrl;
    }

    public void setApiUrl(String apiUrl) {
        this.apiUrl = apiUrl;
    }

    public String getWebUrl() {
        return webUrl;
    }

    public void setWebUrl(String webUrl) {
        this.webUrl = webUrl;
    }

    public String getRechargeUrl() {
        return rechargeUrl;
    }

    public void setRechargeUrl(String rechargeUrl) {
        this.rechargeUrl = rechargeUrl;
    }

    public String getRechargeMobileUrl() {
        return rechargeMobileUrl;
    }

    public void setRechargeMobileUrl(String rechargeMobileUrl) {
        this.rechargeMobileUrl = rechargeMobileUrl;
    }
	
	

}