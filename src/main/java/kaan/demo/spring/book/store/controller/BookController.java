package kaan.demo.spring.book.store.controller;

import java.util.Comparator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kaan.demo.spring.book.store.dao.Book;
import kaan.demo.spring.book.store.service.CsvLoader;

@Controller
public class BookController {
	@Autowired
	private CsvLoader csvLoader;
	@RequestMapping("/")
	private String  queryAllBooks(Model model) {
		 model.addAttribute("books", csvLoader.queryAll());
		 model.addAttribute("byAmount", Comparator.comparing(Book::getAmount));
		 return "books";
	}
}
 