package com.spring.wallet.service;

import com.spring.wallet.domain.model.Conta;
import com.spring.wallet.domain.model.Historico;
import com.spring.wallet.dto.ContaDTO;
import com.spring.wallet.dto.HistoricoDTO;
import com.spring.wallet.dto.PessoaDTO;
import com.spring.wallet.dto.TipoEnum;
import com.spring.wallet.repository.ContaRepository;
import com.spring.wallet.repository.HistoricoRepository;

public class OperacaoService {

    private ContaRepository contaRepository;
    private HistoricoRepository historicoRepository;

    public HistoricoDTO depositar(Double valor, PessoaDTO pessoaDTO) {
        Conta conta = contaRepository.findByCpfCnpj(pessoaDTO.getCpfCnpj());
        if (conta != null) {
            conta.setSaldo(conta.getSaldo() + valor);
            contaRepository.save(conta);

            Historico historico = new Historico();
            historico.setTipo(TipoEnum.DEPOSITO.name());
            historico.setDescricao("Depósito de R$ " + valor);
            historico.setValor(valor);

            Historico savedHistorico = historicoRepository.save(historico);

            return HistoricoDTO.mapToDTO(savedHistorico);
        }

        return null;
    }

    public HistoricoDTO sacar(Double valor, PessoaDTO pessoaDTO){
        Conta conta = contaRepository.findByCpfCnpj(pessoaDTO.getCpfCnpj());
        if (conta != null && conta.getSaldo() >= valor) {
            conta.setSaldo(conta.getSaldo() - valor);
            contaRepository.save(conta);

            Historico historico = new Historico();
            historico.setTipo(TipoEnum.SACAR.name());
            historico.setDescricao("Saque de R$ " + valor);
            historico.setValor(valor);

            Historico savedHistorico = historicoRepository.save(historico);

            return HistoricoDTO.mapToDTO(savedHistorico);
        }

        return null;
    }


    public HistoricoDTO transferir(ContaDTO contaDestinoDTO, PessoaDTO pessoaDTO, Double valor) {
        Conta contaOrigem = contaRepository.findByCpfCnpj(pessoaDTO.getCpfCnpj());
        Conta contaDestino = contaRepository.findConta(contaDestinoDTO.getChave());

        if (contaOrigem != null && contaDestino != null && contaOrigem.getSaldo() >= valor) {
            // Realiza a transferência
            contaOrigem.setSaldo(contaOrigem.getSaldo() - valor);
            contaDestino.setSaldo(contaDestino.getSaldo() + valor);

            // Salva as alterações nas contas
            contaRepository.save(contaOrigem);
            contaRepository.save(contaDestino);

            // Cria um histórico para a transferência
            Historico historico = new Historico();
            historico.setTipo(TipoEnum.TRANSFERENCIA.name());
            historico.setDescricao("Transferência de R$ " + valor + " para " + contaDestinoDTO.getChave());
            historico.setValor(valor);
            
            Historico savedHistoricoDTO = historicoRepository.save(historico);

            return HistoricoDTO.mapToDTO(savedHistoricoDTO);
        }

        return null;
    }
}
