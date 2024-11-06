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
    public void insert(@RequestBody Produto produto){
        produtoUseCase.insert(produto);
    }

    @PutMapping("/produto/{id}")
    public void update(@PathVariable int id, @RequestBody Produto produto){
        produtoUseCase.update(id, produto);
    }

    @DeleteMapping("/produto/{id}")
    public void delete(@PathVariable int id){
        produtoUseCase.delete(id);
    }

    @GetMapping("/produto/{id}")
    public Produto listarUm(@PathVariable int id){
        return produtoUseCase.listarUm(id);
    }

    @PutMapping("/produto/{id}/atualizar-quantidade/{novaQuantidade}")
    public void atualizarQuantidade(@PathVariable int id, @PathVariable int novaQuantidade){
        produtoUseCase.atualizarQuantidade(id, novaQuantidade);
    }

    @PutMapping("/produto/{id}/entrada/{entrada}")
    public void entrada(@PathVariable int id, @PathVariable int entrada){
        produtoUseCase.entrada(id, entrada);
    }

    @PutMapping("/produto/{id}/saida/{saida}")
    public void saida(@PathVariable int id, @PathVariable int saida){
        produtoUseCase.saida(id, saida);
    }

    @GetMapping("/produto/ver-em-falta")
    public List<Produto> verEmFalta(){
        return produtoUseCase.verEmFalta();
    }
}
