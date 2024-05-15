package com.globo.produto.controller;

import com.globo.produto.entity.Compra;
import com.globo.produto.service.CompraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/compras")
public class CompraController {

    @Autowired
    private CompraService compraService;

    @GetMapping
    public List<Compra> getAllCompras() {
        return compraService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Compra> getCompraById(@PathVariable Long id) {
        return compraService.findById(id)
                .map(compra -> ResponseEntity.ok().body(compra))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Compra createCompra(@RequestBody Compra compra) {
        return compraService.save(compra);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Compra> updateCompra(@PathVariable Long id, @RequestBody Compra compraDetails) {
        return compraService.findById(id)
                .map(compra -> {
                    compra.setNumeroPedido(compraDetails.getNumeroPedido());
                    compra.setValorTotal(compraDetails.getValorTotal());
                    compra.setCliente(compraDetails.getCliente());
                    compra.setProdutos(compraDetails.getProdutos());
                    Compra updatedCompra = compraService.save(compra);
                    return ResponseEntity.ok().body(updatedCompra);
                }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCompra(@PathVariable Long id) {
        return compraService.findById(id)
                .map(compra -> {
                    compraService.deleteById(id);
                    return ResponseEntity.ok().<Void>build();
                }).orElse(ResponseEntity.notFound().build());
    }
}

