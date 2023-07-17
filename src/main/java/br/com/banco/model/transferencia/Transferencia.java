package br.com.banco.model.transferencia;

import br.com.banco.model.conta.Conta;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "transferencia")
public class Transferencia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    double valor;
    String tipo;

    @Column(name = "nome_operador_transacao")
    String nomeOperadorTransacao;

    @Column(name = "data_transferencia")
    LocalDateTime  dataTransferencia;

    @ManyToOne
    @JoinColumn(name = "conta_id")
    private Conta conta;

    public Transferencia() {
    }

    public Transferencia(Long id, double valor, String tipo, String nomeOperadorTransacao, LocalDateTime dataTransferencia, Conta conta) {
        this.id = id;
        this.valor = valor;
        this.tipo = tipo;
        this.nomeOperadorTransacao = nomeOperadorTransacao;
        this.dataTransferencia = dataTransferencia;
        this.conta = conta;
    }
}
