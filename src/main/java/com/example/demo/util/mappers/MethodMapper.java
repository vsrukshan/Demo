package com.example.demo.util.mappers;

import com.example.demo.dto.Method;

public class MethodMapper {

    public Method toDto(com.example.demo.model.Method entity) {
        Method dto = new Method();
        dto.setId(entity.getId());
        dto.setMethodName(entity.getMethodName());
        dto.setDescription(entity.getDescription());

        return dto;
    }

    public com.example.demo.model.Method toEntity(Method dto) {
        com.example.demo.model.Method entity = new com.example.demo.model.Method();
        entity.setId(dto.getId());
        entity.setMethodName(dto.getMethodName());
        entity.setDescription(dto.getDescription());

        return entity;
    }
}
