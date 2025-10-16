package com.gestione.Immobiliare.security;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.gestione.Immobiliare.model.Utente;
import com.gestione.Immobiliare.repository.UtenteRepository;

@Configuration
public class UserConfig {
	@Autowired
	private UtenteRepository utenteRepository;

    @Bean
    public UserDetailsService userDetailsService() {
    	return email -> {
    		Utente utente = utenteRepository.findByEmail(email)
    				.orElseThrow(() -> new UsernameNotFoundException("Email: " + email + " non trovata"));
    	
        return User.builder()
        		.username(utente.getEmail())
        		.password(utente.getPassword())
        		.roles(utente.getRuolo().name())
                .build();
    	};
    }
}

