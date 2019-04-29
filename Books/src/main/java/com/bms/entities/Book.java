package com.bms.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Book {
	
	@Id
	@GeneratedValue
	private Integer id;
	private String title;
	private String author;
	private String isbn;
	private String comment;	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getISBN() {
		return isbn;
	}
	public void setISBN(String isbn) {
		this.isbn = isbn;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public Book(String title, String author, String isbn, String comment) {
		
		this.title = title;
		this.author = author;
		this.isbn = isbn;
		this.comment = comment;
	}
	public Book() {
		
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", Title=" + title + ", Author=" + author + ", isbn=" + isbn + ", Comment=" + comment
				+ "]";
	}
	
	
	
	
}
