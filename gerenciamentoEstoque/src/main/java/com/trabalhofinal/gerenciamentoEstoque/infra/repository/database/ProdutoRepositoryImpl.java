package com.trabalhofinal.gerenciamentoEstoque.infra.repository.database;

import com.trabalhofinal.gerenciamentoEstoque.core.domain.contract.ProdutoRepository;
import com.trabalhofinal.gerenciamentoEstoque.core.domain.entity.Produto;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProdutoRepositoryImpl implements ProdutoRepository {

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public List<Produto> fetch() {
        var query = """
                SELECT * FROM produto;
                """;

        return entityManager.createNativeQuery(query, Produto.class).getResultList();
    }

    @Override
    public void insert(Produto produto) {
        var query = """
                INSERT INTO produto (nome, quantidade, preco)
                VALUES (:nome, :quantidade, :preco)
                """;

        entityManager.createNativeQuery(query, Produto.class)
                .setParameter("nome", produto.getNome())
                .setParameter("quantidade", produto.getQuantidade())
                .setParameter("preco", produto.getPreco())
                .executeUpdate();
    }

    @Override
    public void update(int id, Produto produto) {
        var query = """
                UPDATE produto
                SET nome = :nome, quantidade = :quantidade, preco = :preco
                WHERE id = :id;
                """;

        entityManager.createNativeQuery(query, Produto.class)
                .setParameter("nome", produto.getNome())
                .setParameter("quantidade", produto.getQuantidade())
                .setParameter("preco", produto.getPreco())
                .setParameter("id", produto.getId())
                .executeUpdate();
    }

    @Override
    public void delete(int id, Produto produto) {
        var query = """
                DELETE * FROM produto WHERE id = :id;
                """;

        entityManager.createNativeQuery(query, Produto.class)
                .setParameter("id", produto.getId())
                .executeUpdate();
    }
}
