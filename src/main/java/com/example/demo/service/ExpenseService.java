package com.example.demo.service;

import com.example.demo.model.Expense;
import com.example.demo.repository.ExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExpenseService {

    @Autowired
    private ExpenseRepository expenseRepository;

    public Expense getExpenseById(Integer id) {
        return expenseRepository.findById(Long.valueOf(id)).get();
    }

    public List<Expense> getAllExpenses() {
        return expenseRepository.findAll();
    }

    public Expense addExpense(Expense expense) {
//        System.out.println(expense.getCategory().getId());
        return expenseRepository.save(expense);
    }

    public Expense updateExpense(Expense expense, Integer id) throws Exception {
        Optional<Expense> optionalExpense = expenseRepository.findById(Long.valueOf(id));

        if (optionalExpense.isPresent()) {
            expense.setId(Long.valueOf(id));
            return expenseRepository.save(expense);
        }

        throw new Exception("expense not found");
    }

    public void deleteExpense(Integer id) {
        expenseRepository.deleteById(Long.valueOf(id));
    }
}
