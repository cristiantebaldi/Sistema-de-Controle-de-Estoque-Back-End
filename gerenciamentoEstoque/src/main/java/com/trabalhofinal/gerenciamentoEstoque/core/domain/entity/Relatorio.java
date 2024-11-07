package com.trabalhofinal.gerenciamentoEstoque.core.domain.entity;

public class Relatorio {
    private String nome;

    private double total_arrecadado;

    private Long quantidade_vendida;

    private int total_estoque;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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

    public Relatorio(String nome, double total_arrecadado, Long quantidade_vendida, int total_estoque) {
        this.nome = nome;
        this.total_arrecadado = total_arrecadado;
        this.quantidade_vendida = quantidade_vendida;
        this.total_estoque = total_estoque;
    }
}
