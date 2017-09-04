package main.java.com.shop.domain.store;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * Created by Administrator on 2017/8/21.
 */
public class ContentCategory {
    private  Long id;//类目ID
    private  Long parentId;//父类目ID=0时，代表的是一级的类目
    private  String name;//分类名称
    private  Integer status;//状态。可选值:1(正常),2(删除)
    private  int sortOrder;//排列序号，表示同级类目的展现次序，如数值相等则按名称次序排列。取值范围:大于零的整数
    private  Integer isParent;//该类目是否为父类目，1为true，0为false
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

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public int getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(int sortOrder) {
        this.sortOrder = sortOrder;
    }

    public Integer getIsParent() {
        return isParent;
    }

    public void setIsParent(Integer isParent) {
        this.isParent = isParent;
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
