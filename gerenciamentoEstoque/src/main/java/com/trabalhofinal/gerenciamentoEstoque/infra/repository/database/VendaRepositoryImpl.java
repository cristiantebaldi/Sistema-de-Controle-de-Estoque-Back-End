package com.trabalhofinal.gerenciamentoEstoque.infra.repository.database;

import com.trabalhofinal.gerenciamentoEstoque.core.domain.contract.VendaRepository;
import com.trabalhofinal.gerenciamentoEstoque.core.domain.entity.Produto;
import com.trabalhofinal.gerenciamentoEstoque.core.domain.entity.Venda;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class VendaRepositoryImpl implements VendaRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Venda> fetch() {
        var query = """
                SELECT * FROM venda;
                """;

        return entityManager.createNativeQuery(query, Venda.class).getResultList();
    }

    @Override
    public void insert(Venda venda) {
        var query = """
                INSERT INTO venda (data_compra)
                VALUES (:data_compra)
                """;

        entityManager.createNativeQuery(query, Venda.class)
                .setParameter("data_compra", venda.getData_compra())
                .executeUpdate();
    }

    @Override
    public void update(int id, Venda venda) {
        var query = """
                UPDATE venda
                SET data_compra = :data_compra
                WHERE id = :id;
                """;

        entityManager.createNativeQuery(query, Venda.class)
                .setParameter("data_compra", venda.getData_compra())
                .setParameter("id", venda.getId())
                .executeUpdate();
    }

    @Override
    public void delete(int id, Venda venda) {
        var query = """
                DELETE * FROM venda WHERE id = :id;
                """;

        entityManager.createNativeQuery(query, Venda.class)
                .setParameter("id", venda.getId())
                .executeUpdate();
    }
}
