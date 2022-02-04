package com.exercici.books.service.impl;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.exercici.books.model.ApiResponse;
import com.exercici.books.model.Book;
import com.exercici.books.repository.IBookRepository;
import com.exercici.books.service.BookService;

@Service(value = "bookService")
public class BookServiceImpl implements BookService {

	@Autowired
	private IBookRepository bookRepository;
	
	@Override
	public ApiResponse<Book> saveBook(Book book) {

		Book existingBook = bookRepository.findByTitleAndAuthor(book.getTitle(), book.getAuthor());

		if (existingBook != null) {
			return new ApiResponse<>(HttpStatus.FOUND.value(), "The book already exists.", null);
		} else {
			book.setDataRegistration(LocalDate.now());
			book.setOutOfStock(false);
			return new ApiResponse<>(HttpStatus.OK.value(), "Book saved successfully.", bookRepository.save(book));
		}
					
	}

	@Override
	public ApiResponse<Book> getOne(int bookId) {
		
		Optional<Book> optionalBook = bookRepository.findById(bookId);
		
		return optionalBook.isPresent() 
				? new ApiResponse<>(HttpStatus.FOUND.value(), "Book fetched successfully", optionalBook.get()) 
				: new ApiResponse<>(HttpStatus.NOT_FOUND.value(), "The book doesn't exist", null);
	}
	
	@Override
	public Book updateOne(int bookId, Book book) {
		Book bookToUpdate = bookRepository.findById(bookId).get();
		BeanUtils.copyProperties(book, bookToUpdate, "id", "dataRegistration");
		return bookRepository.save(bookToUpdate);
	}

	@Override
	public Void delete(int bookId) {
		// if the book was ordered
		bookRepository.deleteById(bookId);
		return null;
	}
	
	@Override
	public List<Book> getRecommendedBooks() {
		return bookRepository.find12Recommended(true);
	}

	@Override
	public List<Book> getNewInBooks() {
		return bookRepository.findTop12OrderByDataRegistrationAsc();
	}

	@Override
	public List<Book> getBestSellers() {
		return bookRepository.find12BestSellers("BESTSELLER");
	}

	@Override
	public List<Book> getComics() {
		return bookRepository.find12Comics("COMIC");
	}

	@Override
	public List<Book> getChildrensStories() {
		return bookRepository.find12ChildrensStories("CHILDRENSSTORY");
	}

	@Override
	public List<Book> getOV() {
		return bookRepository.find12OV("OV");
	}

	@Override
	public List<Book> getAllBooks() {
		return bookRepository.findAll();
	}

}
