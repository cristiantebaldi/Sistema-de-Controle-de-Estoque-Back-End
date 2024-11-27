package com.trabalhofinal.gerenciamentoEstoque.infra.controller;

import com.trabalhofinal.gerenciamentoEstoque.core.domain.contract.BalancoUseCase;
import com.trabalhofinal.gerenciamentoEstoque.core.domain.entity.Balanco;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
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
