package com.trabalhofinal.gerenciamentoEstoque.infra.controller;

import com.trabalhofinal.gerenciamentoEstoque.core.domain.contract.VendaUseCase;
import com.trabalhofinal.gerenciamentoEstoque.core.domain.entity.Venda;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class VendaController {
    @Autowired
    private VendaUseCase vendaUseCase;

    @GetMapping("/venda")
    public List<Venda> fetch(){
        return vendaUseCase.fetch();
    }

    @PostMapping("/venda")
    public void insert(@RequestBody Venda venda){
        vendaUseCase.insert(venda);
    }

    @PutMapping("/venda/{id}")
    public void update(@PathVariable int id, @RequestBody Venda venda){
        vendaUseCase.update(id, venda);
    }

    @DeleteMapping("/venda/{id}")
    public void delete(@PathVariable int id){
        vendaUseCase.delete(id);
    }

    @GetMapping("/venda/{id}")
    public Venda listarUm(@PathVariable int id){
        return vendaUseCase.listarUm(id);
    }
}
