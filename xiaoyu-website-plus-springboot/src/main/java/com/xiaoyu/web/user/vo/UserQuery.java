package com.xiaoyu.web.user.vo;

import com.xiaoyu.common.Pagination;
import lombok.Data;

@Data
public class UserQuery extends Pagination {
    private String username;
    private String realName;
}
