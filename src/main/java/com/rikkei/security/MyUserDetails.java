package com.rikkei.security;

import java.util.Collection;
import java.util.Arrays;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.rikkei.entity.User;

/* Mặc định Spring Security cung cấp interface UserDetails để chứa thông tin người dùng
 * Class này giúp ta đưa thông tin từ class User vào UserDetails.
 */

public class MyUserDetails implements UserDetails {
	private static final long serialVersionUID = 1L;
	private User user;  
	
	
	public MyUserDetails(User user) {
		this.user = user;
	}
	
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        SimpleGrantedAuthority authority = new SimpleGrantedAuthority(user.getRole());
        return Arrays.asList(authority);
    }
	
    public String getUsername() {
		return user.getUsername();
	}

	public String getPassword() {
		return user.getPassword();
	}

	@Override
    public boolean isAccountNonExpired() {
        return true;
    }

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}