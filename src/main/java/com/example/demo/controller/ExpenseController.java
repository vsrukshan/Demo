package com.example.demo.controller;

import com.example.demo.api.ExpensesApi;
import com.example.demo.dto.Expense;
import com.example.demo.service.ExpenseService;
import com.example.demo.util.mappers.ExpenseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/demo")
public class ExpenseController implements ExpensesApi {

    @Autowired
    private ExpenseService expenseService;

    @Override
    public ResponseEntity<Expense> addExpense(Expense expense) {
        ExpenseMapper mapper = new ExpenseMapper();
        return ResponseEntity.ok(mapper.toDto(expenseService.addExpense(mapper.toEntity(expense))));
    }

    @Override
    public ResponseEntity<Void> deleteExpense(Integer expenseId) {
        expenseService.deleteExpense(expenseId);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @Override
    public ResponseEntity<List<Expense>> getAllExpenses() {
        List<Expense> expenseList = new ArrayList<>();
        ExpenseMapper mapper = new ExpenseMapper();

        for (com.example.demo.model.Expense expense : expenseService.getAllExpenses()) {
            expenseList.add(mapper.toDto(expense));
        }

        return ResponseEntity.ok(expenseList);
    }

    @Override
    public ResponseEntity<Expense> getExpenseById(Integer expenseId) {
        ExpenseMapper mapper = new ExpenseMapper();
        Expense expense = mapper.toDto(expenseService.getExpenseById(expenseId));
        return ResponseEntity.ok(expense);
    }

    @Override
    public ResponseEntity<Void> updateExpense(Integer expenseId, Expense expense) {
        ExpenseMapper mapper = new ExpenseMapper();

        try {
            mapper.toDto(expenseService.updateExpense(mapper.toEntity(expense), expenseId));

        } catch (Exception e) {
            System.out.println("not found");
            return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Void>(HttpStatus.ACCEPTED);

    }
}
