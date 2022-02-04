package com.exercici.books.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.exercici.books.model.Order;
import com.exercici.books.model.User;

@Repository
public interface IOrderRepository extends JpaRepository<Order, Integer> {
	
	Order findByIdAndUser(Integer orderId, User user);
	
	@Transactional
	void deleteByIdAndUser(Integer orderId, User user);
	
	List<Order> findAllByUser(User user);

}
