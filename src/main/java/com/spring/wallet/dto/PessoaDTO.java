package com.spring.wallet.dto;

import com.spring.wallet.domain.model.Pessoa;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PessoaDTO {
    private String nome;

    @Email(message = "Email deve ser válido")
    private String email;
    
    @Pattern(regexp = "\\d{11}|\\d{14}", message = "CPF/CNPJ deve conter 11 ou 14 dígitos numéricos")
    private String cpfCnpj;

        static public PessoaDTO mapToDTO(Pessoa pessoa) {
            PessoaDTO pessoaDTO = new PessoaDTO();
            pessoaDTO.setNome(pessoa.getNome());
            pessoaDTO.setEmail(pessoa.getEmail());
            pessoaDTO.setCpfCnpj(pessoa.getCpfCnpj());
            return pessoaDTO;
        }
}
