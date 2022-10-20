package com.example.demo.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Book;

@RestController
public class BooksController {
	@GetMapping("/books")
		public List<Book> getAllBooks() {
			return Arrays.asList(new Book(1, "Mastering Spring 4.2", "Aditya Pranav"));
		}
	}


