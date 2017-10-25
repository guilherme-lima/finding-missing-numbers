package com.demo.mutlidsh2.usecase;

import com.demo.mutlidsh2.repository.DbArRepository;
import com.demo.mutlidsh2.repository.DbBrRepository;
import com.demo.mutlidsh2.repository.DbMxRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.IntStream;

@Component
public class FindMissingNumbers {

    private DbArRepository dbArRepository;
    private DbBrRepository dbBrRepository;
    private DbMxRepository dbMxRepository;

    @Autowired
    public FindMissingNumbers(DbArRepository dbArRepository, DbBrRepository dbBrRepository, DbMxRepository dbMxRepository) {
        this.dbArRepository = dbArRepository;
        this.dbBrRepository = dbBrRepository;
        this.dbMxRepository = dbMxRepository;
    }

    public void execute() {
        List<String> result = dbArRepository.findAll();
        result.addAll(dbBrRepository.findAll());
        result.addAll(dbMxRepository.findAll());
        result.removeIf(x -> !x.matches("^[0-9]+$"));
        IntStream.range(0, result.size() - 1).forEach(i -> {
            int modifier = 1;
            while (Integer.parseInt(result.get(i)) != Integer.parseInt(result.get(i + 1)) - modifier) {
                System.out.println("Number " + (Integer.parseInt(result.get(i)) + modifier) + " not found in databases.");
                modifier++;
            }
        });
    }

}
