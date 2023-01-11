package com.porfolio.app.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import com.porfolio.app.dto.RegiserUserDTO;
import com.porfolio.app.dto.UserDTO;
import com.porfolio.app.model.User;

@Service
public interface IJwtUserDetailsService extends UserDetailsService {
	
	public User loadUser(String username);

	public User save(UserDTO userDTO);
	
	public User saveUser(RegiserUserDTO userDTO);
	
	
}