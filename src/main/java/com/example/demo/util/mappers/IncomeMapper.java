package com.example.demo.util.mappers;

import com.example.demo.dto.Income;

public class IncomeMapper {
    private final CategoryMapper categoryMapper = new CategoryMapper();
    private final MethodMapper methodMapper = new MethodMapper();

    public Income toDto(com.example.demo.model.Income entity) {
        Income dto = new Income();

        dto.setId(entity.getId());
        dto.setAmount(entity.getAmount());
        dto.setNote(entity.getNote());
        dto.setDate(entity.getDate());
        dto.setCategory(this.categoryMapper.toDto(entity.getCategory()));
        dto.setMethod(this.methodMapper.toDto(entity.getMethod()));

        return dto;
    }

    public com.example.demo.model.Income toEntity(Income dto) {
        com.example.demo.model.Income entity = new com.example.demo.model.Income();

        entity.setId(dto.getId());
        entity.setAmount(dto.getAmount());
        entity.setNote(dto.getNote());
        entity.setDate(dto.getDate());
        entity.setCategory(this.categoryMapper.toEntity(dto.getCategory()));
        entity.setMethod(this.methodMapper.toEntity(dto.getMethod()));

        return entity;
    }
}
