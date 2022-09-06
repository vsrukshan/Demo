package com.example.demo.service;

import com.example.demo.model.Income;
import com.example.demo.repository.IncomeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IncomeService {

    @Autowired
    private IncomeRepository incomeRepository;

    public Income getIncomeById(Integer id) {
        return incomeRepository.findById(Long.valueOf(id)).get();
    }

    public List<Income> getAllIncomes() {
        return incomeRepository.findAll();
    }

    public Income addIncome(Income income) {
//        System.out.println(income.getCategory().getId());
        return incomeRepository.save(income);
    }

    public Income updateIncome(Income income, Integer id) throws Exception {
        Optional<Income> optionalIncome = incomeRepository.findById(Long.valueOf(id));

        if (optionalIncome.isPresent()) {
            income.setId(Long.valueOf(id));
            return incomeRepository.save(income);
        }

        throw new Exception("income not found");
    }

    public void deleteIncome(Integer id) {
        incomeRepository.deleteById(Long.valueOf(id));
    }

}
