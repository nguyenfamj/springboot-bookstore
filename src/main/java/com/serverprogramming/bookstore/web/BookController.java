package com.serverprogramming.bookstore.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.ResponseBody;

import com.serverprogramming.bookstore.domain.Book;
import com.serverprogramming.bookstore.domain.BookRepository;
import com.serverprogramming.bookstore.domain.CategoryRepository;

@Controller
public class BookController {
	@GetMapping("/index")
	public String startIndex() {
		return "index";
	}

	@Autowired
	BookRepository bookRepository;

	@Autowired
	CategoryRepository categoryRepository;

	@GetMapping("/booklist")
	public String bookList(Model model) {
		model.addAttribute("book", new Book());
		model.addAttribute("books", bookRepository.findAll());
		return "booklist";
	}

	@GetMapping("/books")
	public @ResponseBody List<Book> bookListRest() {
		return (List<Book>) bookRepository.findAll();
	}

	@GetMapping(value = "/book/{id}")
	public @ResponseBody Optional<Book> bookIdRest(@PathVariable("id") Long bookId) {
		return bookRepository.findById(bookId);
	}

	@GetMapping("/addbook")
	public String addBook(Model model) {
		model.addAttribute("book", new Book());
		model.addAttribute("categories", categoryRepository.findAll());
		return "addbook";
	}

	@PostMapping("/savebook")
	public String saveBook(Book book) {
		System.out.println(book.getId());

		bookRepository.save(book);

		return "redirect:booklist";
	}

	@GetMapping("/deletebook/{id}")
	@PreAuthorize("hasRole('ADMIN')")
	public String deleteBook(@PathVariable("id") Long bookId, Model model) {
		bookRepository.deleteById(bookId);
		return "redirect:../booklist";
	}

	@GetMapping("/editbook/{id}")
	public String editBook(@PathVariable("id") Long bookId, Model model) {
		model.addAttribute("book", bookRepository.findById(bookId));
		model.addAttribute("categories", categoryRepository.findAll());
		return "editbook";
	}

}
