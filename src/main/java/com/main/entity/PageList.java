package com.main.entity;

import java.io.Serializable;
import java.util.List;

public class PageList<T extends Serializable> implements Serializable{

    private static final long serialVersionUID = -6177180431483012580L;
    private List<T> dataList;
    private PageCondition pager;

    public PageList() {
    }

    public List<T> getDataList() {
        return this.dataList;
    }

    public void setDataList(List<T> dataList) {
        this.dataList = dataList;
    }

    public PageCondition getPager() {
        return this.pager;
    }

    public void setPager(PageCondition pager) {
        this.pager = pager;
    }


}
