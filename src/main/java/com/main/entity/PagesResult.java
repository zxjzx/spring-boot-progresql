package com.main.entity;

import com.main.pagemodel.BaseResult;

import java.io.Serializable;


public class PagesResult<T extends Serializable> extends BaseResult {
    private PageList<T> datas;

    public PagesResult() {
        super();
    }

    public PagesResult(String message, String result) {
        super(message, result);
    }

    public PagesResult(PageList<T> list) {
        super(WebConstants.RESULT_SUCCESS);
        this.setDatas(list);
    }

    public PageList<T> getDatas() {
        return datas;
    }

    public void setDatas(PageList<T> datas) {
        this.datas = datas;
    }
}
