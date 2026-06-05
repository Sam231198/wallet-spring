package com.spring.wallet.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.wallet.dto.ContaDTO;
import com.spring.wallet.dto.PessoaDTO;
import com.spring.wallet.service.CadastroService;

@RestController
@RequestMapping("/conta")
public class ContaController {
    CadastroService cadastroService;

    public ContaController(CadastroService cadastroService) {
        this.cadastroService = cadastroService;
    }

    @PostMapping("/")
    public ContaDTO cadastroConta(@RequestBody PessoaDTO pessoaDTO) {
        return cadastroService.cadastrar(pessoaDTO);

    }

    @PutMapping("/")
    public ContaDTO atualizarConta(@PathVariable String cpfCnpj, @RequestBody PessoaDTO pessoaDTO) {
        return cadastroService.atualizar(pessoaDTO);
    }

    @DeleteMapping("/{cpfCnpj}")
    public Boolean deletarConta(@PathVariable String cpfCnpj) {
        return cadastroService.deletar(cpfCnpj);
    }
}
