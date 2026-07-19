package com.exploreJpLyrics.backend.security;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.exploreJpLyrics.backend.util.CrockfordBase32IdGenerator;

@Component
public class UserService {

	private final CrockfordBase32IdGenerator crockfordBase32IdGenerator;
	private final DefaultUserRepository defaultUserRepository;
	private final PasswordEncoder passwordEncoder;

	public UserService(CrockfordBase32IdGenerator crockfordBase32IdGenerator,
			DefaultUserRepository defaultUserRepository, PasswordEncoder passwordEncoder) {

		this.crockfordBase32IdGenerator = crockfordBase32IdGenerator;
		this.defaultUserRepository = defaultUserRepository;
		this.passwordEncoder = passwordEncoder;
	}

	public void createNewUser(CreateNewUserRequest createNewUserRequest) {

		String authority = "BASIC";
		String userId = crockfordBase32IdGenerator.generateId();

		DefaultUser defaultUser = new DefaultUser();
		defaultUser.setId(userId);
		defaultUser.setEmail(createNewUserRequest.getEmail());
		String password = createNewUserRequest.getPassword();
		String encodedPassword = passwordEncoder.encode(password);
		defaultUser.setPassword(encodedPassword);
		defaultUser.setAuthority(authority);

		defaultUserRepository.createNewUser(defaultUser);
	}
}
