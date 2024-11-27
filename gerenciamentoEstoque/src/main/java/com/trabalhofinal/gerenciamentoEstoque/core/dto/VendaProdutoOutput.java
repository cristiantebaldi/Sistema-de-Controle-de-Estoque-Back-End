package com.trabalhofinal.gerenciamentoEstoque.core.dto;

import com.trabalhofinal.gerenciamentoEstoque.core.domain.entity.VendaProduto;


import java.util.Date;

public record VendaProdutoOutput(int id, int id_venda, String nome_produto, Date data_compra, int quantidade, Double total_arrecadado) {

}
