package com.exploreJpLyrics.backend.security;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import jakarta.transaction.Transactional;

public interface DefaultUserRepository extends CrudRepository<DefaultUser, String> {

	@Query(value = "SELECT * FROM default_user WHERE email = :email", nativeQuery = true)
	DefaultUser findUserByEmail(String email);

	@Transactional
	@Modifying
	@Query(value = """
			INSERT INTO default_user
			VALUES (
				:#{#user.getId()},
				:#{#user.getEmail()},
				:#{#user.getPassword()},
				:#{#user.getAuthority()}
			)
			""", nativeQuery = true)
	void createNewUser(@Param("user") DefaultUser user);
}
