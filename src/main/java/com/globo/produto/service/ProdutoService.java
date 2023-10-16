package com.globo.produto.service;

import java.util.List;
import java.util.Optional;

public interface ProdutoService {

    List<Produto> obterTodos();

    Optional<Produto> obterPorId(Long id);

    Produto criarProduto(Produto produto);

    Produto atualizarProduto(Long id, Produto produto);

    void excluirProduto(Long id);
}
