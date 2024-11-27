package com.trabalhofinal.gerenciamentoEstoque.core.domain.entity;

import java.util.Date;

public class RelatorioPDia {
    private int id_venda;

    private String produto;

    private Date data_venda;

    private double total_arrecadado;

    private Long quantidade_vendida;

    private int total_estoque;

    public int getId_venda() {
        return id_venda;
    }

    public void setId_venda(int id_venda) {
        this.id_venda = id_venda;
    }

    public String getProduto() {
        return produto;
    }

    public void setProduto(String produto) {
        this.produto = produto;
    }

    public Date getData_venda() {
        return data_venda;
    }

    public void setData_venda(Date data_venda) {
        this.data_venda = data_venda;
    }

    public double getTotal_arrecadado() {
        return total_arrecadado;
    }

    public void setTotal_arrecadado(double total_arrecadado) {
        this.total_arrecadado = total_arrecadado;
    }

    public Long getQuantidade_vendida() {
        return quantidade_vendida;
    }

    public void setQuantidade_vendida(Long quantidade_vendida) {
        this.quantidade_vendida = quantidade_vendida;
    }

    public int getTotal_estoque() {
        return total_estoque;
    }

    public void setTotal_estoque(int total_estoque) {
        this.total_estoque = total_estoque;
    }

    public RelatorioPDia(int id_venda, String produto, Date data_venda, double total_arrecadado, Long quantidade_vendida, int total_estoque) {
        this.id_venda = id_venda;
        this.produto = produto;
        this.data_venda = data_venda;
        this.total_arrecadado = total_arrecadado;
        this.quantidade_vendida = quantidade_vendida;
        this.total_estoque = total_estoque;
    }
}
