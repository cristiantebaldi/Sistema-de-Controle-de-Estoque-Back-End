package com.trabalhofinal.gerenciamentoEstoque.core.usecase;

import com.trabalhofinal.gerenciamentoEstoque.core.domain.contract.ProdutoRepository;
import com.trabalhofinal.gerenciamentoEstoque.core.domain.contract.ProdutoUseCase;
import com.trabalhofinal.gerenciamentoEstoque.core.domain.contract.VendaProdutoRepository;
import com.trabalhofinal.gerenciamentoEstoque.core.domain.contract.VendaProdutoUseCase;
import com.trabalhofinal.gerenciamentoEstoque.core.domain.entity.Produto;
import com.trabalhofinal.gerenciamentoEstoque.core.domain.entity.VendaProduto;
import jakarta.persistence.NoResultException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VendaProdutoUseCaseImpl implements VendaProdutoUseCase {

    @Autowired
    private VendaProdutoRepository vendaProdutoRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    @Override
    public void insert(VendaProduto vendaProduto) {

        if(produtoRepository.listarUm(vendaProduto.getId_produto()) != null){
            var produto = produtoRepository.listarUm(vendaProduto.getId_produto());

            if (vendaProduto.getQuantidade() > 0 && vendaProduto.getQuantidade() <= produto.getQuantidade()) {
                vendaProdutoRepository.insert(vendaProduto);
                vendaProdutoRepository.removerQuantidade(vendaProduto);
            } else {
                System.out.println("Quantidade inválida");
            }
        }else{
            System.out.println("Produto ou venda inválido");
        }


    }

    @Override
    public void removerQuantidade(VendaProduto vendaProduto) {
        vendaProdutoRepository.removerQuantidade(vendaProduto);
    }

    @Override
    public void delete(int id) {
        vendaProdutoRepository.delete(id);
    }

    @Override
    public void update(int id, VendaProduto vendaProduto) {
        var produto = produtoRepository.listarUm(vendaProduto.getId_produto());
        if(vendaProduto.getQuantidade() > 0 && vendaProduto.getQuantidade() <= produto.getQuantidade()){
            vendaProdutoRepository.removerQtdUpdate(vendaProduto);
            vendaProdutoRepository.update(id, vendaProduto);
            
        }else {
            System.out.println("Quantidade Inválida");
        }

    }

    @Override
    public void removerQtdUpdate(VendaProduto vendaProduto) {
        vendaProdutoRepository.removerQtdUpdate(vendaProduto);
    }

    @Override
    public List<VendaProduto> fetch() {
        return vendaProdutoRepository.fetch();
    }

    @Override
    public VendaProduto listarUm(int id) {
        return vendaProdutoRepository.listarUm(id);
    }
}
