package com.seguroapi.mapper;

import com.seguroapi.dto.PagamentoRequestDTO;
import com.seguroapi.dto.PagamentoResponseDTO;
import com.seguroapi.model.Pagamento;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PagamentoMapper {

    @Mapping(target = "apolice", ignore = true)
    Pagamento toEntity(PagamentoRequestDTO dto);

    @Mapping(target = "apoliceId", source = "apolice.id")
    PagamentoResponseDTO toResponseDTO(Pagamento entity);
}
