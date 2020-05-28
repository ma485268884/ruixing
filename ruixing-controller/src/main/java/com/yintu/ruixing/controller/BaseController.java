package com.yintu.ruixing.controller;

import com.yintu.ruixing.entity.UserEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * @author:mlf
 * @date:2020/5/21 10:47
 */
public class BaseController {

    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * 获取登录用户信息
     *
     * @return 用户信息
     */
    protected UserEntity getLoginUser() {
        SecurityContext sc = SecurityContextHolder.getContext();
        Authentication auth = sc.getAuthentication();
        return (UserEntity) auth.getPrincipal();
    }

    /**
     * 获取登录用户信息id
     *
     * @return 用户信息
     */
    protected Long getLoginUserId() {
        return this.getLoginUser().getId();
    }
}
