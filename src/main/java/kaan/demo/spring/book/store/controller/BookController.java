package kaan.demo.spring.book.store.controller;

import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kaan.demo.spring.book.store.dao.Book;
import kaan.demo.spring.book.store.service.CsvLoader;

@Controller
public class BookController {
	private boolean amountFlag = true;
	private boolean idFlag = true;
	@Autowired
	private CsvLoader csvLoader;
	@RequestMapping("/")
	private String  queryAllBooks(Model model) {
		 model.addAttribute("books", csvLoader.queryAll());
		 model.addAttribute("byAmount", Comparator.comparing(Book::getAmount));
		 return "books";
	}
	@RequestMapping("/sortbyAmount")
	private String  sortBooksByAmount(Model model) {
		List<Book> books = csvLoader.queryAll();
		if(amountFlag) {
			books.sort(Comparator.comparing(Book::getAmount));
			amountFlag = false;
		}
			
		else {
			books.sort(Comparator.comparing(Book::getAmount).reversed());
			amountFlag = true;
		}
		 model.addAttribute("books", books);
		 return "books";
	}
	@RequestMapping("/sortbyId")
	private String  sortBooksById(Model model) {
		List<Book> books = csvLoader.queryAll();
		if(idFlag) {
			books.sort(Comparator.comparing(Book::getId));
			idFlag = false;
		}
			
		else {
			books.sort(Comparator.comparing(Book::getId).reversed());
			idFlag = true;
		}
		 model.addAttribute("books", books);
		 return "books";
	}
}
 