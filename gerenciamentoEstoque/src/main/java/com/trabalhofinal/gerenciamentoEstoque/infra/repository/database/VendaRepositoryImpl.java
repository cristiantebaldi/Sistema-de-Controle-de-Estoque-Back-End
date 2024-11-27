package com.trabalhofinal.gerenciamentoEstoque.infra.repository.database;

import com.trabalhofinal.gerenciamentoEstoque.core.domain.contract.VendaRepository;
import com.trabalhofinal.gerenciamentoEstoque.core.domain.entity.Relatorio;
import com.trabalhofinal.gerenciamentoEstoque.core.domain.entity.RelatorioPDia;
import com.trabalhofinal.gerenciamentoEstoque.core.domain.entity.Venda;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.Date;
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

    @Transactional
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

    @Transactional
    @Override
    public void update(int id, Venda venda) {
        var query = """
                UPDATE venda
                SET data_compra = :data_compra
                WHERE id = :id;
                """;

        entityManager.createNativeQuery(query, Venda.class)
                .setParameter("data_compra", venda.getData_compra())
                .setParameter("id", id)
                .executeUpdate();
    }

    @Transactional
    @Override
    public void delete(int id) {
        var query = """
                DELETE FROM venda WHERE id = :id;
                """;

        entityManager.createNativeQuery(query, Venda.class)
                .setParameter("id", id)
                .executeUpdate();
    }

    @Override
    public Venda listarUm(int id) {
        var query = """
                SELECT * FROM venda WHERE id = :id;
                """;
        return (Venda)entityManager.createNativeQuery(query, Venda.class)
                .setParameter("id", id)
                .getSingleResult();
    }

    @Override
    public List<Relatorio> relatorioVendas(Date data_inicio, Date data_final) {
        var query = """
                SELECT p.nome AS produto, SUM (vp.quantidade) * p.preco AS total_arrecadado, SUM (vp.quantidade) AS quantidade_vendida, p.quantidade AS total_estoque FROM produto p\s
                INNER JOIN venda_produto vp ON vp.id_produto = p.id
                INNER JOIN venda v ON v.id = vp.id_venda
                WHERE v.data_compra BETWEEN :data_inicio AND :data_final
                GROUP BY p.id
                ORDER BY quantidade_vendida DESC;
                """;

        List<Relatorio> relatorio = (List<Relatorio>) entityManager.createNativeQuery(query, Relatorio.class)
                .setParameter("data_inicio", data_inicio)
                .setParameter("data_final", data_final)
                .getResultList();

        return relatorio;
    }

    @Override
    public List<RelatorioPDia> relatorioPorDia(Date data_busca) {
        var query = """
                SELECT v.id AS id_venda, p.nome AS produto, v.data_compra AS data_venda, SUM (vp.quantidade) * p.preco AS total_arrecadado, SUM (vp.quantidade) AS quantidade_vendida, p.quantidade AS total_estoque FROM produto p\s
                INNER JOIN venda_produto vp ON vp.id_produto = p.id
                INNER JOIN venda v ON v.id = vp.id_venda
                WHERE v.data_compra >= :data
                GROUP BY p.id, v.data_compra, v.id
                ORDER BY quantidade_vendida DESC;
                """;

        return entityManager.createNativeQuery(query, RelatorioPDia.class)
                .setParameter("data", data_busca)
                .getResultList();
    }
}
