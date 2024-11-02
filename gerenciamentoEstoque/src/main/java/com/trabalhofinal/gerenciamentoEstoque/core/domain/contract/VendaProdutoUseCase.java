package com.trabalhofinal.gerenciamentoEstoque.core.domain.contract;

import com.trabalhofinal.gerenciamentoEstoque.core.domain.entity.Produto;
import com.trabalhofinal.gerenciamentoEstoque.core.domain.entity.VendaProduto;

import java.util.List;

public interface VendaProdutoUseCase {
    public void insert(VendaProduto vendaProduto);

    public void removerQuantidade(VendaProduto vendaProduto);

    public void delete(int id);

    public void update(int id, VendaProduto vendaProduto);

    public void removerQtdUpdate(VendaProduto vendaProduto);

    public List<VendaProduto> fetch();

    public VendaProduto listarUm(int id);
}
