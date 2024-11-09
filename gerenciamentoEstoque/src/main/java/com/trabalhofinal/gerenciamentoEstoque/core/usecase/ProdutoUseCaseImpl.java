package com.trabalhofinal.gerenciamentoEstoque.core.usecase;

import com.trabalhofinal.gerenciamentoEstoque.core.domain.contract.ProdutoRepository;
import com.trabalhofinal.gerenciamentoEstoque.core.domain.contract.ProdutoUseCase;
import com.trabalhofinal.gerenciamentoEstoque.core.domain.entity.Produto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ProdutoUseCaseImpl implements ProdutoUseCase {

    @Autowired
    private ProdutoRepository produtoRepository;

    @Override
    public List<Produto> fetch() {
        return produtoRepository.fetch();
    }

    @Override
    public void insert(Produto produto) {
        List<Produto> produtosNomeIgual = produtoRepository.verNome(produto);

        if(produtosNomeIgual.toArray().length > 0){
            System.out.println("Produto já existe");
        }else{
            produto.converterParaCentavos();
            produtoRepository.insert(produto);
        }
    }

    @Override
    public void update(int id, Produto produto) {
        produtoRepository.update(id, produto);
    }

    @Override
    public void delete(int id) {
        produtoRepository.delete(id);
    }

    @Override
    public Produto listarUm(int id) {
        return produtoRepository.listarUm(id);
    }

    @Override
    public void atualizarQuantidade(int id, int novaQuantidade) {
        produtoRepository.atualizarQuantidade(id, novaQuantidade);
    }

    @Override
    public void entrada(int id, int entrada) {
        produtoRepository.entrada(id, entrada);
    }

    @Override
    public void saida(int id, int saida) {
        produtoRepository.saida(id, saida);
    }

    @Override
    public List<Produto> verEmFalta(){
        return produtoRepository.verEmFalta();
    }

    @Override
    public List<Produto> verNome(Produto produto) {
        return produtoRepository.verNome(produto);
    }


}
