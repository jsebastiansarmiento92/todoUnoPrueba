package com.todouno.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.todouno.model.User;
import com.todouno.repositories.IRepoUser;
import com.todouno.security.UserPrincipal;


@Service
public class UserDetailsServiceImpl implements UserDetailsService{

	
	@Autowired
    IRepoUser userRepo;
	
	@Override
	@Transactional
	public UserDetails loadUserByUsername(String nameUser) throws UsernameNotFoundException {
		User usuario = userRepo.findByNombreUsuario(nameUser).get();
        return UserPrincipal.build(usuario);
	}

	
}
