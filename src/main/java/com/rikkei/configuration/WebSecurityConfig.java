package com.rikkei.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.rikkei.service.UserDetailsServiceImpl;

@EnableWebSecurity //Kích hoạt tính năng Web Security
@EnableGlobalMethodSecurity(securedEnabled = true) //Giúp các annotation @Secured ở PersonController hoạt động.
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    //Phần bean em đọc vẫn chưa hiểu lắm, mới biết nó là một object
    @Bean
    public UserDetailsService userDetailsService() {
    	return new UserDetailsServiceImpl();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        // Password encoder, để Spring Security sử dụng mã hóa mật khẩu người dùng
    	// khi lưu vào database sẽ không hiện mật khẩu mà chỉ hiện một mã băm.
        return new BCryptPasswordEncoder();
    }
    
    @Override
    protected void configure(AuthenticationManagerBuilder auth)
            throws Exception {
        auth.userDetailsService(userDetailsService()) // Cung cấp userDetailsService cho spring security
            .passwordEncoder(passwordEncoder()); // cung cấp password encoder
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
    	http.authorizeRequests()
        .anyRequest().authenticated() // Tất cả các request đều cần phải xác thực mới được truy cập
        .and()
        .formLogin() // Cho phép người dùng xác thực bằng form login
        .defaultSuccessUrl("/index") //Xác thực thành công sẽ được đưa tới index.html
        .permitAll()// Tất cả đều được truy cập vào địa chỉ này
    	.and()
    	.logout() // Cho phép logout
    	.permitAll();

    }
}