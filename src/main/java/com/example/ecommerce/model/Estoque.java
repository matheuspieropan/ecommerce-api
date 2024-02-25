package com.example.ecommerce.model;

public class Estoque {

    private Long id;

    private int quantidade;

    private Long idItem;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public Long getIdItem() {
        return idItem;
    }

    public void setIdItem(Long idItem) {
        this.idItem = idItem;
    }

    public Estoque() {
    }

    public Estoque(Long id, int quantidade, Long idItem) {
        this.id = id;
        this.quantidade = quantidade;
        this.idItem = idItem;
    }
}