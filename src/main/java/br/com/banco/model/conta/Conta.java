package br.com.banco.model.conta;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "conta")
public class Conta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_conta")
    private Long id;

    @Column(name = "numero_conta")
    private Long numeroConta;

    @Column(name = "nome_responsavel")
    private String nomeResponsavel;

    public Conta() {
    }

    public Conta(Long id, Long numeroConta, String nomeResponsavel) {
        this.id = id;
        this.numeroConta = numeroConta;
        this.nomeResponsavel = nomeResponsavel;
    }
}
