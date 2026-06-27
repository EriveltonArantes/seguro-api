package com.seguroapi.dto;

import jakarta.validation.constraints.*;

public class SinistroRequestDTO {

    @NotNull(message = "ApoliceId é obrigatório")
    @Positive(message = "ApoliceId deve ser um ID válido (positivo)")
    private Long apoliceId;
    @NotNull(message = "data ocorrencia não pode ser nulo")
    private java.time.LocalDateTime dataOcorrencia;
    @NotBlank(message = "descricao não pode estar em branco")
    private String descricao;
    @DecimalMin(value = "0.0", message = "valor estimado não pode ser negativo")
    @NotNull(message = "valor estimado não pode ser nulo")
    private Double valorEstimado;
    @DecimalMin(value = "0.0", message = "valor aprovado não pode ser negativo")
    @NotNull(message = "valor aprovado não pode ser nulo")
    private Double valorAprovado;
    @NotBlank(message = "status não pode estar em branco")
    private String status;

    public Long getApoliceId() { return apoliceId; }
    public void setApoliceId(Long apoliceId) { this.apoliceId = apoliceId; }
    public java.time.LocalDateTime getDataOcorrencia() { return dataOcorrencia; }
    public void setDataOcorrencia(java.time.LocalDateTime dataOcorrencia) { this.dataOcorrencia = dataOcorrencia; }
    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }
    public Double getValorEstimado() { return valorEstimado; }
    public void setValorEstimado(Double valorEstimado) { this.valorEstimado = valorEstimado; }
    public Double getValorAprovado() { return valorAprovado; }
    public void setValorAprovado(Double valorAprovado) { this.valorAprovado = valorAprovado; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}
