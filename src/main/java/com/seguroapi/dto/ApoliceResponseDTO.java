package com.seguroapi.dto;

public class ApoliceResponseDTO {

    private Long id;
    private Long clienteId;
    private String tipoSeguro;
    private java.time.LocalDateTime dataInicio;
    private java.time.LocalDateTime dataVencimento;
    private Double valorPremio;
    private Double valorCobertura;
    private String status;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Long getClienteId() { return clienteId; }
    public void setClienteId(Long clienteId) { this.clienteId = clienteId; }
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
