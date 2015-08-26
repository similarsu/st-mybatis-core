package cn.st.mybatis.core.entity;

import cn.st.mybatis.core.support.Pager;

/**
 * <p>
 * desciption:
 * </p>
 * 
 * @author coolearth
 * @date 2015年8月11日
 */
public class BaseEntity {
    private Pager pager;

    private String orderStr;

    public Pager getPager() {
        return pager;
    }

    public void setPager(Pager pager) {
        this.pager = pager;
    }

    public String getOrderStr() {
        return orderStr;
    }

    public void setOrderStr(String orderStr) {
        this.orderStr = orderStr;
    }



}
