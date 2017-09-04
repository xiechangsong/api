package main.java.com.shop.sign.enums;

/**
 * 错误代号枚举
 * 
 * @author sunaolin
 * 
 */
public enum ErrorCode {

    /**
     * 成功，无错误
     */
    Success("ERROR_CODE_000", "200");

    /**
     * 错误代号
     */
    private String code;

    /**
     * Http错误代号
     */
    private String httpCode;

    /**
     * 构建错误枚举
     * 
     * @param code 错误代号
     * 
     * @param httpCode Http错误代号
     */
    private ErrorCode(String code, String httpCode) {
        this.code = code;
        this.httpCode = httpCode;
    }

    /**
     * 返回错误代号
     * 
     * @return 返回错误代号
     */
    public String getCode() {
        return code;
    }

    /**
     * 返回Http错误代号
     * 
     * @return Http错误代号
     */
    public String getHttpCode() {
        return httpCode;
    }
}