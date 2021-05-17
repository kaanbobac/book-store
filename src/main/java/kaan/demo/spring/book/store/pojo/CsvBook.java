package kaan.demo.spring.book.store.pojo;

import org.springframework.stereotype.Component;

import com.opencsv.bean.CsvBindByPosition;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Component
public class CsvBook {
	 @CsvBindByPosition(position = 0)
	 private String id;

	 @CsvBindByPosition(position = 1)
	 private String amount;
}
