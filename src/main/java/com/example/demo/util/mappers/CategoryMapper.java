package com.example.demo.util.mappers;

import com.example.demo.dto.Category;

public class CategoryMapper {

    public Category toDto(com.example.demo.model.Category entity) {
        Category dto = new Category();
        dto.setId(entity.getId());
        dto.setCategoryName(entity.getCategoryName());
        dto.setDescription(entity.getDescription());

        return dto;
    }

    public com.example.demo.model.Category toEntity(Category dto) {
        com.example.demo.model.Category entity = new com.example.demo.model.Category();
        entity.setId(dto.getId());
        entity.setCategoryName(dto.getCategoryName());
        entity.setDescription(dto.getDescription());

        return entity;
    }
}
