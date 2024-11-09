package com.trabalhofinal.gerenciamentoEstoque.infra.repository.database;

import com.trabalhofinal.gerenciamentoEstoque.core.domain.contract.ProdutoRepository;
import com.trabalhofinal.gerenciamentoEstoque.core.domain.entity.Produto;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
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

    @Transactional
    @Override
    public void insert(Produto produto) {
        var query = """
                INSERT INTO produto (nome, quantidade, preco, quantidade_min)
                VALUES (:nome, :quantidade, :preco, :quantidade_min)
                """;

        entityManager.createNativeQuery(query, Produto.class)
                .setParameter("nome", produto.getNome())
                .setParameter("quantidade", produto.getQuantidade())
                .setParameter("preco", produto.getPreco())
                .setParameter("quantidade_min", produto.getQuantidade_min())
                .executeUpdate();
    }

    @Transactional
    @Override
    public void update(int id, Produto produto) {
        var query = """
                UPDATE produto
                SET nome = :nome, quantidade = :quantidade, preco = :preco, quantidade_min = :quantidade_min
                WHERE id = :id;
                """;

        entityManager.createNativeQuery(query, Produto.class)
                .setParameter("nome", produto.getNome())
                .setParameter("quantidade", produto.getQuantidade())
                .setParameter("preco", produto.getPreco())
                .setParameter("id", id)
                .setParameter("quantidade_min", produto.getQuantidade_min())
                .executeUpdate();
    }

    @Transactional
    @Override
    public void delete(int id) {
        var query = """
                DELETE FROM produto WHERE id = :id;
                """;

        entityManager.createNativeQuery(query, Produto.class)
                .setParameter("id", id)
                .executeUpdate();
    }

    @Override
    public Produto listarUm(int id) {
        var query = """
                SELECT * FROM produto WHERE id = :id;
                """;


        return (Produto) entityManager.createNativeQuery(query,Produto.class)
                .setParameter("id",id)
                .getSingleResult();
    }

    @Transactional
    @Override
    public void atualizarQuantidade(int id, int novaQuantidade) {
        var query = """
                UPDATE produto SET quantidade = :novaQuantidade WHERE id = :id;
                """;
        entityManager.createNativeQuery(query, Produto.class)
                .setParameter("novaQuantidade", novaQuantidade)
                .setParameter("id", id)
                .executeUpdate();
    }

    @Transactional
    @Override
    public void entrada(int id, int entrada){
        var queryQuantidadeAtual = """
                SELECT quantidade FROM produto WHERE id = :id;
                """;

        Integer quantidadeAtual = (Integer) entityManager.createNativeQuery(queryQuantidadeAtual)
                .setParameter("id", id)
                .getSingleResult();

        var query = """
                UPDATE produto SET quantidade = :novaQuantidade WHERE id = :id;
                """;

        entityManager.createNativeQuery(query, Produto.class)
                .setParameter("novaQuantidade", quantidadeAtual + entrada)
                .setParameter("id", id)
                .executeUpdate();
    }

    @Transactional
    @Override
    public void saida(int id, int saida) {
        var queryQuantidadeAtual = """
                SELECT quantidade FROM produto WHERE id = :id;
                """;

        Integer quantidadeAtual = (Integer) entityManager.createNativeQuery(queryQuantidadeAtual)
                .setParameter("id", id)
                .getSingleResult();

        var query = """
                UPDATE produto SET quantidade = :novaQuantidade WHERE id = :id;
                """;
        entityManager.createNativeQuery(query, Produto.class)
                .setParameter("novaQuantidade", quantidadeAtual - saida)
                .setParameter("id", id)
                .executeUpdate();
    }

    @Transactional
    @Override
    public List<Produto> verEmFalta() {
        var query = """
                SELECT * FROM produto WHERE quantidade < quantidade_min;
                """;

        return entityManager.createNativeQuery(query, Produto.class)
                .getResultList();
    }

    @Override
    public List<Produto> verNome(Produto produto) {
        var query = """
                SELECT * FROM produto WHERE nome = :nome;
                """;

        return entityManager.createNativeQuery(query, Produto.class)
                .setParameter("nome", produto.getNome())
                .getResultList();
    }


}
