package com.digibank.controller;

import com.digibank.model.Conta;
import com.digibank.service.ContaService;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.Optional;

@RestController
@RequestMapping("/contas")
public class ContaController {

    private final ContaService service;

    public ContaController(ContaService service) {
        this.service = service;
    }

    @PostMapping
    public Conta criarConta(@RequestParam String titular) {
        return service.criarConta(titular);
    }

    @GetMapping("/{id}/saldo")
    public Optional<Conta> consultarSaldo(@PathVariable Long id) {
        return service.consultarSaldo(id);
    }

    @PutMapping("/{id}/deposito")
    public Optional<Conta> depositar(@PathVariable Long id, @RequestParam BigDecimal valor) {
        return service.depositar(id, valor);
    }

}
