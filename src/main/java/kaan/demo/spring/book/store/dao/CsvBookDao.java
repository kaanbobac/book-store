package kaan.demo.spring.book.store.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import lombok.Data;
@Data
@Repository
public class CsvBookDao {
	public List<Book> csvBooks;
}
