package main.java.com.shop.domain.store;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * Created by Administrator on 2017/8/21.
 */
public class item {
    private  Long id;//商品id，同时也是商品编号
    private  String title;//商品标题
    private  String sellPoint;//商品卖点
    private  Double price;//商品价格，单位为：分
    private int num;//库存数量
    private  String barcode;//商品条形码
    private  String image;//商品图片
    private  Long cid;//所属类目，叶子类目
    private  Integer status;//商品状态，1-正常，2-下架，3-删除
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date created;//创建时间
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private  Date updated;//修改时间

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSellPoint() {
        return sellPoint;
    }

    public void setSellPoint(String sellPoint) {
        this.sellPoint = sellPoint;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Long getCid() {
        return cid;
    }

    public void setCid(Long cid) {
        this.cid = cid;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }
}
