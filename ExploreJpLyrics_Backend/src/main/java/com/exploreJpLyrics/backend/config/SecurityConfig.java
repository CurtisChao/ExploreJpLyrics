package com.exploreJpLyrics.backend.config;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

	private final int ROUNDS = 8;

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests((authorize) -> authorize.anyRequest().permitAll()).csrf(csrf -> csrf.disable());

		return http.build();
	}

	@Bean
	public PasswordEncoder passwordEncoder() throws NoSuchAlgorithmException {
		SecureRandom secureRandom = SecureRandom.getInstanceStrong();
		return new BCryptPasswordEncoder(ROUNDS, secureRandom);
	}

}