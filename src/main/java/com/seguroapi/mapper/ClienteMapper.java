package com.seguroapi.mapper;

import com.seguroapi.dto.ClienteRequestDTO;
import com.seguroapi.dto.ClienteResponseDTO;
import com.seguroapi.model.Cliente;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ClienteMapper {

    Cliente toEntity(ClienteRequestDTO dto);

    ClienteResponseDTO toResponseDTO(Cliente entity);
}
