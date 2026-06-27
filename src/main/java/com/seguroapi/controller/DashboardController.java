package com.seguroapi.controller;

import com.seguroapi.model.Cliente;
import com.seguroapi.model.Apolice;
import com.seguroapi.model.Sinistro;
import com.seguroapi.model.Pagamento;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;
import java.util.Map;

@Tag(name = "Dashboard", description = "KPIs e totais do sistema")
@RestController
@RequestMapping("/api/dashboard")
public class DashboardController {

    @Autowired
    private com.seguroapi.repository.ClienteRepository clienteRepository;

    @Autowired
    private com.seguroapi.repository.ApoliceRepository apoliceRepository;

    @Autowired
    private com.seguroapi.repository.SinistroRepository sinistroRepository;

    @Autowired
    private com.seguroapi.repository.PagamentoRepository pagamentoRepository;

    @Operation(summary = "Resumo com totais, somas e gráficos de status")
    @Transactional(readOnly = true)
    @GetMapping("/resumo")
    public Map<String, Object> resumo() {
        Map<String, Object> resumo = new LinkedHashMap<>();
        resumo.put("totalCliente", clienteRepository.count());
        resumo.put("totalApolice", apoliceRepository.count());
        resumo.put("somaValorPremioApolice", apoliceRepository.findAll().stream().filter(e -> e.getValorPremio() != null).mapToDouble(e -> e.getValorPremio()).sum());
        resumo.put("graficoApolice", apoliceRepository.findAll().stream()
            .collect(java.util.stream.Collectors.groupingBy(
                item -> String.valueOf(item.getStatus()),
                java.util.LinkedHashMap::new,
                java.util.stream.Collectors.counting())));
        resumo.put("totalSinistro", sinistroRepository.count());
        resumo.put("somaValorEstimadoSinistro", sinistroRepository.findAll().stream().filter(e -> e.getValorEstimado() != null).mapToDouble(e -> e.getValorEstimado()).sum());
        resumo.put("graficoSinistro", sinistroRepository.findAll().stream()
            .collect(java.util.stream.Collectors.groupingBy(
                item -> String.valueOf(item.getStatus()),
                java.util.LinkedHashMap::new,
                java.util.stream.Collectors.counting())));
        resumo.put("totalPagamento", pagamentoRepository.count());
        resumo.put("somaValorPagoPagamento", pagamentoRepository.findAll().stream().filter(e -> e.getValorPago() != null).mapToDouble(e -> e.getValorPago()).sum());
        resumo.put("graficoPagamento", pagamentoRepository.findAll().stream()
            .collect(java.util.stream.Collectors.groupingBy(
                item -> String.valueOf(item.getStatus()),
                java.util.LinkedHashMap::new,
                java.util.stream.Collectors.counting())));
        return resumo;
    }
}
