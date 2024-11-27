package com.trabalhofinal.gerenciamentoEstoque.core.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Balanco {

    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "id_produto")
    private int id_produto;

    @Column(name = "quantidade")
    private int quantidade;

    @Column(name = "tipo")
    private String tipo;


    public int getId_produto() {
        return id_produto;
    }

    public void setId_produto(int id_produto) {
        this.id_produto = id_produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
