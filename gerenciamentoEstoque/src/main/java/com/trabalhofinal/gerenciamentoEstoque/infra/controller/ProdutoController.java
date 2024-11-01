package com.trabalhofinal.gerenciamentoEstoque.infra.controller;

import com.trabalhofinal.gerenciamentoEstoque.core.domain.contract.ProdutoUseCase;
import com.trabalhofinal.gerenciamentoEstoque.core.domain.entity.Produto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProdutoController {

    @Autowired
    private ProdutoUseCase produtoUseCase;

    @GetMapping("/produto")
    public List<Produto> fetch(){
        return produtoUseCase.fetch();
    }

    @PostMapping("/produto")
    public void insert(Produto produto){
        produtoUseCase.insert(produto);
    }

    @PutMapping("/produto/{id}")
    public void update(int id, Produto produto){
        produtoUseCase.update(id, produto);
    }

    @DeleteMapping("/produto/{id}")
    public void delete(int id, Produto produto){
        produtoUseCase.delete(id, produto);
    }
}
