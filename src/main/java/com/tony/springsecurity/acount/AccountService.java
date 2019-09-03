package com.tony.springsecurity.acount;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AccountService implements UserDetailsService {

    @Autowired
    AccountRepository accountRepository;
    //SQL이든 No-SQL이든 내가 원하는것으로 구현하면 됨

    @Autowired
    PasswordEncoder passwordEncoder;

    //이 인터페이스의 목적은 Account를 UserDetails로 변경하는 역할만 함
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Account account = accountRepository.findByUsername(username);
        if (account == null) {
            throw new UsernameNotFoundException(username);
        }
        //UserDetails로 변경하기위해 쵝근부터 User.builder()를 제공 - User는 UserDetails를 상속받음
        return User.builder()
                .username(account.getUsername())
                .password(account.getPassword()) //Todo: {noop}123
                .roles(account.getRole())
                .build();
    }

    public Account createNew(Account account) {
        account.encodePassword(passwordEncoder);
        return this.accountRepository.save(account);
    }
}
