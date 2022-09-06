package com.example.demo.util.mappers;

import com.example.demo.dto.Expense;

public class ExpenseMapper {

    private final CategoryMapper categoryMapper = new CategoryMapper();
    private final MethodMapper methodMapper = new MethodMapper();

    public Expense toDto(com.example.demo.model.Expense entity) {
        Expense dto = new Expense();
        dto.setId(entity.getId());
        dto.setAmount(entity.getAmount());
        dto.setNote(entity.getNote());
        dto.setDate(entity.getDate());

        dto.setCategory(this.categoryMapper.toDto(entity.getCategory()));
        dto.setMethod(this.methodMapper.toDto(entity.getMethod()));

        return dto;
    }

    public com.example.demo.model.Expense toEntity(Expense dto) {
        com.example.demo.model.Expense entity = new com.example.demo.model.Expense();
        entity.setId(dto.getId());
        entity.setAmount(dto.getAmount());
        entity.setNote(dto.getNote());
        entity.setDate(dto.getDate());

        entity.setCategory(this.categoryMapper.toEntity(dto.getCategory()));
        entity.setMethod(this.methodMapper.toEntity(dto.getMethod()));

        return entity;
    }
}
