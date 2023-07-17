package br.com.banco.repository;

import br.com.banco.model.transferencia.Transferencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.List;

public interface TransferenciaRepository extends JpaRepository<Transferencia, Long> {
    List<Transferencia> findByContaNumeroConta(final Long numeroConta);


    List<Transferencia> findByNomeOperadorTransacao(String nomeOperadorTransacao);
    List<Transferencia> findByDataTransferenciaBetween(
            LocalDateTime dataInicial,
            LocalDateTime dataFinal
    );
    List<Transferencia> findByDataTransferenciaBetweenAndNomeOperadorTransacao(
            LocalDateTime dataInicial,
            LocalDateTime dataFinal,
            String nomeOperadorTransacao
    );



}
