package com.Spring.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Spring.entity.UserDTLS;

public interface UserRepository extends JpaRepository<UserDTLS, Integer> {

	UserDTLS findByUserName(String userName);

	UserDTLS findByEmail(String email);

	UserDTLS findByEmailAndPassword(String email, String password);

}
