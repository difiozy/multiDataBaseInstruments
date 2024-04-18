package com.schurov.multiDataBaseInstruments.service;

import com.schurov.multiDataBaseInstruments.repository.JpaRepositoryImpl;
import com.schurov.multiDataBaseInstruments.repository.MyBatisRepository;
import com.schurov.multiDataBaseInstruments.repository.TestEntity;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.springframework.stereotype.Service;

import static java.lang.String.valueOf;

@Service
@RequiredArgsConstructor
@Slf4j
public class TryWriteInSameTransactionService {
    private static int valCounter = 100;

    private final JpaRepositoryImpl jpaRepository;
    private final MyBatisRepository myBatisRepository;

    private final EntityManager entityManager;


    @Transactional
    public void tryInsertInSameTransaction() {
        TestEntity jpaSaved = jpaRepository.save(new TestEntity().value(valueOf(valCounter++)));
        //Need flush before find, because hibernate 1-st lvl cache is enable
        //my batis not a jpa and don't use caches
        Session unwrap = entityManager.unwrap(Session.class);
        unwrap.flush();

        TestEntity batis = myBatisRepository.findById(jpaSaved.id());

        log.info(String.valueOf(jpaSaved));
        log.info(String.valueOf(batis));

        //Summary:
        //Choose one of frameworks
    }

}
