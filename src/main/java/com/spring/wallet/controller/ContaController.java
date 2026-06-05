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
import com.spring.wallet.service.OperacaoService;

@RestController
@RequestMapping("/conta")
public class ContaController {
    OperacaoService operacaoService;
    CadastroService cadastroService;

    public ContaController(OperacaoService operacaoService, CadastroService cadastroService) {
        this.operacaoService = operacaoService;
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

    // @PostMapping("/depositar")
    // public ContaDTO depositar(@RequestBody ContaDTO contaDTO) {
    //     return operacaoService.depositar(contaDTO.getSaldo());
    // }

    // @PostMapping("/sacar")
    // public ContaDTO sacar(@RequestBody ContaDTO contaDTO) {
    //     return operacaoService.sacar(contaDTO.getSaldo());
    // }

    // @PostMapping("/transferir")
    // public ContaDTO transferir(@RequestBody ContaDTO contaDTO) {
    //     return operacaoService.transferir(contaDTO.getChave(), contaDTO.getSaldo());
    // }
}
