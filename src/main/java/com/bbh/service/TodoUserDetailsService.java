package com.bbh.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bbh.model.Role;
import com.bbh.model.User;
import com.bbh.repository.UserRepo;


@Service
@Transactional
public class TodoUserDetailsService implements UserDetailsService {
	
	@Autowired
	private UserRepo userRepo;

	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		addUser("boma", "password", new String[] {"USER"});
		
		User user = userRepo.findByUsername(username);
	    if (user != null) {
	    	Set<GrantedAuthority> grantedAuthorities = new HashSet<GrantedAuthority>();
	        for (Role role : user.getRoles()){
	            grantedAuthorities.add(new SimpleGrantedAuthority(role.getName()));
	        }

	        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), grantedAuthorities);
	    } else {
	      throw new UsernameNotFoundException("User not found.");
	    }
	}
	
	public void addUser(String username, String password, String[] _roles) {
		Set<Role> roles = new HashSet<Role>();
		for(String s:_roles) {
			roles.add(new Role(s));
		}
		userRepo.save(new User(1,username,new BCryptPasswordEncoder(11).encode(password),roles));
	}

}
