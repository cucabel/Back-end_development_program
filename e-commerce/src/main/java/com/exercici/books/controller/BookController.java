package com.exercici.books.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exercici.books.model.ApiResponse;
import com.exercici.books.model.Book;
import com.exercici.books.service.BookService;

@CrossOrigin
@RestController
@RequestMapping("/books")
public class BookController {

	@Autowired
	private BookService bookService;

	@PostMapping
	public ApiResponse<Book> saveBook(@RequestBody Book book) {
		return bookService.saveBook(book);
	}

	@GetMapping("/{bookId}")
	public ApiResponse<Book> getOne(@PathVariable int bookId) {
		return bookService.getOne(bookId);
	}
	
	@PutMapping("/{bookId}")
	public ApiResponse<Book> updateOne(@PathVariable int bookId, @RequestBody Book book) {
		return new ApiResponse<>(HttpStatus.OK.value(), "Book updated successfully.", bookService.updateOne(bookId, book));
	}
	
	@DeleteMapping("/{bookId}")
	public ApiResponse<Void> delete(@PathVariable int bookId) {
		return new ApiResponse<>(HttpStatus.NOT_FOUND.value(), "Book deleted successfully.", bookService.delete(bookId));
	}
	
	@GetMapping("/recommended")
	public ApiResponse<List<Book>> getRecommendedBooks() {
		return new ApiResponse<>(HttpStatus.OK.value(), "Recommended books fetched successfully.",
				bookService.getRecommendedBooks());
	}

	@GetMapping("/newin")
	public ApiResponse<List<Book>> getNewInBooks() {
		return new ApiResponse<>(HttpStatus.OK.value(), "New in books fetched successfully.", bookService.getNewInBooks());
	}

	@GetMapping("/bestsellers")
	public ApiResponse<List<Book>> getBestSellers() {
		return new ApiResponse<>(HttpStatus.OK.value(), "Best Sellers fetched successfully.", bookService.getBestSellers());
	}

	@GetMapping("/comics")
	public ApiResponse<List<Book>> getComics() {
		return new ApiResponse<>(HttpStatus.OK.value(), "Comics fetched successfully.", bookService.getComics());
	}

	@GetMapping("/childrensStories")
	public ApiResponse<List<Book>> getChildrensStories() {
		return new ApiResponse<>(HttpStatus.OK.value(), "Children Stories fetched successfully.",
				bookService.getChildrensStories());
	}

	@GetMapping("/ov")
	public ApiResponse<List<Book>> getOV() {
		return new ApiResponse<>(HttpStatus.OK.value(), "OV fetched successfully.", bookService.getOV());
	}
	
	@GetMapping
	public ApiResponse<List<Book>> getAllBooks() {
		return new ApiResponse<>(HttpStatus.OK.value(), "Books fetched successfully.", bookService.getAllBooks());
	}

}
