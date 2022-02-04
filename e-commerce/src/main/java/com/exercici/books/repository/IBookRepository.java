package com.exercici.books.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.exercici.books.model.Book;

@Repository
public interface IBookRepository extends JpaRepository<Book, Integer> {
	
	Book findByTitleAndAuthor(String title, String author);
	
	@Query(value = "SELECT * FROM book_tbl ORDER BY data_registration DESC LIMIT 12", nativeQuery = true)
	List<Book> findTop12OrderByDataRegistrationAsc();
	
	@Query(value = "SELECT * FROM book_tbl WHERE recommended = ?1 ORDER BY data_registration DESC LIMIT 12", nativeQuery = true)
	List<Book> find12Recommended(Boolean recommended);
	
	@Query(value = "SELECT * FROM book_tbl WHERE category = ?1 ORDER BY data_registration DESC LIMIT 12", nativeQuery = true)
	List<Book> find12BestSellers(String categoryValue);
	
	@Query(value = "SELECT * FROM book_tbl WHERE category = ?1 ORDER BY data_registration DESC LIMIT 12", nativeQuery = true)
	List<Book> find12Comics(String categoryValue);

	@Query(value = "SELECT * FROM book_tbl WHERE category = ?1 ORDER BY data_registration DESC LIMIT 12", nativeQuery = true)
	List<Book> find12ChildrensStories(String categoryValue);
	
	@Query(value = "SELECT * FROM book_tbl WHERE category = ?1 ORDER BY data_registration DESC LIMIT 12", nativeQuery = true)
	List<Book> find12OV(String categoryValue);
	
}



