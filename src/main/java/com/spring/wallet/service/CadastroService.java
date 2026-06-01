package com.spring.wallet.service;

import com.spring.wallet.dto.ContaDTO;
import com.spring.wallet.dto.PessoaDTO;

public interface CadastroService {
    ContaDTO cadastrar(PessoaDTO pessoaDTO);
    ContaDTO atualizar(PessoaDTO pessoaDTO);
    Boolean deletar(String cpfCnpj);
}