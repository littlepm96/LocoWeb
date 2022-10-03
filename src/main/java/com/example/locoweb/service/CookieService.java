package com.example.locoweb.service;

import java.util.Arrays;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

@Service
public class CookieService {
    public Optional<String> getValue(String key, HttpServletRequest request) {
        Optional<String> jsessionid = Arrays.stream(request.getCookies())
            .filter(cookie -> key.equals(cookie.getName()))
            .map(cookie -> cookie.getValue())
            .findAny();

        return jsessionid;
    }
}
