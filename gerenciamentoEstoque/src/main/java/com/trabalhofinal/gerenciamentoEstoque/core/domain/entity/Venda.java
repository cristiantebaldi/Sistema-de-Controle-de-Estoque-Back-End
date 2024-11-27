package com.trabalhofinal.gerenciamentoEstoque.core.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.Date;

@Entity
public class Venda {
    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "data_compra")
    private Date data_compra;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getData_compra() {
        return data_compra;
    }

    public void setData_compra(Date data_compra) {
        this.data_compra = data_compra;
    }
}
