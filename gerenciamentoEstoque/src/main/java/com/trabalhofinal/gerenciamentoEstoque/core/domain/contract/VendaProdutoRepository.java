package com.trabalhofinal.gerenciamentoEstoque.core.domain.contract;

import com.trabalhofinal.gerenciamentoEstoque.core.domain.entity.Venda;
import com.trabalhofinal.gerenciamentoEstoque.core.domain.entity.VendaProduto;

import java.util.List;

public interface VendaProdutoRepository {
    public void insert(VendaProduto vendaProduto);

    public void delete(int id, VendaProduto vendaProduto);

    public void update(int id, VendaProduto vendaProduto);

    public List<VendaProduto> fetch();

}
