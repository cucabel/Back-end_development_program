package com.exercici.books.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.exercici.books.model.User;

@Repository
public interface IUserRepository extends JpaRepository<User, Integer> {
	
	User findByNickName(String nickName);

	User findByUserName(String userName);
	
}
