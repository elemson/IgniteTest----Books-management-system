package com.bms.dao;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import com.bms.entities.Book;
import com.bms.repositories.BookRepository;

@Service
public class BooksDAO {
	
	@Autowired
	BookRepository bookRepo;
	

	//*to save books
	@PostMapping("/save")
	public Book save(Book b) {
		return bookRepo.save(b);
	}
	
	
	//all
	public List<Book> findAll(){
		return bookRepo.findAll();
	}
	
	//*get an employee
	
	
}