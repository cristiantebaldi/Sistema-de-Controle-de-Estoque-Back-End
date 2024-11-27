package com.trabalhofinal.gerenciamentoEstoque.infra.repository.database;

import com.trabalhofinal.gerenciamentoEstoque.core.domain.contract.VendaProdutoRepository;
import com.trabalhofinal.gerenciamentoEstoque.core.domain.entity.Produto;
import com.trabalhofinal.gerenciamentoEstoque.core.domain.entity.Venda;
import com.trabalhofinal.gerenciamentoEstoque.core.domain.entity.VendaProduto;
import com.trabalhofinal.gerenciamentoEstoque.core.dto.VendaProdutoOutput;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class VendaProdutoRepositoryImpl implements VendaProdutoRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
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

    @Transactional
    @Override
    public void removerQuantidade(VendaProduto vendaProduto) {
        var queryRemover = """
                UPDATE produto
                SET quantidade = (quantidade - :venda_produto.quantidade)
                WHERE id = :venda_produto.id_produto
                """;

        entityManager.createNativeQuery(queryRemover, VendaProduto.class)
                .setParameter("venda_produto.id_produto", vendaProduto.getId_produto())
                .setParameter("venda_produto.quantidade", vendaProduto.getQuantidade())
                .executeUpdate();
    }

    @Transactional
    @Override
    public void delete(int id) {
        var query = """
                DELETE FROM venda_produto
                WHERE id = :id;
                """;

        entityManager.createNativeQuery(query, VendaProduto.class)
                .setParameter("id", id)
                .executeUpdate();
    }

    @Transactional
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
                .setParameter("id", id)
                .executeUpdate();
    }

    @Transactional
    @Override
    public void removerQtdUpdate(VendaProduto vendaProduto) {
        int quantidadeAntiga = (int) entityManager.createNativeQuery(
                        "SELECT quantidade FROM venda_produto WHERE id = :id")
                .setParameter("id", vendaProduto.getId())
                .getSingleResult();

        int diferenca = vendaProduto.getQuantidade() - quantidadeAntiga;

        var query = """
                UPDATE produto SET
                quantidade = (quantidade - :diferenca)
                WHERE id = :id_produto;
                """;
        entityManager.createNativeQuery(query, VendaProduto.class)
                .setParameter("diferenca", diferenca)
                .setParameter("id_produto",vendaProduto.getId_produto())
                .executeUpdate();

        System.out.println("Certo");
    }

    @Override
    public List<VendaProduto> fetch() {

        var query = """
                SELECT vp.id, vp.id_venda, p.nome AS nome_produto FROM venda_produto vp
                INNER JOIN produto p ON p.id = vp.id_produto;
                """;

        List<VendaProduto> listar =
                entityManager.createNativeQuery(query, VendaProdutoOutput.class).getResultList();
        return listar;
    }

    @Override
    public VendaProduto listarUm(int id) {
        var query = """
                SELECT * FROM venda_produto WHERE id = :id
                """;

        return (VendaProduto) entityManager.createNativeQuery(query,VendaProduto.class)
                .setParameter("id",id)
                .getSingleResult();
    }

    @Override
    public List<Produto> verId(VendaProduto vendaProduto) throws Exception {
        var query = """
                SELECT * FROM produto WHERE id = :id;
                """;

        return entityManager.createNativeQuery(query, Produto.class)
                .setParameter("id", vendaProduto.getId_produto())
                .getResultList();
    }
}
