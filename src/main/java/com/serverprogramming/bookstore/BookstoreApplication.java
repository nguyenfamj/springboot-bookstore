package com.serverprogramming.bookstore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.serverprogramming.bookstore.domain.Book;
import com.serverprogramming.bookstore.domain.BookRepository;
import com.serverprogramming.bookstore.domain.Category;
import com.serverprogramming.bookstore.domain.CategoryRepository;
import com.serverprogramming.bookstore.domain.User;
import com.serverprogramming.bookstore.domain.UserRepository;

@SpringBootApplication
public class BookstoreApplication {
	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner bookDemo(BookRepository bookRepository, CategoryRepository categoryRepository,
			UserRepository userRepository) {
		return (args) -> {
			log.info("save new book demo");
			bookRepository.save(new Book("The Intelligent Investor", "Benjamin Graham", 2009, "9780061745171", 50.00));
			bookRepository.save(new Book("Start-up nation", "Dan Senor", 2009, "9780446541473", 20.00));

			log.info("fetch all books");
			for (Book book : bookRepository.findAll()) {
				log.info(book.toString());
			}

			log.info("save new category demo");
			categoryRepository.save(new Category("Science-fiction"));
			categoryRepository.save(new Category("Novel"));
			categoryRepository.save(new Category("Economics"));

			log.info("fetch all category");
			for (Category category : categoryRepository.findAll()) {
				log.info(category.toString());
			}

			userRepository.save(new User("user1", "password1",
					"user1@gmail.com", "USER"));

			userRepository.save(new User("admin1", "passwordadmin1", "admin1@gmail.com", "ADMIN"));
			log.info("fetch all users");
			for (User user : userRepository.findAll()) {
				log.info(user.toString());
			}

		};
	}

}
