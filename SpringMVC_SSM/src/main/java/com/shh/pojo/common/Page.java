package com.shh.pojo.common;

import java.io.Serializable;

/**
 * @author :         wujun
 * @version :        1.0
 * @description :
 * @date :     2018/11/6 11:31
 */
public class Page implements Serializable {
    private int pageIndex;
    private int pageSize;
    private int startRow;

    public Page(int pageIndex, int pageSize) {
        this.pageIndex = pageIndex;
        this.pageSize = pageSize;
        this.startRow = pageIndex > 0 ? (pageIndex - 1) * pageSize : 0;
    }

    public void changePageSize(int pageSize) {
        this.pageSize = pageSize;
        if (pageIndex==0){
            pageIndex = 1;
        }
        this.startRow = pageIndex > 0 ? (pageIndex - 1) * pageSize : 0;
    }

    public int getPageSize() {
        return pageSize;
    }

    public int getStartRow() {
        return startRow;
    }

    public int getPageIndex() {
        return pageIndex;
    }
}