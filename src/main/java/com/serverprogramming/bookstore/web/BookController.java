package com.serverprogramming.bookstore.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.serverprogramming.bookstore.domain.BookRepository;

@Controller
public class BookController {
	@GetMapping("/index")
	public String startIndex() {
		return "index";
	}

	@Autowired
	BookRepository bookRepository;

	@GetMapping("/booklist")
	public String bookList(Model model) {
		model.addAttribute("books", bookRepository.findAll());
		return "booklist";
	}
}
