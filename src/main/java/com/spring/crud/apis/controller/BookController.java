package com.spring.crud.apis.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.spring.crud.apis.entity.Book;
import com.spring.crud.apis.services.BookService;

@RestController
@RequestMapping("/book/managament")
public class BookController {
	
	@Autowired
	private BookService bookService;
	
	// Get all books handler
	@GetMapping("/all")
	public List<Book> getBooks() {
		return this.bookService.getAllBooks();

	}
	// Get single books handler
	@GetMapping("/all/{id}")
	public Book getBook(@PathVariable("id") int id) {
		return bookService.getBookByID(id);
	}
	// add book handler
	@PostMapping("/add/book")
	public Book addBook(@RequestBody Book book) {
		Book b = bookService.addBook(book);
		return b;
	}
	
	//delete book handler
	@DeleteMapping("/delete/book/{id}")
	public String deleteBook(@PathVariable("id") int id) {
		bookService.deleteBook(id);
		return "Book Deleted";
	}
	
	//update book handler
	@PutMapping("/update/book/{id}")
	public Book updateBook(@PathVariable("id") int id, @RequestBody Book book) {
		bookService.updateBook(id, book);
		return book;
	}
	
	

}
