package com.seguroapi.mapper;

import com.seguroapi.dto.SinistroRequestDTO;
import com.seguroapi.dto.SinistroResponseDTO;
import com.seguroapi.model.Sinistro;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface SinistroMapper {

    @Mapping(target = "apolice", ignore = true)
    Sinistro toEntity(SinistroRequestDTO dto);

    @Mapping(target = "apoliceId", source = "apolice.id")
    SinistroResponseDTO toResponseDTO(Sinistro entity);
}
