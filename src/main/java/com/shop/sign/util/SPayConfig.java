package main.java.com.shop.sign.util;

/**
 * 盛付通配置选项
 * 
 * @author sunaolin
 * 
 */
public class SPayConfig {
	/**
     * 电脑端充值地址(测试环境)
     */
    public static final String SPAY_RECHARGE_URL = "https://mastest.shengpay.com/";
    
    /**
     * 查询API接口地址(测试环境)
     */
    public static final String API_URL="http://wdtest.shengpay.com/api/";

    /**
     * 电脑端充值地址(测试环境)
     */
    public static final String SPAY_MOBILE_RECHARGE_URL = "http://61.152.90.48:8088/html5-gateway-general";

    /**
     * 资金托管接口地址(测试环境)
     */
    public static final String SPAY_API_URL = "http://wdtest.shengpay.com/api";

    /**
     * 页面跳转地址(测试环境)
     */
    public static final String SPAY_WEB_URL = "http://wdtest.shengpay.com";

    /**
     * 商户的私钥信息
     */
    public static final String MERCHANT_PRIVATE_KEY ="BwIAAAAkAABSU0EyAAQAAAEAAQCZ6tC8GIA1bTZWpEfGKPK17SYDK5b/1md3csufS/mUYqE6qGwaB04emmaG3ObSLPpE9QOS2p2TyanedoelfsfoOHDuXCl1eIiz1OUnC+6Z9jcO0FafKuhXzbZ4oJa9LpHmI+zuPlAusHhjReW50XWRSw5tuAJ/fpGLDhX3KkTZoDf23pGH1/TFM8lvtjBtkwHqclkMf95emym5QwvfNBNKF8I06NKt4SexnZ6NXnsYiAGeQiVAFDIlqwmUCsZNK9OvvWAT6N5W5f2AFEiB4GjYhF4ccYxqqJkoZWKZnMCjMk25x/QocdykzZ3sORhvVmzzYEx39llhRhAZqQHZIP/CfcxU68f4PcMW5HFZj9uJske+HnuxVVQYjpf4TI55pq+szCCJAJ8wbKD5tyyW/v6jLXXVCesl18pGXxSeYlsYB/v+6b412E+4ACVt3syFFPWBxNwY8UycW2xL9tPeuyQVSwZODJdcr1bLw3kR4WW864B1lMF6I4N19GkSLSGFYISDmJKk6y9RaDMTtAOariMJ5EGpFOcE6RvnJRGIueJOpS29+/PClRxeBtDQ5igzrQGKwCIU1+6TMHi46uyZTNOSFbzoA1ODnsHQiuRuMYC3JVD916W+JORZikBIDWSDijgZ1Koi8Iv68Ua6yc/pm0kFSEv+KSJmJI47+7aC2ue2Cuou3LUCSiTcMP5Qd+P+CA4yb/0eWTjsO81W/y+KPK20qPWdI6n2JlPGHTGDswJ6S+LGxI74k9DezKFKo5spMBU=";

    /**
     * 盛付通的公钥信息
     */
    public static final String SPAY_PUBLIC_KEY = "ACQAAASAAACUAAAABgIAAAAkAABSU0ExAAQAAAEAAQCvPKuUnRKvI8ed92Q/xoqhfFtCEDzd8wQt0M775b6egKsgRGOKEqzYI3LhNQKLnhVxOQ/0Y2V85ez2eUp1fP5WMMj8oWdqGBJDbXEQUK0jKvdDBRlWv0RB/XMSvbBBSHDZTrPckvjWn8OU6C+5uHVFSoxSNFEXfNw4JHZ93wXQpw==";

    /**
     * 接口签名算法
     */
    public static final String SIGN_TYPE = "RSA";

    /**
     * 接口的编码方式
     */
    public static final String CHARSET = "UTF-8";

    /**
     * 通讯超时时间
     */
    public static final long TIMEOUT = 36000;

    /**
     * 请求和响应媒体类型
     */
    public final static String APPLICATION_JSON = "application/json";

    /**
     * 时间格式
     */
    public static final String DATE_TIME_FORMAT = "yyyyMMddHHmmss";
    /**
     * 平台商户号
     */
    public static final String MERCHANT_NO = "708732";
    

	/**
	 * OPEN_ACCOUNT_URL:开户请求完整地址POST URL
	 */
	public static final String OPEN_ACCOUNT_URL = SPAY_WEB_URL + "/user/account/register.html";
	
	/**
	 * PC充值异步通知地址
	 */
	public static final String RECHARGE_NOTIFY_URL = "http://zhitol.tunnel.qydev.com/zt/user-account/rehargeNotify";
	/**
	 * PC充值同步回调地址
	 */
	public static final String RECHARGE_PAGE_URL = "http://localhost:8080/zt/user-account/rehargeResult";
	/**
	 * PC充值返回商户地址
	 */
	public static final String RECHARGE_BACK_URL = "http://localhost:8080/zt/user/center";
	/**
	 * PC提现异步通知地址
	 */
	public static final String CASH_NOTIFY_URL = "http://zhitol.tunnel.qydev.com/zt/user-account/cashNotify";
	/**
	 * PC提现同步回调地址
	 */
	public static final String CASH_BACK_URL = "http://localhost:8080/zt/user-account/cashSuccess";
	/**
	 * PC投标异步通知地址
	 */
	public static final String TENDER_NOTIFY_URL = "http://zhitol.tunnel.qydev.com/zt/borrow/tenderNotify";
	/**
	 * PC投标同步回调地址
	 */
	public static final String TENDER_BACK_URL = "http://localhost:8080/zt/borrow/tenderResult";
	/**
	 * PC转账异步通知地址
	 */
	public static final String TRANSFER_NOTIFY_URL = "http://zhitol.tunnel.qydev.com/zt/admin/user-account/TransferNotify";
	
}
