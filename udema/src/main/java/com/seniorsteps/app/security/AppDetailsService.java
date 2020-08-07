package com.seniorsteps.app.security;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import com.seniorsteps.app.models.User;
import com.seniorsteps.app.repository.UserRepository;

@Service
public class AppDetailsService implements UserDetailsService, Serializable {
 
	private static final long serialVersionUID = 1L;
	
	@Autowired
    private UserRepository userRepository;
 
    @Override
    public UserDetails loadUserByUsername(String email) {
        
    	User user = userRepository.findUserByUsername(email);
    	
		AppUserPrincipal userPrincipal = new AppUserPrincipal(user);

        return userPrincipal;
    }
    
}