package com.trabalhofinal.gerenciamentoEstoque.core.usecase;

import com.trabalhofinal.gerenciamentoEstoque.core.domain.contract.VendaRepository;
import com.trabalhofinal.gerenciamentoEstoque.core.domain.contract.VendaUseCase;
import com.trabalhofinal.gerenciamentoEstoque.core.domain.entity.Produto;
import com.trabalhofinal.gerenciamentoEstoque.core.domain.entity.Venda;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VendaUseCaseImpl implements VendaUseCase {

    @Autowired
    private VendaRepository vendaRepository;

    @Override
    public List<Venda> fetch() {
        return vendaRepository.fetch();
    }

    @Override
    public void insert(Venda venda) {
        vendaRepository.insert(venda);
    }

    @Override
    public void update(int id, Venda venda) {
        vendaRepository.update(id, venda);
    }

    @Override
    public void delete(int id) {
        vendaRepository.delete(id);
    }

    @Override
    public Venda listarUm(int id) {
        return vendaRepository.listarUm(id);
    }
}
