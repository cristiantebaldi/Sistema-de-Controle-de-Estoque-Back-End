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
    public void insert(@RequestBody VendaProduto vendaProduto){
        vendaProdutoUseCase.insert(vendaProduto);   
    }

    @PutMapping("/venda_produto/{id}")
    public void update(@PathVariable int id, @RequestBody VendaProduto vendaProduto){
        vendaProdutoUseCase.update(id, vendaProduto);
    }

    @DeleteMapping("/venda_produto/{id}")
    public void delete(@PathVariable int id){
        vendaProdutoUseCase.delete(id);
    }

    @GetMapping("/venda_produto/{id}")
    public VendaProduto listarUm(@PathVariable int id){
        return vendaProdutoUseCase.listarUm(id);
    }
}
