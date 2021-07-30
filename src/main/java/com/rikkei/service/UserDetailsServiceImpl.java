package com.rikkei.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.rikkei.entity.User;
import com.rikkei.repository.UserRepository;
import com.rikkei.security.MyUserDetails;

/* Spring security cung cấp UserDetailsService để xử lý 
 * logic nghiệp vụ loadUserByUsername từ thông tin ở UserDetails.
 * Class UserDetailsServiceImpl được tạo để ta implement lại
 * phương thức đó.
 */

public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;
    
    @Override
    public UserDetails loadUserByUsername(String username) {
        // Kiểm tra xem user có tồn tại trong database không?
        User user = userRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("Could not file user!");
        }
        return new MyUserDetails(user);
    }
    
}
