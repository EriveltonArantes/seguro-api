package com.seguroapi.model;

import jakarta.persistence.*;

@Entity
@Table(name = "apolices")
public class Apolice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;
    @Column(nullable = false)
    private String tipoSeguro;
    private java.time.LocalDateTime dataInicio;
    private java.time.LocalDateTime dataVencimento;
    private Double valorPremio;
    private Double valorCobertura;
    @Column(nullable = false)
    private String status;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Cliente getCliente() { return cliente; }
    public void setCliente(Cliente cliente) { this.cliente = cliente; }
    public String getTipoSeguro() { return tipoSeguro; }
    public void setTipoSeguro(String tipoSeguro) { this.tipoSeguro = tipoSeguro; }
    public java.time.LocalDateTime getDataInicio() { return dataInicio; }
    public void setDataInicio(java.time.LocalDateTime dataInicio) { this.dataInicio = dataInicio; }
    public java.time.LocalDateTime getDataVencimento() { return dataVencimento; }
    public void setDataVencimento(java.time.LocalDateTime dataVencimento) { this.dataVencimento = dataVencimento; }
    public Double getValorPremio() { return valorPremio; }
    public void setValorPremio(Double valorPremio) { this.valorPremio = valorPremio; }
    public Double getValorCobertura() { return valorCobertura; }
    public void setValorCobertura(Double valorCobertura) { this.valorCobertura = valorCobertura; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}
