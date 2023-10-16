package com.globo.produto.service.serviceImpl;

import com.globo.produto.ProdutoApplication;
import com.globo.produto.entity.Produto;
import com.globo.produto.repository.ProdutoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
@Import(ProdutoApplication.class)
class ProdutoServiceImplTest {

    @Mock
    private ProdutoRepository produtoRepository;

    @InjectMocks
    private ProdutoServiceImpl produtoService;


    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }


    @Test
    void obterTodosDeveRetornarListaDeProdutos() {
        // Mock de dados
        List<Produto> produtosMock = new ArrayList<>();
        produtosMock.add(new Produto(1L, "Produto 1", "Descrição 1", 10.0));
        produtosMock.add(new Produto(2L, "Produto 2", "Descrição 2", 20.0));

        when(produtoRepository.findAll()).thenReturn(produtosMock);

        List<Produto> produtos = produtoService.obterTodos();

        assertEquals(produtosMock.size(), produtos.size());
    }

    @Test
    void obterPorIdDeveRetornarProdutoExistente() {
        Produto produtoMock = new Produto(1L, "Produto Teste", "Descrição Teste", 15.0);

        when(produtoRepository.findById(1L)).thenReturn(Optional.of(produtoMock));

        Optional<Produto> produto = produtoService.obterPorId(1L);

        assertTrue(produto.isPresent());
        assertEquals(produtoMock, produto.get());
    }

    @Test
    void obterPorIdDeveRetornarVazioParaProdutoInexistente() {
        when(produtoRepository.findById(1L)).thenReturn(Optional.empty());

        Optional<Produto> produto = produtoService.obterPorId(1L);

        assertFalse(produto.isPresent()); // Verificando que está vazio
    }

    @Test
    void criarProdutoDeveRetornarProdutoCriado() {
        Produto produtoMock = new Produto(1L, "Novo Produto", "Descrição do Novo Produto", 25.0);

        when(produtoRepository.save(any())).thenReturn(produtoMock);

        Produto produto = produtoService.criarProduto(new Produto());

        assertNotNull(produto);
        assertEquals(produtoMock, produto);
    }

    @Test
    void atualizarProdutoDeveRetornarProdutoAtualizado() {
        Produto produtoMock = new Produto(1L, "Produto Antigo", "Descrição Antiga", 30.0);

        when(produtoRepository.save(any())).thenReturn(produtoMock);

        Produto produtoAtualizado = produtoService.atualizarProduto(1L, new Produto());

        assertNotNull(produtoAtualizado);
        assertEquals(produtoMock, produtoAtualizado);
    }

    @Test
    void excluirProdutoDeveChamarDeleteNoRepository() {
        produtoService.excluirProduto(1L);

        verify(produtoRepository, times(1)).deleteById(1L);
    }
}
