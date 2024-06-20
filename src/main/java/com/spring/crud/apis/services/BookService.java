package com.spring.crud.apis.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.spring.crud.apis.entity.Book;


@Component
public class BookService {
	
	private static List<Book> list = new ArrayList<Book>();
	
	static {
		list.add(new Book(101,"Book1", "Author1"));
		list.add(new Book(102,"Book2", "Author2"));
		list.add(new Book(103,"Book3", "Author3"));
		list.add(new Book(104,"Book4", "Author4"));
	}
	
	public List<Book> getAllBooks(){
		return list;
	}
	
	public Book getBookByID(int id) {
		Book book = list.stream().filter(e->e.getId()==id).findFirst().get();
		return book;
	}
	
	public Book addBook(Book b) {
		list.add(b);
		return b;
	}
	
	public void deleteBook(int id) {
		list = list.stream().filter(book->{
			if(book.getId()!=id) {
				return true;
			}
			else {
				return false;
			}
		}).collect(Collectors.toList());
		
		System.out.println("Book deleted");
	}
	
	public void updateBook(int id, Book book) {
		
		list = list.stream().map(b->{
			if(b.getId()==id) {
				b.setTitle(book.getTitle());
				b.setAuthor(book.getAuthor());
			}
		return book;
		}).collect(Collectors.toList());
//		Book b = list.stream().filter(e -> e.getId()==id).findFirst().get();
//		b.setTitle(book.getTitle());
//		b.setAuthor(book.getAuthor());
//		return b;
	}

}
