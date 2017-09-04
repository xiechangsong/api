package main.java.com.shop.sign;

/**
 * 客户端异常
 * 
 * @author sunaolin
 * 
 */
public class SPayException extends RuntimeException {
    /**
     * 对象序列化
     */
    private static final long serialVersionUID = -1155507267819952948L;

    /** 错误代号 */
    private String errCode;

    /** 错误描述 */
    private String errMsg;

    public SPayException() {
        super();
    }

    public SPayException(String message, Throwable cause) {
        super(message, cause);
    }

    public SPayException(String message) {
        super(message);
    }

    public SPayException(Throwable cause) {
        super(cause);
    }

    public SPayException(String errCode, String errMsg) {
        super(errCode + ":" + errMsg);
        this.errCode = errCode;
        this.errMsg = errMsg;
    }

    public String getErrCode() {
        return this.errCode;
    }

    public String getErrMsg() {
        return this.errMsg;
    }
}