package com.trabalhofinal.gerenciamentoEstoque.core.domain.contract;

import com.trabalhofinal.gerenciamentoEstoque.core.domain.entity.Produto;

import java.util.List;

public interface ProdutoUseCase {
    public List<Produto> fetch();

    public void insert(Produto produto);

    public void update(int id, Produto produto);

    public void delete(int id);

    public Produto listarUm(int id);

    public void atualizarQuantidade(int id, int novaQuantidade);

    public void entrada(int id, int entrada);

    public void saida(int id, int saida);

    public List<Produto> verEmFalta();

}
