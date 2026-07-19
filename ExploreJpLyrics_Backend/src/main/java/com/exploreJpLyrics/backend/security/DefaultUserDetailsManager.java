package com.exploreJpLyrics.backend.security;

import java.util.Optional;

import org.jspecify.annotations.Nullable;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.stereotype.Component;

@Component
public class DefaultUserDetailsManager implements UserDetailsManager {

	private final DefaultUserRepository defaultUserRepository;

	public DefaultUserDetailsManager(DefaultUserRepository defaultUserRepository) {
		this.defaultUserRepository = defaultUserRepository;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<DefaultUser> pendingUser = Optional.ofNullable(defaultUserRepository.findUserByEmail(username));
		DefaultUser user = pendingUser.orElseThrow(() -> new EmailNotFoundException());

		DefaultUserDetails defaultUserDetails = new DefaultUserDetails(user);

		return defaultUserDetails;
	}

	@Override
	public void createUser(UserDetails user) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateUser(UserDetails user) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteUser(String username) {
		// TODO Auto-generated method stub

	}

	@Override
	public void changePassword(@Nullable String oldPassword, @Nullable String newPassword) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean userExists(String username) {
		// TODO Auto-generated method stub
		return false;
	}

}
