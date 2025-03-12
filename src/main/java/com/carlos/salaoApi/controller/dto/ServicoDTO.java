package com.carlos.salaoApi.controller.dto;

import com.carlos.salaoApi.model.Servico;

import java.time.LocalTime;

public record ServicoDTO(String nome, String imgUrl, double valor, LocalTime horaDemandada, int porcentagemColab) {

    public Servico mapearServivo(){
        Servico servico = new Servico();
        servico.setNome(this.nome);
        servico.setValor(this.valor);
        servico.setImagemUrl(this.imgUrl);
        servico.setHoraDemorada(this.horaDemandada);
        servico.setPorcentagemFuncionario(this.porcentagemColab);
        return servico;
    }
}
