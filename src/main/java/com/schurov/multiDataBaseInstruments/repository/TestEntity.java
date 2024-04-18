package com.schurov.multiDataBaseInstruments.repository;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.experimental.Accessors;

import static jakarta.persistence.GenerationType.SEQUENCE;

@Entity
@Data
@Accessors(fluent = true)
public class TestEntity {
    @Id
    @GeneratedValue(strategy = SEQUENCE)
    private Long id;

    private String value;
}
