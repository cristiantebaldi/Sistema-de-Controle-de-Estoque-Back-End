package com.trabalhofinal.gerenciamentoEstoque.infra.controller;

import com.trabalhofinal.gerenciamentoEstoque.core.domain.contract.BalancoUseCase;
import com.trabalhofinal.gerenciamentoEstoque.core.domain.entity.Balanco;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BalancoController {
    @Autowired
    private BalancoUseCase balancoUseCase;

    @PostMapping("/balanco")
    public void insert(@RequestBody Balanco balanco){
        balancoUseCase.insert(balanco);
    }

    @GetMapping("/balanco")
    public List<Balanco> fetch(){
        return balancoUseCase.fetch();
    }
}
