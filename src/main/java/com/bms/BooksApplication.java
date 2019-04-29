package com.bms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.bms.entities.Book;
import com.bms.repositories.BookRepository;


@SpringBootApplication
public class BooksApplication implements CommandLineRunner {
	
	@Autowired
	private BookRepository bookRepository;

	public static void main(String[] args) {
		SpringApplication.run(BooksApplication.class, args);
	}
	

	public void run (String... args) throws Exception {
		
		bookRepository.save(new Book("Effective Java", "Joshual Bloch", "978-0134685991", "2"));
		bookRepository.save(new Book("Java 9 for programmers", "Harvey Deitel", "978-0123477566", "0"));
		bookRepository.save(new Book("Java SE 9", "Cay S. Horstmann", "978-01346994726", "12"));
		bookRepository.save(new Book("Core Java SE 9", "Cay S Horstmann", "978-01346994726", "65"));
		
		
	}
	
	
	

}
