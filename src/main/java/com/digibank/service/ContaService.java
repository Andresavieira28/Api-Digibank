package com.digibank.service;

import com.digibank.model.Conta;
import com.digibank.repository.ContaRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Optional;

@Service
public class ContaService {

    private final ContaRepository repository;

    public ContaService(ContaRepository repository) {
        this.repository = repository;
    }

    public Conta criarConta(String titular) {
        Conta conta = new Conta();
        conta.setTitular(titular);
        conta.setSaldo(BigDecimal.ZERO);
        return repository.save(conta);
    }

    public Optional<Conta> consultarSaldo(Long id) {
        return repository.findById(id);
    }

    public Optional<Conta> depositar(Long id, BigDecimal valor) {
        return repository.findById(id).map(conta -> {
            conta.setSaldo(conta.getSaldo().add(valor));
            return repository.save(conta);
        });
    }

}
