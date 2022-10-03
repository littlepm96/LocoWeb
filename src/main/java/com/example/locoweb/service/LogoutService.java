package com.example.locoweb.service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutHandler;

public class LogoutService implements LogoutHandler {
    /** 
     *  Logout handler called in SecurityConfiguration.java
     */
    @Override
    public void logout(
        HttpServletRequest request, 
        HttpServletResponse response, 
        Authentication authentication) {
            Cookie[] cookies = request.getCookies();

            for(Cookie cookie : cookies) {
                if(cookie.getName().equals("JSESSIONID")) {
                    cookie.setMaxAge(0);
                }
            }

            request.getSession().invalidate();
    }
}
