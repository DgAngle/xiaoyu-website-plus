package com.xiaoyu.web.user.controller;

import com.alibaba.fastjson.JSON;
import com.aliyun.oss.common.utils.LogUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xiaoyu.common.Pagination;
import com.xiaoyu.common.R;
import com.xiaoyu.web.user.bean.User;
import com.xiaoyu.web.user.service.UserService;
import com.xiaoyu.web.user.vo.UserQuery;
import org.apache.commons.logging.Log;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
@RequestMapping("/user")
public class UserController {


    private static Log log = LogUtils.getLog();

    @Resource
    private UserService userService;

    @RequestMapping("/add")
    @ResponseBody
    public R add(User user) {
        log.info("接收参数: " + JSON.toJSON(user));
        userService.addUser(user);
        return R.success()
                .data("msg", "添加成功！");
    }

    @RequestMapping("/list")
    @ResponseBody
    public R list(UserQuery userQuery) {
        log.info("接收参数: userQuery = " + JSON.toJSON(userQuery));
        Page<User> userPage = userService.queryUserList(userQuery);
        return R.success()
                .data("userList", userPage.getRecords())
                .data("total", userPage.getTotal())
                .data("currentPage", userPage.getCurrent())
                .data("pageCount", userPage.getSize());
    }

    @RequestMapping("test")
    @ResponseBody
    public R test() {
        System.out.println("请求接口成功!");
        return R.success().data("msg", "请求接口成功！");
    }
}
