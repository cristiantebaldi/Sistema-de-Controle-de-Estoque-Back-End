# Back-end do Sistema de Controle de Estoque

API para gerenciar controle de estoque, construída com Java, Spring Boot e PostgreSQL.

## Tecnologias

- Java
- Spring Boot
- PostgreSQL


## EndPoints

# Produto
    # Get
    - ("/produto") - Retorna uma lista de todos produtos do estoque (id, nome, quantidade, preço (em reais) quantidade_min)
    - ("/produto/{id}") - Retorna um produto em específico
    - ("/produto/ver-em-falta") - Retorna os produtos que a quantidade esta menor do que a quantidade minima definida ao inserir

    # Post
    - ("/produto") - Adicionar novo produto ao estoque (Nome, quantidade, preço, quantidade_min)
    
    # Put
    - ("/produto/{id}") - Atualizar alguma informação de um produto em específico
    - ("/produto/atualizar-quantidade/{novaQuantidade}") - Atualiza a quantidade de um produto específico
    - ("/produto/{id}/entrada/{entrada}") - Realiza entrada de um produto em estoque, atualizando a quantidade com base em quanto tinha
    - ("/produto/{id}/saida/{saida}") - Realiza saída de um produto em estoque, atualizando a quantidade com base em quanto tinha

    # Delete
    - ("/produto/{id}") - Remove um produto do banco de dados

# Venda
    # Get
    - ("/venda") - Retorna todas vendas que existem no banco de dados (id, data_compra)
    - ("/venda/{id}") - Retorna uma venda em específico
    - ("/venda/relatorios") - Relatorio das vendas de acordo com um intervalo de dias (nome, total_arrecadado, quantidade_vendida, total_estoque)
        Com base em dois parametros, data_inicio e data_final;
    -("/venda/relatorio-por-dia") - Relatorio das vendas por cada dia (id_venda, produto, data_venda, total_arrecadado, quantidade_vendida, total_estoque)
        Com base em um parametro, data_busca;

    # Post
    - ("/venda") - Adiciona uma nova venda ao estoque (data_compra)

    # Put
    - ("/venda/{id}") - Altera as informações de uma venda específica (Data da compra)

    # Delete
    - ("/venda/{id}") - Deleta uma venda do banco de dados

# VendaProduto
    # Get
    - ("/venda_produto") - Retorna todas venda_produtos do banco de dados (id, id_venda, id_produto, quantidade)
    - ("/venda_produto/{id}") - Retorna uma venda_produto em específico

    # Post 
    - ("/venda_produto") - Adicona uma venda_produto (id_venda, id_produto, quantidade)

    # Put
    - ("/venda_produto/{id}") - Altera uma venda_produto específica

    # Delete
    - ("/venda_produto/{id}") - Deleta uma venda_produto do banco de dados
