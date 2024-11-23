package com.trabalhofinal.gerenciamentoEstoque.core.domain.contract;

import com.trabalhofinal.gerenciamentoEstoque.core.domain.entity.Balanco;

import java.util.List;

public interface BalancoUseCase {
    public void insert(Balanco balanco);

    public List<Balanco> fetch();

    public void removerQtd(Balanco balanco);
}
