package com.demo.mutlidsh2;

import com.demo.mutlidsh2.usecase.FindMissingNumbers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FindingMissingNumbersApplication implements CommandLineRunner {

    @Autowired
	private FindMissingNumbers findMissingNumbers;

	public static void main(String[] args) {
		SpringApplication.run(FindingMissingNumbersApplication.class, args).close();
	}

	@Override
	public void run(String... strings) throws Exception {
		findMissingNumbers.execute();
	}
}
