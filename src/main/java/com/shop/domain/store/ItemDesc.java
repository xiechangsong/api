package main.java.com.shop.domain.store;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * Created by Administrator on 2017/8/21.
 */
public class ItemDesc {
    private  Long itemId;//商品ID
    private  String itemDesc;//商品描述
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date created;//创建时间
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private  Date updated;//修改时间

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public String getItemDesc() {
        return itemDesc;
    }

    public void setItemDesc(String itemDesc) {
        this.itemDesc = itemDesc;
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
