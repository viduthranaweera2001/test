package com.numbers.duplicateNumbers.repo;

import com.numbers.duplicateNumbers.model.NumberEntity;
import org.springframework.data.jpa.repository.JpaRepository;
public interface NumberRepository extends JpaRepository<NumberEntity,String> {
    boolean existsByNumber(String number);
}
