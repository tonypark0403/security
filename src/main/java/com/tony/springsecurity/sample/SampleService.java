package com.tony.springsecurity.sample;

import com.tony.springsecurity.acount.Account;
import com.tony.springsecurity.acount.AccountContext;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class SampleService {
    public void dashboard() {
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        Object principal = authentication.getPrincipal(); // user
//        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities(); // authorities
//        Object credentials = authentication.getCredentials();
//        boolean authenticated = authentication.isAuthenticated();
        //dashboard는 파라미터를 안받음, 이건 테스트를 위해 우리가 수동으로 한거고, 스프링 객체가 자동 처리함
//        Account account = AccountContext.getAccount();
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        System.out.println("===============");
        System.out.println(authentication);
        System.out.println(userDetails.getUsername());
        System.out.println(userDetails.getAuthorities());
    }
}
