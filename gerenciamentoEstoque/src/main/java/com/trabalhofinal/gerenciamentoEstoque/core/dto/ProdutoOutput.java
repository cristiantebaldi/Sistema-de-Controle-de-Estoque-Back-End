package com.trabalhofinal.gerenciamentoEstoque.core.dto;

public record ProdutoOutput(
        int id,
        String nome,
        int quantidade,
        int quantidade_minima,
        float preco,
        Double valor_estoque
) {

}
