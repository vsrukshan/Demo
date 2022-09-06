package com.example.demo.controller;


import com.example.demo.api.IncomesApi;
import com.example.demo.dto.Income;
import com.example.demo.service.IncomeService;
import com.example.demo.util.mappers.IncomeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.NativeWebRequest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/demo")
public class IncomeController implements IncomesApi {

    @Autowired
    private IncomeService incomeService;

    @Override
    public Optional<NativeWebRequest> getRequest() {
        return IncomesApi.super.getRequest();
    }

    @Override
    public ResponseEntity<Income> addIncome(Income income) {
        IncomeMapper mapper = new IncomeMapper();
        return ResponseEntity.ok(mapper.toDto(incomeService.addIncome(mapper.toEntity(income))));
    }

    @Override
    public ResponseEntity<Void> deleteIncome(Integer incomeId) {
        incomeService.deleteIncome(incomeId);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @Override
    public ResponseEntity<List<Income>> getAllIncomes() {
        List<Income> incomeList = new ArrayList<>();
        IncomeMapper mapper = new IncomeMapper();

        for (com.example.demo.model.Income income : incomeService.getAllIncomes()) {
            incomeList.add(mapper.toDto(income));
        }

        return ResponseEntity.ok(incomeList);
    }

    @Override
    public ResponseEntity<Income> getIncomeById(Integer incomeId) {
        IncomeMapper mapper = new IncomeMapper();
        Income income = mapper.toDto(incomeService.getIncomeById(incomeId));
        return ResponseEntity.ok(income);
    }

    @Override
    public ResponseEntity<Void> updateIncome(Integer incomeId, Income income) {
        IncomeMapper mapper = new IncomeMapper();

        try {
            mapper.toDto(incomeService.updateIncome(mapper.toEntity(income), incomeId));

        } catch (Exception e) {
            System.out.println("not found");
            return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Void>(HttpStatus.ACCEPTED);

    }
}
