package com.globo.produto.service.serviceImpl;

import com.globo.produto.entity.Produto;
import com.globo.produto.repository.ProdutoRepository;
import com.globo.produto.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ProdutoServiceImpl implements ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    @Override
    public List<Produto> obterTodos() {
        return produtoRepository.findAll();
    }

    @Override
    public Optional<Produto> obterPorId(Long id) {
        return produtoRepository.findById(id);
    }

    @Override
    public Produto criarProduto(Produto produto) {
        return produtoRepository.save(produto);
    }

    @Override
    public Produto atualizarProduto(Long id, Produto produto) {
        produto.setId(id);
        return produtoRepository.save(produto);
    }

    @Override
    public void excluirProduto(Long id) {
        produtoRepository.deleteById(id);
    }
}
