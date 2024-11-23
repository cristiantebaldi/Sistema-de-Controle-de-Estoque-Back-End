package com.trabalhofinal.gerenciamentoEstoque.core.usecase;

import com.trabalhofinal.gerenciamentoEstoque.core.domain.contract.BalancoRepository;
import com.trabalhofinal.gerenciamentoEstoque.core.domain.contract.BalancoUseCase;
import com.trabalhofinal.gerenciamentoEstoque.core.domain.entity.Balanco;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BalancoUseCaseImpl implements BalancoUseCase {

    @Autowired
    private BalancoRepository balancoRepository;

    @Override
    public void insert(Balanco balanco) {
        balancoRepository.insert(balanco);
    }

    @Override
    public List<Balanco> fetch() {
        return balancoRepository.fetch();
    }

    @Override
    public void removerQtd(Balanco balanco) {
        balancoRepository.removerQtd(balanco);
    }
}
