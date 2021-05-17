package kaan.demo.spring.book.store.service;

import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import kaan.demo.spring.book.store.dao.CsvBookDao;
import kaan.demo.spring.book.store.pojo.CsvBook;

@Service
public class CsvLoader {
	@Autowired
	private CsvBookDao dao;
	@Value("${kaan.demo.spring.book.store.csv.path}")
	private String path;
	public List<CsvBook> readCsv() throws Exception {
		List<CsvBook> books = new ArrayList<CsvBook>();
	     ColumnPositionMappingStrategy<CsvBook> ms = new ColumnPositionMappingStrategy<CsvBook>();
	     Reader reader = Files.newBufferedReader(Paths.get(path));
	     ms.setType(CsvBook.class);
	     CsvToBean<CsvBook> cb = new CsvToBeanBuilder<CsvBook>(reader)
	       .withType(CsvBook.class)
	       .withMappingStrategy(ms)
	       .build();
	    Iterator<CsvBook> csvUserIterator = cb.iterator();
	    csvUserIterator.forEachRemaining(books::add);
	    reader.close();
	    return books;
	}
	@EventListener(ApplicationReadyEvent.class)
	public void loadCsv() {
		try {
			dao.setCsvBooks(readCsv());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public List<CsvBook> queryAll(){
		return dao.getCsvBooks();
	}
}
