package com.trabalhofinal.gerenciamentoEstoque.infra.repository.database;

import com.trabalhofinal.gerenciamentoEstoque.core.domain.contract.VendaProdutoRepository;
import com.trabalhofinal.gerenciamentoEstoque.core.domain.entity.Venda;
import com.trabalhofinal.gerenciamentoEstoque.core.domain.entity.VendaProduto;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class VendaProdutoRepositoryImpl implements VendaProdutoRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void insert(VendaProduto vendaProduto) {
        var query = """
                INSERT INTO venda_produto (id_venda, id_produto, quantidade)
                VALUES(:id_venda, :id_produto, :quantidade);
                """;

        entityManager.createNativeQuery(query, VendaProduto.class)
                .setParameter("id_venda", vendaProduto.getId_venda())
                .setParameter("id_produto", vendaProduto.getId_produto())
                .setParameter("quantidade", vendaProduto.getQuantidade())
                .executeUpdate();
    }

    @Override
    public void delete(int id, VendaProduto vendaProduto) {
        var query = """
                DELETE * FROM venda_produto
                WHERE id = :id;
                """;

        entityManager.createNativeQuery(query, VendaProduto.class)
                .setParameter("id", vendaProduto.getId())
                .executeUpdate();
    }

    @Override
    public void update(int id, VendaProduto vendaProduto) {
        var query = """
                UPDATE venda_produto 
                SET id_venda = :id_venda, id_produto = :id_produto, quantidade = :quantidade
                WHERE id = :id;
                """;

        entityManager.createNativeQuery(query, VendaProduto.class)
                .setParameter("id_venda", vendaProduto.getId_venda())
                .setParameter("id_produto", vendaProduto.getId_produto())
                .setParameter("quantidade", vendaProduto.getQuantidade())
                .executeUpdate();
    }

    @Override
    public List<VendaProduto> fetch() {

        var query = """
                SELECT * FROM venda_produto;
                """;

        List<VendaProduto> listar =
                entityManager.createNativeQuery(query, VendaProduto.class).getResultList();
        return listar;
    }
}
