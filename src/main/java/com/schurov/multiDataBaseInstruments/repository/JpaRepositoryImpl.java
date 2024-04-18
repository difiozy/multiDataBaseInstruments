package com.schurov.multiDataBaseInstruments.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaRepositoryImpl extends JpaRepository<TestEntity, Long> {

}
