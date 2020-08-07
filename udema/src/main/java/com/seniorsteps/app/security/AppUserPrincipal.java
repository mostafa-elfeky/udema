package com.seniorsteps.app.security;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.seniorsteps.app.models.User;


public class AppUserPrincipal implements UserDetails {

	private static final long serialVersionUID = 1L;
	
	private User user;
 
    public AppUserPrincipal(User user) {
        this.user = user;
    }
    
    public User getUser() {
    	return this.user;
    }

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		
		ArrayList<GrantedAuthority> auth = new ArrayList<>();
		
		auth.add(
				new GrantedAuthority() {

					private static final long serialVersionUID = 1L;

					@Override
					public String getAuthority() {
						return user.getType().getCode();
					}
				}
			);
		
		return auth;
	}

	@Override
    public String getPassword() {
        return user.getPassword();
    }
 
    @Override
    public String getUsername() {
        return user.getUsername();
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