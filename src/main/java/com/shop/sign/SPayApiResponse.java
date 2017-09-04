package main.java.com.shop.sign;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;



/**
 * 接口响应对象基类
 * 
 * @author sunaolin
 * 
 */
@XmlRootElement
public abstract class SPayApiResponse implements SPayResponse {

    /**
     * 对象序列化
     */
    private static final long serialVersionUID = -7676701476921017673L;

    /**
     * 错误代号
     */
    private String errorCode;

    /**
     * 错误描述
     */
    private String errorMessage;

    /**
     * 响应时间戳
     */
    private Date timestamp;

    /**
     * 签名信息
     */
    private String sign;

    /**
     * 错误代号
     * 
     * @return 错误代号
     */
    public String getErrorCode() {
        return errorCode;
    }

    /**
     * 错误代号
     * 
     * @param errorCode 错误代号
     */
    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    /**
     * 错误描述
     * 
     * @return 错误描述
     */
    public String getErrorMessage() {
        return errorMessage;
    }

    /**
     * 错误描述
     * 
     * @param errorMessage 错误描述
     */
    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    /**
     * 响应时间戳
     * 
     * @return 响应时间戳
     */
    public Date getTimestamp() {
        return timestamp;
    }

    /**
     * 响应时间戳
     * 
     * @param timestamp 响应时间戳
     */
    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    /**
     * 获取签名信息
     * 
     * @return 返回签名信息
     */
    public String getSign() {
        return sign;
    }

    /**
     * 签名信息
     * 
     * @param sign 签名信息
     */
    public void setSign(String sign) {
        this.sign = sign;
    }

    /*@Override
    public String getSignStr(){
        return SPaySignUtils.getSignStr(this);
    }*/
}