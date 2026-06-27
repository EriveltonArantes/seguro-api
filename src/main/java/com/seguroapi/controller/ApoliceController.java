package com.seguroapi.controller;

import com.seguroapi.dto.ApoliceRequestDTO;
import com.seguroapi.dto.ApoliceResponseDTO;
import com.seguroapi.service.ApoliceService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Tag(name = "Apolice", description = "Gerenciamento de apolices")
@RestController
@RequestMapping("/api/apolices")
public class ApoliceController {

    @Autowired
    private ApoliceService service;

    @Operation(summary = "Listar todos os Apolice")
    @GetMapping
    public List<ApoliceResponseDTO> listar(@RequestParam(required = false) String tipoSeguro, @RequestParam(required = false) Long clienteId) {
        List<ApoliceResponseDTO> resultado = service.listar();
        if (tipoSeguro != null && !tipoSeguro.isBlank()) {
            resultado = resultado.stream().filter(item -> item.getTipoSeguro() != null &&
                item.getTipoSeguro().toLowerCase().contains(tipoSeguro.toLowerCase()))
                .collect(java.util.stream.Collectors.toList());
        }
        if (clienteId != null) {
            resultado = resultado.stream().filter(item -> clienteId.equals(item.getClienteId())).collect(java.util.stream.Collectors.toList());
        }
        return resultado;
    }

    @Operation(summary = "Buscar Apolice por ID")
    @GetMapping("/{id}")
    public ApoliceResponseDTO buscar(@PathVariable Long id) { return service.buscar(id); }

    @Operation(summary = "Criar Apolice")
    @PostMapping
    public ResponseEntity<ApoliceResponseDTO> criar(@Valid @RequestBody ApoliceRequestDTO apolice) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.criar(apolice));
    }

    @Operation(summary = "Atualizar Apolice")
    @PutMapping("/{id}")
    public ApoliceResponseDTO atualizar(@PathVariable Long id, @Valid @RequestBody ApoliceRequestDTO apolice) {
        return service.atualizar(id, apolice);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @Operation(summary = "Excluir Apolice")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
