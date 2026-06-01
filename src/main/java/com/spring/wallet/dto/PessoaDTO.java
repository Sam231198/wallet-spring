package com.spring.wallet.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;

@Getter
public class PessoaDTO {
    private String nome;

    @Email(message = "Email deve ser válido")
    private String email;
    
    @Pattern(regexp = "\\d{11}|\\d{14}", message = "CPF/CNPJ deve conter 11 ou 14 dígitos numéricos")
    private String cpfCnpj;

    public PessoaDTO(String nome, String cpfCnpj, String email) {
        this.nome = nome;
        this.cpfCnpj = cpfCnpj;
        this.email = email;
    }
}
