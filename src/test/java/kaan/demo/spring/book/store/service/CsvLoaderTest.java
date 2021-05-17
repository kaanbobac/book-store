package kaan.demo.spring.book.store.service;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Profile;

import kaan.demo.spring.book.store.pojo.CsvBook;
@SpringBootTest
@Profile("test")
public class CsvLoaderTest {

	@Autowired
	private CsvLoader csvLoader;
	private List<CsvBook> expected = new ArrayList<CsvBook>();
	@BeforeEach
	void init() {
		CsvBook book1 = CsvBook.builder().id("18").amount("6,000").build();
		CsvBook book2 = CsvBook.builder().id("26").amount("1,000").build(); 
		CsvBook book3 = CsvBook.builder().id("39").amount("18,000").build(); 
		expected.add(book1);
		expected.add(book2);
		expected.add(book3);
	}
	@Test
	void parse_csv_success() {
		List<CsvBook> actual = null;
		try {
			actual = csvLoader.readCsv();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertThat(actual,is(expected));
			
	}
}
