package com.exercici.books.service;

import java.util.List;

import com.exercici.books.model.ApiResponse;
import com.exercici.books.model.Book;

public interface BookService {

	public ApiResponse<Book> saveBook(Book book);

	public ApiResponse<Book> getOne(int bookId);

	public Book updateOne(int bookId, Book book);

	public Void delete(int bookId);

	public List<Book> getRecommendedBooks();

	public List<Book> getNewInBooks();

	public List<Book> getBestSellers();

	public List<Book> getComics();

	public List<Book> getChildrensStories();

	public List<Book> getOV();

	public List<Book> getAllBooks();

}
