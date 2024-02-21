package com.numbers.duplicateNumbers.controller;

import com.numbers.duplicateNumbers.controller.request.NumberRequest;
import com.numbers.duplicateNumbers.model.NumberEntity;
import com.numbers.duplicateNumbers.repo.NumberRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
public class NumberController {
    private NumberRepository numberRepository;

    @PostMapping("/numbers")
    public List<String> addNumbers(@RequestBody NumberRequest numberRequest) {
        List<String> numbersToAdd = numberRequest.getNum();

        List<String> existingNumbers = numberRepository.findAll().stream()
                .map(NumberEntity::getNumber)
                .collect(Collectors.toList());

        List<String> uniqueNewNumbers = numbersToAdd.stream()
                .filter(number -> !existingNumbers.contains(number))
                .collect(Collectors.toList());

        uniqueNewNumbers.forEach(this::saveIfNotExist);
        System.out.println("New Numbers" + uniqueNewNumbers);
        return uniqueNewNumbers;
    }

    private void saveIfNotExist(String number) {
        if (!numberRepository.existsByNumber(number)) {
            NumberEntity numberEntity = new NumberEntity();
            numberEntity.setNumber(number);
            numberRepository.save(numberEntity);
        }
    }
}
