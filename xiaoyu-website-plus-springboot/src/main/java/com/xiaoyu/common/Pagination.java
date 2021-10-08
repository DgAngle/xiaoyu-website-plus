package com.xiaoyu.common;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

/**
 * 分页
 */
@Data
public class Pagination {
    public static long default_currentPage = 1; // 默认当前页
    public static long default_pageCount = 15; // 默认每页数量

    private long currentPage; // 当前页码
    private long pageCount; // 每页数量

    public long getCurrentPage() {
        this.currentPage = currentPage < 1 ? 1 : default_currentPage;
        return currentPage;
    }

    public long getPageCount() {
        this.pageCount = pageCount < 1 ? 15 : default_pageCount;
        return pageCount;
    }
}
