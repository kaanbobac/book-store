package kaan.demo.spring.book.store.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import kaan.demo.spring.book.store.pojo.CsvBook;
import kaan.demo.spring.book.store.service.CsvLoader;

@RestController
public class BookController {
	@Autowired
	private CsvLoader csvLoader;
	@GetMapping("/")
	private ResponseEntity<List<CsvBook>> queryAllBooks() {
		return new ResponseEntity<List<CsvBook>>(csvLoader.queryAll(),HttpStatus.OK);
	}
}
