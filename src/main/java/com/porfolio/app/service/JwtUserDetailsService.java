package com.porfolio.app.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.porfolio.app.dto.RegiserUserDTO;
import com.porfolio.app.dto.UserDTO;
import com.porfolio.app.exception.UserAlreadyExistAuthenticationException;
import com.porfolio.app.model.Domicile;
import com.porfolio.app.model.Person;
import com.porfolio.app.model.User;
import com.porfolio.app.repository.PersonRepository;
import com.porfolio.app.repository.UserRepository;

@Qualifier("jwtService")
@Service
public class JwtUserDetailsService implements IJwtUserDetailsService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PasswordEncoder bcryptEncoder;
	
	@Autowired
	private PersonRepository personRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		User user = (User) userRepository.findByUsername(username);
		if (user == null) {
			throw new UsernameNotFoundException("User not found with username: " + username);
		}
		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
				new ArrayList<>());
	}
	
	public User loadUser(String username) throws UsernameNotFoundException {
		User user = (User) userRepository.findByUsername(username);
		if (user == null) {
			throw new UsernameNotFoundException("User not found with username: " + username);
		}
		
		return user;
	}

	public User save(UserDTO userDTO) {
		
		User userDB = (User) userRepository.findByUsername(userDTO.getUsername());
		if (userDB != null) 
			throw new UserAlreadyExistAuthenticationException(userDTO.getUsername());
		
		User newUser = new User();
		newUser.setUsername(userDTO.getUsername());
		newUser.setPassword(bcryptEncoder.encode(userDTO.getPassword()));		
		
		return userRepository.save(newUser);		
	}
	
	public User saveUser(RegiserUserDTO userDTO) {
		
		User userDB = (User) userRepository.findByUsername(userDTO.getUsername());
		if (userDB != null) 
			throw new UserAlreadyExistAuthenticationException(userDTO.getUsername());
		
		User newUser = new User();
		newUser.setUsername(userDTO.getUsername());
		newUser.setPassword(bcryptEncoder.encode(userDTO.getPassword()));
				
		//Crear la persona
		Person p = new Person();
		
		p.setName(userDTO.getName());
		p.setSurname(userDTO.getSurname());
		p.setEmail(userDTO.getEmail());
		p.setTel(userDTO.getTel());
		p.setAboutMe(userDTO.getAboutMe());
		
		Domicile dom = new Domicile();
		dom.setAddress(userDTO.getAddress());
		dom.setLocalidad(userDTO.getLocalidad());
		
		//Agregar el domicilio
		p.setDomicile(dom);
		
		//Agregar el usuario
		p.setUser(newUser);
		
		//Guardar la persona
		personRepository.save(p);
		
		//Devolver el usuario guardado
		return ((User) userRepository.findByUsername(userDTO.getUsername()));		
	}
	
	
}