package com.trabalhofinal.gerenciamentoEstoque.core.domain.contract;

import com.trabalhofinal.gerenciamentoEstoque.core.domain.entity.Produto;
import com.trabalhofinal.gerenciamentoEstoque.core.domain.entity.Venda;

import java.util.List;

public interface VendaRepository {
    public List<Venda> fetch();

    public void insert(Venda venda);

    public void update(int id, Venda venda);

    public void delete(int id);

    public Venda listarUm(int id);

    public List<Venda> relatorio();
}
