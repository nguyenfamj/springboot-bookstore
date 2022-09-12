package com.serverprogramming.bookstore.domain;

public class Book {

	private String title;
	private String author;
	private int year;
	private String isbn;
	private double price;

	public Book(String title, String author, int year, String isbn, double price) {
		this.title = title;
		this.author = author;
		this.year = year;
		this.isbn = isbn;
		this.price = price;
	}

	@Override
	public String toString() {
		return "Book: " + this.title + ", " + this.author + ", " + this.year + ", " + this.isbn + ", " + this.price;
	}

}
