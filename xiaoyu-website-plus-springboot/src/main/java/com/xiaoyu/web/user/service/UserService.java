package com.xiaoyu.web.user.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.xiaoyu.common.Pagination;
import com.xiaoyu.web.user.bean.User;
import com.xiaoyu.web.user.mapper.UserMapper;
import com.xiaoyu.web.user.vo.UserQuery;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserService {

    @Resource
    private UserMapper userMapper;

    /**
     * 添加用户
     *
     * @param user 用户信息
     */
    public int addUser(User user) {
        return userMapper.insert(user);
    }

    /**
     * 查询用户列表, 带分页
     *
     * @param userQuery 用户查询条件
     * @return 用户列表
     */
    public Page<User> queryUserList(UserQuery userQuery) {

        // 创建Page对象
        Page<User> pageUser = new Page<>(userQuery.getCurrentPage(), userQuery.getPageCount());

        // 构建条件
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByDesc("createDt");


        // 多条件组合查询, 动态 sql
        if (StringUtils.isNotBlank(userQuery.getUsername())) {
            queryWrapper.like("username", userQuery.getUsername());
        }
        if (StringUtils.isNotBlank(userQuery.getRealName())) {
            queryWrapper.like("realName", userQuery.getRealName());
        }

        // 调用分页方法, 记得去Config底下添加分页插件
        // 调用方法的时候, 底层封装, 把分页所有数据封装到 pageUser 中
        userMapper.selectPage(pageUser, queryWrapper);

        return pageUser;

    }


}
