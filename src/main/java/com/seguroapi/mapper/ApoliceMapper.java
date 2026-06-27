package com.seguroapi.mapper;

import com.seguroapi.dto.ApoliceRequestDTO;
import com.seguroapi.dto.ApoliceResponseDTO;
import com.seguroapi.model.Apolice;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ApoliceMapper {

    @Mapping(target = "cliente", ignore = true)
    Apolice toEntity(ApoliceRequestDTO dto);

    @Mapping(target = "clienteId", source = "cliente.id")
    ApoliceResponseDTO toResponseDTO(Apolice entity);
}
