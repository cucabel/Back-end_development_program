package com.exercici.jwt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.exercici.jwt.model.User;

@Repository
public interface IUsersRepository extends JpaRepository<User, Integer> {

	User findByUserName(String userName);
	
}
