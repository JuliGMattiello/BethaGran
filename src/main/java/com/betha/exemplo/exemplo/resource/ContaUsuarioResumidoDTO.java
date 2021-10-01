package com.betha.exemplo.exemplo.resource;

import com.betha.exemplo.exemplo.model.Cidade;
import com.betha.exemplo.exemplo.model.ContaUsuario;

import java.time.LocalDate;

public class ContaUsuarioResumidoDTO {
    private String nomeConta;
    private String nomeCompleto;
    private LocalDate dataNascimento;
    private LocalDate daraCriacaoConta;
    private String biografia;
    private String link;
    private Cidade cidade;

    public String getNomeConta() {
        return nomeConta;
    }

    public void setNomeConta(String nomeConta) {
        this.nomeConta = nomeConta;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public LocalDate getDaraCriacaoConta() {
        return daraCriacaoConta;
    }

    public void setDaraCriacaoConta(LocalDate daraCriacaoConta) {
        this.daraCriacaoConta = daraCriacaoConta;
    }

    public String getBiografia() {
        return biografia;
    }

    public void setBiografia(String biografia) {
        this.biografia = biografia;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

    public static ContaUsuarioResumidoDTO toDTO(ContaUsuario contaUsuario) {
        ContaUsuarioResumidoDTO dto = new ContaUsuarioResumidoDTO();
        dto.setNomeCompleto(contaUsuario.getNomeCompleto());
        dto.setNomeConta(contaUsuario.getNomeConta());
        dto.setBiografia(contaUsuario.getBiografia());
        dto.setDaraCriacaoConta(contaUsuario.getDaraCriacaoConta());
        dto.setLink(contaUsuario.getLink());
        dto.setCidade(contaUsuario.getCidade());
        return dto;
    }

    public static ContaUsuario fromDTO(ContaUsuarioDTO contaUsuarioDto) {
        ContaUsuario entity = new ContaUsuario();
        entity.setNomeCompleto(contaUsuarioDto.getNomeCompleto());
        entity.setNomeConta(contaUsuarioDto.getNomeConta());
        entity.setBiografia(contaUsuarioDto.getBiografia());
        entity.setDaraCriacaoConta(contaUsuarioDto.getDaraCriacaoConta());
        entity.setLink(contaUsuarioDto.getLink());
        entity.setCidade(contaUsuarioDto.getCidade());
        return entity;
    }

}
