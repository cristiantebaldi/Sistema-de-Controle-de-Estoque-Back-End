package com.trabalhofinal.gerenciamentoEstoque.infra.repository.database;

import com.trabalhofinal.gerenciamentoEstoque.core.domain.contract.BalancoRepository;
import com.trabalhofinal.gerenciamentoEstoque.core.domain.entity.Balanco;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BalancoRepositoryImpl implements BalancoRepository {

    @Autowired
    private EntityManager entityManager;

    @Transactional
    @Override
    public void insert(Balanco balanco) {
        var query = """
                INSERT INTO balanco (id_produto, quantidade, tipo)
                VALUES(:id_produto, :quantidade, :tipo);
                """;
        entityManager.createNativeQuery(query, Balanco.class)
                .setParameter("id_produto", balanco.getId_produto())
                .setParameter("quantidade", balanco.getQuantidade())
                .setParameter("tipo", balanco.getTipo())
                .executeUpdate();
    }

    @Override
    public List<Balanco> fetch() {
        var query = """
                SELECT * FROM balanco;
                """;
        return entityManager.createNativeQuery(query, Balanco.class).getResultList();
    }

    @Override
    public void removerQtd(Balanco balanco) {

    }
}
