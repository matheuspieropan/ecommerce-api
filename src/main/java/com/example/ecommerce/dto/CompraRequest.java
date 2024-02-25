package com.example.ecommerce.dto;

public class CompraRequest {

    private Long idUsuario;

    private Long idItem;

    private int quantidade;

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Long getIdItem() {
        return idItem;
    }

    public void setIdItem(Long idItem) {
        this.idItem = idItem;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public CompraRequest() {
    }

    public CompraRequest(Long idUsuario, Long idItem, int quantidade) {
        this.idUsuario = idUsuario;
        this.idItem = idItem;
        this.quantidade = quantidade;
    }
}