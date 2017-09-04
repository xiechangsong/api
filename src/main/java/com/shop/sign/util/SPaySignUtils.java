package main.java.com.shop.sign.util;

import main.java.com.shop.sign.*;
import org.apache.commons.collections4.MapUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.Validate;

import java.math.BigDecimal;
import java.util.*;

/**
 * 盛付通签名工具类
 * 
 * @author sunaolin
 * 
 */
public class SPaySignUtils {

    /**
     * 签名信息名称
     */
    public static final String SIGN_KEY = "sign";

    /**
     * 签名信息名称
     */
    public static final String SIGN_MSG_KEY = "SignMsg";

    /**
     * 禁止实例化
     */
    private SPaySignUtils() {}

    /**
     * 设置请求对象签名
     * 
     * @param request 请求对象
     * @param privateKey 私钥信息
     * @param charset 数据的编码方式
     */
    public static <T extends SPayRequest> void setSign(T request, String privateKey, String charset) {
        Validate.notNull(request);
        Validate.notEmpty(privateKey);
        Validate.notEmpty(charset);

        String signstr = request.getSignStr();
        String mysign = SignUtils.signWithSNK(signstr, privateKey, charset);

        request.setSign(mysign);
    }

    /**
     * 验证响应对象签名
     * 
     * @param response 响应对象
     * @param publicKey 公钥信息
     * @param charset 数据的编码方式
     * 
     * @return {@code true}：签名验证通过
     */
    public static <T extends SPayResponse> boolean verifyResponse(T response, String publicKey, String charset) {
        Validate.notNull(response);
        Validate.notEmpty(publicKey);
        Validate.notEmpty(charset);

        return SignUtils.verifyWithSNK(response.getSign(), response.getSignStr(), publicKey, charset);
    }

    /**
     * 验证异步通知对象签名
     * 
     * @param notify 异步通知对象
     * @param publicKey 公钥信息
     * @param charset 数据的编码方式
     * 
     * @return {@code true}：签名验证通过
     */
    public static <T extends SPayNotify> boolean verifyNotify(T notify, String publicKey, String charset) {
        Validate.notNull(notify);
        Validate.notEmpty(publicKey);
        Validate.notEmpty(charset);

        return SignUtils.verifyWithSNK(notify.getSign(), notify.getSignStr(), publicKey, charset);
    }

    /**
     * 获取签名的字符串
     * 
     * @param object 请求/响应对象
     * 
     * @return 返回签名字符串
     */
    public static <T extends SPayObject> String getSignStr(T object) {
        Validate.notNull(object);

        Map<String, String> params = getParams(object);
        params.remove(SIGN_KEY);
        params.remove(SIGN_MSG_KEY);

        String sign = createLinkString(params);
        System.out.println(sign);

        return sign;
    }

    /**
     * 获取签名的字符串
     * 
     * @param request 手机端充值请求
     * 
     * @return 返回签名字符串
     */
    /*public static String getSignStr(RechargeMobileRequest request) {
        Validate.notNull(request);

        StringBuilder sb = new StringBuilder();

        sb.append(getSignStr(request.getMerchantNo()));
        sb.append(getSignStr(request.getCharset()));
        sb.append(getSignStr(request.getRequestTime()));      
        sb.append(getSignStr(request.getOutMemberId()));      
        sb.append(getSignStr(request.getOutMemberRegistTime()));      
        sb.append(getSignStr(request.getOutMemberRegistIP()));      
        sb.append(getSignStr(request.getOutMemberVerifyStatus()));   
        sb.append(getSignStr(request.getOutMemberName()));   
        sb.append(getSignStr(request.getOutMemberMobile()));   
        sb.append(getSignStr(request.getMerchantOrderNo()));   
        sb.append(getSignStr(request.getProductName()));   
        sb.append(getSignStr(request.getProductDesc()));   
        sb.append(getSignStr(request.getCurrency()));   
        sb.append(getSignStr(request.getAmount()));   
        sb.append(getSignStr(request.getPageUrl()));
        sb.append(getSignStr(request.getNotifyUrl()));
        sb.append(getSignStr(request.getUserIP()));
        sb.append(getSignStr(request.getBankCardType()));
        sb.append(getSignStr(request.getBankCode()));
        sb.append(getSignStr(request.getExts()));
        sb.append(getSignStr(request.getSignType()));

        return sb.toString();
    }*/

    /**
     * 获取签名的字符串
     * 
     * @param request 手机端充值响应
     * 
     * @return 返回签名字符串
     */
    /*public static String getSignStr(RechargeWebResponse response) {
        Validate.notNull(response);

        StringBuilder sb = new StringBuilder();

        sb.append(getSignStr(response.getName()));
        sb.append(getSignStr(response.getVersion()));
        sb.append(getSignStr(response.getCharset()));
        sb.append(getSignStr(response.getTraceNo()));
        sb.append(getSignStr(response.getMsgSender()));
        sb.append(getSignStr(response.getSendTime()));
        sb.append(getSignStr(response.getInstCode()));
        sb.append(getSignStr(response.getOrderNo()));
        sb.append(getSignStr(response.getOrderAmount()));
        sb.append(getSignStr(response.getTransNo()));
        sb.append(getSignStr(response.getTransAmount()));
        sb.append(getSignStr(response.getTransStatus()));
        sb.append(getSignStr(response.getTransType()));
        sb.append(getSignStr(response.getTransTime()));
        sb.append(getSignStr(response.getMerchantNo()));
        sb.append(getSignStr(response.getErrorCode()));
        sb.append(getSignStr(response.getErrorMsg()));
        sb.append(getSignStr(response.getExt1()));
        sb.append(getSignStr(response.getSignType()));

        return sb.toString();
    }*/

    /**
     * 获取签名的字符串
     * 
     * @param request 电脑端充值请求
     * 
     * @return 返回签名字符串
     */
    /*public static String getSignStr(RechargeWebRequest request) {
        Validate.notNull(request);

        StringBuilder sb = new StringBuilder();
        sb.append(getSignStr(request.getName()));
        sb.append(getSignStr(request.getVersion()));
        sb.append(getSignStr(request.getCharset()));
        sb.append(getSignStr(request.getTraceNo()));
        sb.append(getSignStr(request.getMsgSender()));
        sb.append(getSignStr(request.getSendTime()));
        sb.append(getSignStr(request.getOrderNo()));
        sb.append(getSignStr(request.getOrderAmount()));
        sb.append(getSignStr(request.getOrderTime()));
        sb.append(getSignStr(request.getPayType()));
        sb.append(getSignStr(request.getPayChannel()));
        sb.append(getSignStr(request.getInstCode()));
        sb.append(getSignStr(request.getPageUrl()));
        sb.append(getSignStr(request.getBackUrl()));
        sb.append(getSignStr(request.getNotifyUrl()));
        sb.append(getSignStr(request.getProductName()));
        sb.append(getSignStr(request.getBuyerContact()));
        sb.append(getSignStr(request.getBuyerIp()));
        sb.append(getSignStr(request.getDepositId()));
        sb.append(getSignStr(request.getDepositIdType()));
        sb.append(getSignStr(request.getExt1()));
        sb.append(getSignStr(request.getSignType()));
        return sb.toString();
    }
*/
    /**
     * 获取签名的字符串
     * 
     * @param value 字符类型
     * 
     * @return 返回签名字符串
     */
    private static String getSignStr(String value) {
        if (StringUtils.isEmpty(value)) {
            return StringUtils.EMPTY;
        }
        return (value + "|");
    }

    /**
     * 获取签名的字符串
     * 
     * @param value 日期类型
     * 
     * @return 返回签名字符串
     */
    private static String getSignStr(Date value) {
        if (value == null) {
            return StringUtils.EMPTY;
        }
        return (DateUtils.format(value) + "|");
    }

    /**
     * 获取签名的字符串
     * 
     * @param value 金额类型
     * 
     * @return 返回签名字符串
     */
    private static String getSignStr(BigDecimal value) {
        if (value == null) {
            return StringUtils.EMPTY;
        }
        return (value.toString() + "|");
    }

    /**
     * 把数组所有元素排序，并按照“参数=参数值”的模式用“&”字符拼接成字符串
     * 
     * @param params 键值映射对象
     * 
     * @return 拼接后字符串
     */
    public static String createLinkString(Map<String, String> params) {
        List<String> keys = new ArrayList<String>(params.keySet());
        Collections.sort(keys);

        StringBuffer sb = new StringBuffer();

        for (int i = 0; i < keys.size(); i++) {
            String key = keys.get(i);
            String value = params.get(key);

            if (i == keys.size() - 1) {
                sb.append(key).append("=").append(value);
            }
            else {
                sb.append(key).append("=").append(value).append("&");
            }
        }

        return sb.toString();
    }

    /**
     * 根据请求/响应对象生成键值映射对象，并去掉值为空的键值对
     * 
     * @param object 请求/响应对象
     * 
     * @return 返回键值映射对象
     */
    private static <T extends SPayObject> Map<String, String> getParams(T object) {

        return paramFilter(JsonUtils.toMap(object));
    }

    /**
     * 除去键值映射对象中的空值
     * 
     * @param params 键值映射对象
     * 
     * @return 去掉空值的参数组
     */
   public static Map<String, String> paramFilter(Map<String, String> params) {
        Map<String, String> result = new HashMap<String, String>();

        if (MapUtils.isEmpty(params)) {
            return result;
        }

        for (String key : params.keySet()) {
            String value = params.get(key);

            if (StringUtils.isEmpty(value)) {
                continue;
            }
            result.put(key, value);
        }
        return result;
    }
}