package com.tony.springsecurity.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
//@EnableWebSecurity
@Order(Ordered.LOWEST_PRECEDENCE - 15) //Another먼저 매칭
public class AnotherSecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
//                .antMatchers("/") //antMatchers는 안주면 모든 matchers에 사용됨
//                .mvcMatchers("/", "info", "/account/**").permitAll()
//                .mvcMatchers("/admin").hasRole("ADMIN"), 즉 모든곳에 인증 필요
                .anyRequest().authenticated();

        http.formLogin();
        http.httpBasic();
    }

}
