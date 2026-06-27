package com.seguroapi.dto;

import jakarta.validation.constraints.*;

public class ApoliceRequestDTO {

    @NotNull(message = "ClienteId é obrigatório")
    @Positive(message = "ClienteId deve ser um ID válido (positivo)")
    private Long clienteId;
    @NotBlank(message = "tipo seguro não pode estar em branco")
    private String tipoSeguro;
    @FutureOrPresent(message = "data inicio não pode ser retroativo")
    @NotNull(message = "data inicio não pode ser nulo")
    private java.time.LocalDateTime dataInicio;
    @NotNull(message = "data vencimento não pode ser nulo")
    private java.time.LocalDateTime dataVencimento;
    @DecimalMin(value = "0.0", message = "valor premio não pode ser negativo")
    @NotNull(message = "valor premio não pode ser nulo")
    private Double valorPremio;
    @DecimalMin(value = "0.0", message = "valor cobertura não pode ser negativo")
    @NotNull(message = "valor cobertura não pode ser nulo")
    private Double valorCobertura;
    @NotBlank(message = "status não pode estar em branco")
    private String status;

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
