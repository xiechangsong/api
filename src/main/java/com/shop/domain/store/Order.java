package main.java.com.shop.domain.store;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**订单
 * Created by Administrator on 2017/8/21.
 */
public class Order {
    private  String orderId;//订单id
    private  String payment;//实付金额。精确到2位小数;单位:元。如:200.07，表示:200元7分
    private Integer paymentType;//支付类型，1、在线支付，2、货到付款
    private  String postFee;//邮费。精确到2位小数;单位:元。如:200.07，表示:200元7分
    private  Integer status;//状态：1、未付款，2、已付款，3、未发货，4、已发货，5、交易成功，6、交易关闭
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date createTime;//订单创建时间
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date updateTime;//订单更新时间
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date paymentTime;//付款时间
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date consignTime;//发货时间
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date endTime;//交易完成时间
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date closeTime;//交易关闭时间
    private  String shippingName;//物流名称
    private  String shippingCode;//物流单号
    private  Long userId;//用户id
    private  String buyerMessage;//买家留言
    private  String buyerNick;//买家昵称
    private  Integer buyerRate;//买家是否已经评价

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getPayment() {
        return payment;
    }

    public void setPayment(String payment) {
        this.payment = payment;
    }

    public Integer getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(Integer paymentType) {
        this.paymentType = paymentType;
    }

    public String getPostFee() {
        return postFee;
    }

    public void setPostFee(String postFee) {
        this.postFee = postFee;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Date getPaymentTime() {
        return paymentTime;
    }

    public void setPaymentTime(Date paymentTime) {
        this.paymentTime = paymentTime;
    }

    public Date getConsignTime() {
        return consignTime;
    }

    public void setConsignTime(Date consignTime) {
        this.consignTime = consignTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Date getCloseTime() {
        return closeTime;
    }

    public void setCloseTime(Date closeTime) {
        this.closeTime = closeTime;
    }

    public String getShippingName() {
        return shippingName;
    }

    public void setShippingName(String shippingName) {
        this.shippingName = shippingName;
    }

    public String getShippingCode() {
        return shippingCode;
    }

    public void setShippingCode(String shippingCode) {
        this.shippingCode = shippingCode;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getBuyerMessage() {
        return buyerMessage;
    }

    public void setBuyerMessage(String buyerMessage) {
        this.buyerMessage = buyerMessage;
    }

    public String getBuyerNick() {
        return buyerNick;
    }

    public void setBuyerNick(String buyerNick) {
        this.buyerNick = buyerNick;
    }

    public Integer getBuyerRate() {
        return buyerRate;
    }

    public void setBuyerRate(Integer buyerRate) {
        this.buyerRate = buyerRate;
    }
}
