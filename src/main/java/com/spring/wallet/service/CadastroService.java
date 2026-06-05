package com.spring.wallet.service;

import org.springframework.stereotype.Service;

import com.spring.wallet.domain.model.Conta;
import com.spring.wallet.domain.model.Pessoa;
import com.spring.wallet.dto.ContaDTO;
import com.spring.wallet.dto.PessoaDTO;
import com.spring.wallet.repository.ContaRepository;
import com.spring.wallet.repository.PessoaRepository;

@Service
public class CadastroService {

    private PessoaRepository pessoaRepository;
    private ContaRepository contaRepository;

    public ContaDTO cadastrar(PessoaDTO pessoaDTO) {
        Pessoa pessoa = new Pessoa(pessoaDTO.getNome(), pessoaDTO.getCpfCnpj(), pessoaDTO.getEmail());
        pessoaRepository.save(pessoa);

        Conta conta = new Conta();
        conta.setChave(null);
        conta.setSaldo(0.0);
        conta.setPessoa(pessoa);

        contaRepository.save(conta);

        ContaDTO contaDTO = new ContaDTO();
        contaDTO.setSaldo(conta.getSaldo());
        contaDTO.setChave(conta.getChave());

        return contaDTO;
    }

    public ContaDTO atualizar(PessoaDTO pessoaDTO) {
        Pessoa pessoa = pessoaRepository.findPessoa(pessoaDTO.getCpfCnpj());
        pessoaRepository.save(pessoa);

        Conta conta = contaRepository.findConta(pessoaDTO.getCpfCnpj());
        contaRepository.save(conta);

        ContaDTO contaDTO = new ContaDTO();
        contaDTO.setSaldo(conta.getSaldo());
        contaDTO.setChave(conta.getChave());

        return contaDTO;
    }

    public Boolean deletar(String cpfCnpj) {
        Pessoa pessoa = pessoaRepository.findPessoa(cpfCnpj);

        if (pessoa != null) {
            pessoaRepository.delete(pessoa);
            Conta conta = contaRepository.findConta(cpfCnpj);
            contaRepository.delete(conta);
            return true;
        }

        return false;
    }
}