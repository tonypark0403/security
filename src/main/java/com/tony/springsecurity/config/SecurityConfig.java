package com.tony.springsecurity.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity //이건 없어도 상관없음 - 스프링 부트 자동설정이 알아서 추가
@Order(Ordered.LOWEST_PRECEDENCE - 10)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
//                .mvcMatchers("/", "info", "/account/**").permitAll()
//                .mvcMatchers("/admin").hasRole("ADMIN")
//                .anyRequest().authenticated();
                .antMatcher("/account/**")
                .authorizeRequests()
                .anyRequest().permitAll(); // 전부 허용으로 AnotherSecurityConfig가 반대로 셋팅

        http.formLogin();
        http.httpBasic();
    }

}
