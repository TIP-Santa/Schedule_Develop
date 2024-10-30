package com.sparta.schedule.filter;

import com.sparta.schedule.entity.Member;
import com.sparta.schedule.jwt.JwtUtil;
import com.sparta.schedule.repository.MemberRepository;
import io.jsonwebtoken.Claims;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.io.IOException;

@Slf4j(topic = "AuthFilter")
@Component
@Order(2)
public class AuthFilter implements Filter {

    private final MemberRepository memberRepository;
    private final JwtUtil jwtUtil;

    public AuthFilter(MemberRepository memberRepository, JwtUtil jwtUtil) {
        this.memberRepository = memberRepository;
        this.jwtUtil = jwtUtil;
    }

    @Override
    public void doFilter(ServletRequest request,
                         ServletResponse response,
                         FilterChain chain) throws IOException, ServletException {

        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        String url = httpServletRequest.getRequestURI();

        if (StringUtils.hasText(url) &&
                (url.equals("/api/member/login") || url.equals("/api/member/signup"))
        ) {
            chain.doFilter(request, response);
        } else {
            String tokenValue = jwtUtil.getTokenFromRequest(httpServletRequest);
            if (StringUtils.hasText(tokenValue)) {
                String token = jwtUtil.substringToken(tokenValue);
                if (!jwtUtil.validateToken(token)) {
                    throw new IllegalArgumentException("Token Error");
                }
                Claims info = jwtUtil.getUserInfoFromToken(token);
                Member member = memberRepository.findByUserEmail(info.getSubject()).orElseThrow(() ->
                        new NullPointerException("Not Found User")
                );
                request.setAttribute("member", member);
                chain.doFilter(request, response);
            } else {
                throw new IllegalArgumentException("Not Found Token");
            }
        }
    }
}
