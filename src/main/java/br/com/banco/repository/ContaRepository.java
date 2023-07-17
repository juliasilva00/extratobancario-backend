package br.com.banco.repository;

import br.com.banco.model.conta.Conta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContaRepository extends JpaRepository<Conta, Long> {
     Conta findByNumeroConta (final int numeroConta);
}
