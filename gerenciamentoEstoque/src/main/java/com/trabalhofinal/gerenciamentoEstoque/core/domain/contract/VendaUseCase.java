package com.trabalhofinal.gerenciamentoEstoque.core.domain.contract;

import com.trabalhofinal.gerenciamentoEstoque.core.domain.entity.Produto;
import com.trabalhofinal.gerenciamentoEstoque.core.domain.entity.Relatorio;
import com.trabalhofinal.gerenciamentoEstoque.core.domain.entity.RelatorioPDia;
import com.trabalhofinal.gerenciamentoEstoque.core.domain.entity.Venda;
import org.springframework.http.ResponseEntity;

import java.awt.geom.RectangularShape;
import java.util.Date;
import java.util.List;

public interface VendaUseCase {
    public List<Venda> fetch();

    public void insert(Venda venda);

    public void update(int id, Venda venda);

    public void delete(int id);

    public Venda listarUm(int id);

    public List<Relatorio> relatorioVendas(Date data_inicio, Date data_final);

    public List<RelatorioPDia> relatorioPorDia(Date data_busca);
}
