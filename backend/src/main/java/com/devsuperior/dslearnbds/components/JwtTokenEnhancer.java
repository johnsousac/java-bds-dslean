package com.devsuperior.dslearnbds.components;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.stereotype.Component;

import com.devsuperior.dslearnbds.entities.User;
import com.devsuperior.dslearnbds.repositories.UserRepository;

@Component
public class JwtTokenEnhancer implements TokenEnhancer {
	
	@Autowired
	private UserRepository userRepository;

	// ao implementar esse método, eh adicionado no token as informacoes que queremos
	// (que implementamos aqui)
	@Override
	public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
		User user = userRepository.findByEmail(authentication.getName()).get();
		
		// map de informacoes extras que serao adicionadas no token
		Map<String, Object> map = new HashMap<>();
//		map.put("userFirstName", user.getFirstName());
		map.put("userId", user.getId());
		
		// DefaultOAuth2AccessToken tipo mais especifico de OAuth2AccessToken ou seja uma 
		// subclasse, nessa classe eh que tem o metodo para adicionarmos informacoes ao
		// token
		DefaultOAuth2AccessToken token = (DefaultOAuth2AccessToken) accessToken;
		token.setAdditionalInformation(map);
		
		// retornando instancia do token original (accessToken), mas nos poderiamos retornar a variavel token tb
		return accessToken;
		
	}

}
