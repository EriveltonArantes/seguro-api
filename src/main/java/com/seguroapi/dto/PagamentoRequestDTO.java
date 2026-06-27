package com.seguroapi.dto;

import jakarta.validation.constraints.*;

public class PagamentoRequestDTO {

    @NotNull(message = "ApoliceId é obrigatório")
    @Positive(message = "ApoliceId deve ser um ID válido (positivo)")
    private Long apoliceId;
    @NotNull(message = "data pagamento não pode ser nulo")
    private java.time.LocalDateTime dataPagamento;
    @DecimalMin(value = "0.0", message = "valor pago não pode ser negativo")
    @NotNull(message = "valor pago não pode ser nulo")
    private Double valorPago;
    @NotBlank(message = "forma pagamento não pode estar em branco")
    private String formaPagamento;
    @NotBlank(message = "status não pode estar em branco")
    private String status;

    public Long getApoliceId() { return apoliceId; }
    public void setApoliceId(Long apoliceId) { this.apoliceId = apoliceId; }
    public java.time.LocalDateTime getDataPagamento() { return dataPagamento; }
    public void setDataPagamento(java.time.LocalDateTime dataPagamento) { this.dataPagamento = dataPagamento; }
    public Double getValorPago() { return valorPago; }
    public void setValorPago(Double valorPago) { this.valorPago = valorPago; }
    public String getFormaPagamento() { return formaPagamento; }
    public void setFormaPagamento(String formaPagamento) { this.formaPagamento = formaPagamento; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}
