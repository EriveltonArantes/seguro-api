package com.seguroapi.dto;

public class SinistroResponseDTO {

    private Long id;
    private Long apoliceId;
    private java.time.LocalDateTime dataOcorrencia;
    private String descricao;
    private Double valorEstimado;
    private Double valorAprovado;
    private String status;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
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
