package com.devsuperior.dslearnbds.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.dslearnbds.entities.User;
import com.devsuperior.dslearnbds.repositories.UserRepository;
import com.devsuperior.dslearnbds.services.exceptions.ForbiddenException;
import com.devsuperior.dslearnbds.services.exceptions.UnauthorizedException;

@Service
public class AuthService {
	
	@Autowired
	private UserRepository userRepository;

	@Transactional(readOnly = true)
	public User authenticated() {
		// pega o nome do usuario que ja foi reconhecido pelo spring security
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		return userRepository.findByEmail(username).orElseThrow(() -> new UnauthorizedException("Invalid user"));
	}
	
	public void validateSelfOfAdmin(Long userId) {
		User user = authenticated();
		
		// se usuario logado estiver tentando pesquiar outro usuario
		// e esse usuario não tiver o role admin, entao seu acesso sera 
		// barrado
		
		if(!user.getId().equals(userId) && !user.hasRole("ROLE_ADMIN")) {
			throw new ForbiddenException("Access denied");
		}
	}
}
