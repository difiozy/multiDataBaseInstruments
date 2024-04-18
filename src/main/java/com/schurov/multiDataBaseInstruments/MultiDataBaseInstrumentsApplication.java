package com.schurov.multiDataBaseInstruments;

import com.schurov.multiDataBaseInstruments.service.TryWriteInSameTransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import static java.lang.Thread.sleep;

@SpringBootApplication
public class MultiDataBaseInstrumentsApplication implements CommandLineRunner {

    @Autowired
    private TryWriteInSameTransactionService service;

    public static void main(String[] args) {
        SpringApplication.run(MultiDataBaseInstrumentsApplication.class, args);
    }

    @Override
    public void run(String... args) throws InterruptedException {
        while (true) {
            service.tryInsertInSameTransaction();
        }
    }
}
