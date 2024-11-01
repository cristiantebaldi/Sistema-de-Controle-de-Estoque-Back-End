package com.trabalhofinal.gerenciamentoEstoque.core.usecase;

import com.trabalhofinal.gerenciamentoEstoque.core.domain.contract.VendaProdutoRepository;
import com.trabalhofinal.gerenciamentoEstoque.core.domain.contract.VendaProdutoUseCase;
import com.trabalhofinal.gerenciamentoEstoque.core.domain.entity.VendaProduto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VendaProdutoUseCaseImpl implements VendaProdutoUseCase {

    @Autowired
    private VendaProdutoRepository vendaProdutoRepository;

    @Override
    public void insert(VendaProduto vendaProduto) {
        vendaProdutoRepository.insert(vendaProduto);
    }

    @Override
    public void delete(int id, VendaProduto vendaProduto) {
        vendaProdutoRepository.delete(id, vendaProduto);
    }

    @Override
    public void update(int id, VendaProduto vendaProduto) {
        vendaProdutoRepository.update(id, vendaProduto);
    }

    @Override
    public List<VendaProduto> fetch() {
        return vendaProdutoRepository.fetch();
    }
}
