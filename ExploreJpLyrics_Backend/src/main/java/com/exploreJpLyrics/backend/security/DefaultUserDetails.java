package com.exploreJpLyrics.backend.security;

import java.util.Collection;
import java.util.List;

import org.jspecify.annotations.Nullable;
import org.springframework.security.core.CredentialsContainer;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@SuppressWarnings("serial")
public class DefaultUserDetails implements UserDetails, CredentialsContainer {

	private final String username;
	private String password;
	private final GrantedAuthority grantedAuthority;

	public DefaultUserDetails(DefaultUser user) {
		this.username = user.getEmail();
		this.password = user.getPassword();
		this.grantedAuthority = () -> user.getAuthority();
	}

	@Override
	public void eraseCredentials() {
		this.password = null;

	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return List.of(grantedAuthority);
	}

	@Override
	public @Nullable String getPassword() {
		return this.password;
	}

	@Override
	public String getUsername() {
		return this.username;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}
}