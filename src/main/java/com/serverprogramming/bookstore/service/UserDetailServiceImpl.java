package com.serverprogramming.bookstore.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.serverprogramming.bookstore.domain.User;
import com.serverprogramming.bookstore.domain.UserRepository;

@Service
public class UserDetailServiceImpl implements UserDetailsService {

	private final UserRepository repository;

	@Autowired
	public UserDetailServiceImpl(UserRepository userRepository) {
		this.repository = userRepository;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		User foundUser = repository.findByUsername(username);
		UserDetails user = new org.springframework.security.core.userdetails.User(username,
				foundUser.getHashedPassword(), AuthorityUtils.createAuthorityList(foundUser.getRole()));
		return user;
	}
}
