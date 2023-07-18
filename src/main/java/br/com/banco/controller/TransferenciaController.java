package br.com.banco.controller;

import br.com.banco.model.transferencia.Transferencia;
import br.com.banco.service.TransferenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping(value = "/transferencia")
@CrossOrigin({"*"})
public class TransferenciaController {
    @Autowired
    private TransferenciaService transferenciaService;

    @GetMapping
    public ResponseEntity<List<Transferencia>> getTransferencia(
            @RequestHeader(name = "dataInicial", required = false) final LocalDateTime dataInicial,
            @RequestHeader(name = "dataFinal", required = false) final LocalDateTime dataFinal,
            @RequestHeader(name = "nomeOperadorTransacao", required = false) final String nomeOperadorTransacao) {

        return new ResponseEntity<>(transferenciaService.getTransferenciaByCondition(dataInicial, dataFinal, nomeOperadorTransacao), HttpStatus.OK);
    }

    @GetMapping("/{numeroConta}")
    public ResponseEntity<List<Transferencia>> getTransferenciaByNumeroConta(@PathVariable final Long numeroConta) {

        return new ResponseEntity<>(transferenciaService.getTranferenciaByNumeroConta(numeroConta), HttpStatus.OK);
    }





}
