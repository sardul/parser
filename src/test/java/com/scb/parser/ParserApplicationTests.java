package com.scb.parser;

import com.scb.parser.service.FileReader;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ParserApplicationTests {

	@Test
	void contextLoads() {
	}

	@Autowired
	private FileReader fileReader;

	@Test
	void testFIleReader() {
		fileReader.fileReader("//Users//shardul.singh//Downloads//parser//src//main//java//com//scb//parser//file//demo.txt");
	}


}
