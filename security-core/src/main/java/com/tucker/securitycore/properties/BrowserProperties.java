package com.tucker.securitycore.properties;

import lombok.Data;

@Data
public class BrowserProperties {

    /**
     * 默认登录页面
     */
    private String LoginPage = "/login.html";
    /**
     * 默认登出页面
     */
    private String LogoutPage = "/logout.html";
    /**
     * 默认登录格式
     */
    private LoginType loginType = LoginType.JSON;
    /**
     * 默认RememberMe时间
     */
    private int rememberMeSeconds = 3600;
    /**
     * 默认注册页面
     */
    private String SignUpUrl = "/user/register";
}
