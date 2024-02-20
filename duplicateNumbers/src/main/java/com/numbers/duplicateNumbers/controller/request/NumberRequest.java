package com.numbers.duplicateNumbers.controller.request;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.util.List;

@Data
public class NumberRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private List<String> num;
}
