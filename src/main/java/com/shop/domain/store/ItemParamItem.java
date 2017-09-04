package main.java.com.shop.domain.store;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**商品规格和商品的关系表
 * Created by Administrator on 2017/8/21.
 */
public class ItemParamItem {
    private  Long id;//不同的商品分类有不同的规格参数，该表只和商品分类有关
    private  Long itemCatId;//商品类目ID
    private  String paramData;//参数数据，格式为json格式
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

    public Long getItemCatId() {
        return itemCatId;
    }

    public void setItemCatId(Long itemCatId) {
        this.itemCatId = itemCatId;
    }

    public String getParamData() {
        return paramData;
    }

    public void setParamData(String paramData) {
        this.paramData = paramData;
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
