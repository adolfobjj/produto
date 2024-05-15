package com.globo.produto.service;

import com.globo.produto.entity.Compra;
import com.globo.produto.repository.CompraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompraService {

    @Autowired
    private CompraRepository compraRepository;

    public List<Compra> findAll() {
        return compraRepository.findAll();
    }

    public Optional<Compra> findById(Long id) {
        return compraRepository.findById(id);
    }

    public Compra save(Compra compra) {
        return compraRepository.save(compra);
    }

    public void deleteById(Long id) {
        compraRepository.deleteById(id);
    }
}
