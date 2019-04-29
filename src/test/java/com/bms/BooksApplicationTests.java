package com.bms;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.bms.controllers.BookController;
import com.bms.entities.Book;
import com.bms.repositories.BookRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BooksApplicationTests {
	
	@Autowired
	private BookController bookC;
	
	
	@MockBean
	private BookRepository bookRepository;
	
	@Test
	public void contextLoads() throws Exception {
	
		
		Mockito.when(bookRepository.findAll()).thenReturn(Stream.
				of(new Book("Java 9 for programmers", "Harvey Deitel", "978-0123477566", "0")).collect(Collectors.toList()));		
	}
	
	@Test
	public void saveTest() {
		
		Book book = new Book("Effective Java", "Joshual Bloch", "978-0134685991","2");
		when(bookRepository.save(book)).thenReturn(book);
		assertEquals("redirect:/", bookC.save(book));	
	}
	
	@Test
	public void deleteBook() {
		Book book = new Book("Effective Java", "Joshual Bloch", "978-0134685991","2");
		bookC.deleteBook(book);
		verify(bookRepository, times(1)).delete(book);
		
	}

}
