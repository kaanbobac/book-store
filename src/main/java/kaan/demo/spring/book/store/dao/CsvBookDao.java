package kaan.demo.spring.book.store.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import kaan.demo.spring.book.store.pojo.CsvBook;
import lombok.Data;
@Data
@Repository
public class CsvBookDao {
	public List<CsvBook> csvBooks;
}
