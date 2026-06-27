package com.seguroapi.service;

import com.seguroapi.dto.PagamentoRequestDTO;
import com.seguroapi.dto.PagamentoResponseDTO;
import com.seguroapi.exception.ResourceNotFoundException;
import com.seguroapi.mapper.PagamentoMapper;
import com.seguroapi.model.Pagamento;
import com.seguroapi.repository.PagamentoRepository;
import com.seguroapi.repository.ApoliceRepository;
import com.seguroapi.model.Apolice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class PagamentoService {

    @Autowired
    private PagamentoRepository repository;

    @Autowired
    private PagamentoMapper mapper;

    @Autowired
    private ApoliceRepository apoliceRepository;

    @Transactional(readOnly = true)
    public List<PagamentoResponseDTO> listar() {
        return repository.findAll().stream().map(mapper::toResponseDTO).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public PagamentoResponseDTO buscar(Long id) {
        Pagamento entity = repository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Pagamento não encontrado com id: " + id));
        return mapper.toResponseDTO(entity);
    }

    public PagamentoResponseDTO criar(PagamentoRequestDTO dto) {
        Pagamento entity = mapper.toEntity(dto);
        Apolice apolice = apoliceRepository.findById(dto.getApoliceId())
            .orElseThrow(() -> new ResourceNotFoundException("Apolice não encontrado com id: " + dto.getApoliceId()));
        entity.setApolice(apolice);
        Pagamento salvo = repository.save(entity);
        return mapper.toResponseDTO(salvo);
    }

    public PagamentoResponseDTO atualizar(Long id, PagamentoRequestDTO dto) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Pagamento não encontrado com id: " + id);
        }
        Pagamento entity = mapper.toEntity(dto);
        entity.setId(id);
        Apolice apolice = apoliceRepository.findById(dto.getApoliceId())
            .orElseThrow(() -> new ResourceNotFoundException("Apolice não encontrado com id: " + dto.getApoliceId()));
        entity.setApolice(apolice);
        Pagamento salvo = repository.save(entity);
        return mapper.toResponseDTO(salvo);
    }

    public void deletar(Long id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Pagamento não encontrado com id: " + id);
        }
        repository.deleteById(id);
    }
}
