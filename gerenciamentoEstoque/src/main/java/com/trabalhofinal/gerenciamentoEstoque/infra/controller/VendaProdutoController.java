package com.trabalhofinal.gerenciamentoEstoque.infra.controller;

import com.trabalhofinal.gerenciamentoEstoque.core.domain.contract.VendaProdutoUseCase;
import com.trabalhofinal.gerenciamentoEstoque.core.domain.entity.VendaProduto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class VendaProdutoController {

    @Autowired
    private VendaProdutoUseCase vendaProdutoUseCase;

    @GetMapping("/venda_produto")
    public List<VendaProduto> fetch(){
        return vendaProdutoUseCase.fetch();
    }

    @PostMapping("/venda_produto")
    public void insert(VendaProduto vendaProduto){
        vendaProdutoUseCase.insert(vendaProduto);
    }

    @PutMapping("/venda_produto/{id}")
    public void update(int id, VendaProduto vendaProduto){
        vendaProdutoUseCase.update(id, vendaProduto);
    }

    @DeleteMapping("/venda_produto/{id}")
    public void delete(int id, VendaProduto vendaProduto){
        vendaProdutoUseCase.delete(id, vendaProduto);
    }
}
