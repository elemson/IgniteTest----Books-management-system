package com.bms.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bms.entities.Book;
import com.bms.repositories.BookRepository;

@Controller
public class BookController {
	@Autowired
	private BookRepository bookRepo;
	
	@SuppressWarnings("deprecation")
	@GetMapping("/")
	public String showPage(Model model, @RequestParam(defaultValue = "0") int page) {
		 model.addAttribute("data", bookRepo.findAll(new PageRequest(page, 4)));
		 model.addAttribute("currentPage", page);
		return "index";
	}
	
	@PostMapping("/save")
	public String save(Book b) {
		this.bookRepo.save(b);
		return "redirect:/";
	}
	
	@GetMapping("/delete")
	public String deleteBook(Book id) {
		bookRepo.delete(id);
		return "redirect:/";
	}
	
	@GetMapping("/findOne")
	@ResponseBody
	public Book findOne(Integer id) {
		return bookRepo.findById(id).orElse(new Book());
	
	}}
	