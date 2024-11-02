package com.trabalhofinal.gerenciamentoEstoque.core.domain.contract;

import com.trabalhofinal.gerenciamentoEstoque.core.domain.entity.Produto;

import java.util.List;

public interface ProdutoRepository {
    public List<Produto> fetch();

    public void insert(Produto produto);

    public void update(int id, Produto produto);

    public void delete(int id);

    public Produto listarUm(int id);
}
