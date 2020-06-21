package com.yintu.ruixing.component;

import com.yintu.ruixing.common.enumobject.EnumAuthType;
import com.yintu.ruixing.entity.UserEntity;
import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.FilterInvocation;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;

import java.util.Collection;

/**
 * @author:mlf
 * @date:2020/5/18 19:54
 */

/**
 * (授权)自定义权限控制管理器（处理逻辑）
 */
@Component
public class CustomAccessDecisionManager implements AccessDecisionManager {
    private final AntPathMatcher antPathMatcher = new AntPathMatcher();

    @Override
    public void decide(Authentication authentication, Object object, Collection<ConfigAttribute> configAttributes) throws AccessDeniedException, InsufficientAuthenticationException {
//        //此处判断没有登录访问或者没有权限访问的url都可以通过
//        if (object instanceof FilterInvocation) {
//            FilterInvocation filterInvocation = (FilterInvocation) object;
//            if (antPathMatcher.match("/common/**", filterInvocation.getRequestUrl()))
//                return;
//        }
        if (authentication instanceof AnonymousAuthenticationToken) {
            throw new InsufficientAuthenticationException("尚未登录，请先登录");
        } else {
            //如果当前用户的auth_type为管理员，则用户拥有所有的权限,否则需要判断当前用户是否具有角色权限
            Object obj = authentication.getPrincipal();
            if (obj instanceof UserEntity) {
                UserEntity userEntity = (UserEntity) obj;
                if (userEntity.getAuthType().equals(EnumAuthType.ADMIN.getValue()))
                    return;
            }

            for (ConfigAttribute configAttribute : configAttributes) {
                String needRole = configAttribute.getAttribute();
                //如果当前用户的auth_type不是管理员，则判断是否是ROLE_LOGIN角色
                if (needRole.equals("ROLE_LOGIN")) {
                    break;
                }
                Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
                for (GrantedAuthority authority : authorities) {
                    if (authority.getAuthority().equals(needRole)) {
                        return;
                    }
                }
            }
            throw new AccessDeniedException("权限不足，请联系管理员");
        }
    }

    @Override
    public boolean supports(ConfigAttribute attribute) {
        return true;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return true;
    }
}
