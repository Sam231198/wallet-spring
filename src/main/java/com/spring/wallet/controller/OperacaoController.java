package com.spring.wallet.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.wallet.dto.ContaDTO;
import com.spring.wallet.dto.HistoricoDTO;
import com.spring.wallet.dto.PessoaDTO;
import com.spring.wallet.service.OperacaoService;

@RestController
@RequestMapping("/operacao")
public class OperacaoController {
    private OperacaoService operacaoService;

    public OperacaoController(OperacaoService operacaoService) {
        this.operacaoService = operacaoService;
    }
    
    @PostMapping("/depositar")
    public HistoricoDTO depositar(@RequestBody ContaDTO contaDTO) {
        PessoaDTO pessoaDTO = new PessoaDTO();
        pessoaDTO.setCpfCnpj(contaDTO.getChave());
        return operacaoService.depositar(contaDTO.getSaldo(), pessoaDTO);
    }

    @PostMapping("/sacar")
    public HistoricoDTO sacar(@RequestBody ContaDTO contaDTO) {
        PessoaDTO pessoaDTO = new PessoaDTO();
        pessoaDTO.setCpfCnpj(contaDTO.getChave());
        return operacaoService.sacar(contaDTO.getSaldo(), pessoaDTO);
    }

    @PostMapping("/transferir")
    public HistoricoDTO transferir(@RequestBody ContaDTO contaDTO, @RequestBody Double valor) {
        PessoaDTO pessoaDTO = new PessoaDTO();
        pessoaDTO.setCpfCnpj(contaDTO.getChave());

        ContaDTO contaDestinoDTO = new ContaDTO();
        contaDestinoDTO.setChave(contaDTO.getChave());
        
        return operacaoService.transferir(contaDestinoDTO, pessoaDTO, valor);
    }
}
