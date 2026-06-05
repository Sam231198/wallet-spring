package com.spring.wallet.dto;

import com.spring.wallet.domain.model.Historico;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

@Getter
@Setter
public class HistoricoDTO {
    private Double valor;
    private String descricao;

    @DateTimeFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    private String data;
    
    @NotNull(message = "O tipo do histórico é obrigatório")
    private TipoEnum tipo;

    static public HistoricoDTO mapToDTO(Historico historico) {
        HistoricoDTO historicoDTO = new HistoricoDTO();
        historicoDTO.setValor(historico.getValor());
        historicoDTO.setDescricao(historico.getDescricao());
        historicoDTO.setData(historico.getData());
        historicoDTO.setTipo(TipoEnum.valueOf(historico.getTipo()));
        return historicoDTO;
    }
}