package com.numbers.duplicateNumbers.repo;

import com.numbers.duplicateNumbers.model.NumberEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.math.BigInteger;


public interface NumberRepository extends JpaRepository<NumberEntity,String> {
    boolean existsByNumber(String number);
}
