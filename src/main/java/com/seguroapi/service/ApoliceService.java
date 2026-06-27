package com.seguroapi.service;

import com.seguroapi.dto.ApoliceRequestDTO;
import com.seguroapi.dto.ApoliceResponseDTO;
import com.seguroapi.exception.ResourceNotFoundException;
import com.seguroapi.mapper.ApoliceMapper;
import com.seguroapi.model.Apolice;
import com.seguroapi.repository.ApoliceRepository;
import com.seguroapi.repository.ClienteRepository;
import com.seguroapi.model.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class ApoliceService {

    @Autowired
    private ApoliceRepository repository;

    @Autowired
    private ApoliceMapper mapper;

    @Autowired
    private ClienteRepository clienteRepository;

    @Transactional(readOnly = true)
    public List<ApoliceResponseDTO> listar() {
        return repository.findAll().stream().map(mapper::toResponseDTO).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public ApoliceResponseDTO buscar(Long id) {
        Apolice entity = repository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Apolice não encontrado com id: " + id));
        return mapper.toResponseDTO(entity);
    }

    public ApoliceResponseDTO criar(ApoliceRequestDTO dto) {
        Apolice entity = mapper.toEntity(dto);
        Cliente cliente = clienteRepository.findById(dto.getClienteId())
            .orElseThrow(() -> new ResourceNotFoundException("Cliente não encontrado com id: " + dto.getClienteId()));
        entity.setCliente(cliente);
        Apolice salvo = repository.save(entity);
        return mapper.toResponseDTO(salvo);
    }

    public ApoliceResponseDTO atualizar(Long id, ApoliceRequestDTO dto) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Apolice não encontrado com id: " + id);
        }
        Apolice entity = mapper.toEntity(dto);
        entity.setId(id);
        Cliente cliente = clienteRepository.findById(dto.getClienteId())
            .orElseThrow(() -> new ResourceNotFoundException("Cliente não encontrado com id: " + dto.getClienteId()));
        entity.setCliente(cliente);
        Apolice salvo = repository.save(entity);
        return mapper.toResponseDTO(salvo);
    }

    public void deletar(Long id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Apolice não encontrado com id: " + id);
        }
        repository.deleteById(id);
    }
}
