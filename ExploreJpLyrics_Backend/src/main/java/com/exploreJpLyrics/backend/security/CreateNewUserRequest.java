package com.exploreJpLyrics.backend.security;

import lombok.Data;

@Data
public class CreateNewUserRequest {

	private final String email;
	private final String password;

	public CreateNewUserRequest(String email, String password) {
		this.email = email;
		this.password = password;
	}

}
