package com.spring.wallet.dto;

@Getter
class HistoricoDTO {
    private Long valor;
    private String descricao;

    @dateTimeFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    private String data;
    
    @NotNull(message = "O tipo do histórico é obrigatório")
    private TipoEnum tipo;

    public HistoricoDTO(String tipo, String descricao, Long valor, String data) {
        this.tipo = tipo;
        this.descricao = descricao;
        this.valor = valor;
        this.data = data;
    }
}