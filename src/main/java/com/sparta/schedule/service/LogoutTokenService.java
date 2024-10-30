package com.sparta.schedule.service;

import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class LogoutTokenService {

    private final Set<String> logoutTokens = new HashSet<String>();

    public void addLogoutToken(String token) {
        logoutTokens.add(token);
    }
    public boolean isTokenLogout(String token) {
        return logoutTokens.contains(token);
    }
}
