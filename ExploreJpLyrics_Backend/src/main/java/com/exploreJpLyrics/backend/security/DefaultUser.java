package com.exploreJpLyrics.backend.security;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class DefaultUser {

	@Id
	@Column(name = "user_id")
	private String id;

	private String email;

	@Column(name = "user_password")
	private String password;

	private String authority;

}