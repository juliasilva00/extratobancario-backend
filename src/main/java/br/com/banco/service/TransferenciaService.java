package br.com.banco.service;

import br.com.banco.model.transferencia.Transferencia;
import br.com.banco.repository.TransferenciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import static com.google.common.base.Strings.isNullOrEmpty;

@Service
public class TransferenciaService {
    @Autowired
    private TransferenciaRepository transferenciaRepository;


    public List<Transferencia> getTranferenciaByNumeroConta( Long numeroConta){
        return transferenciaRepository.findByContaNumeroConta(numeroConta);
    }
    public List<Transferencia> getTransferenciaByCondition(
            final LocalDateTime dataInicial,
            final LocalDateTime dataFinal,
            final String nomeOperadorTransacao
    ) {
        if (dataInicial != null && dataFinal != null && !isNullOrEmpty(nomeOperadorTransacao)) {
            return transferenciaRepository.findByDataTransferenciaBetweenAndNomeOperadorTransacao(
                    dataInicial,
                    dataFinal,
                    nomeOperadorTransacao
            );
        } else if (dataInicial != null && dataFinal != null) {
            return transferenciaRepository.findByDataTransferenciaBetween(dataInicial, dataFinal);
        } else if (!isNullOrEmpty(nomeOperadorTransacao)) {
            return transferenciaRepository.findByNomeOperadorTransacao(nomeOperadorTransacao);
        } else {
            return transferenciaRepository.findAll();
        }
    }

}
