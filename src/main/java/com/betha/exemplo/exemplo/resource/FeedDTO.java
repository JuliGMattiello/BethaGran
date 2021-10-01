package com.betha.exemplo.exemplo.resource;

import com.betha.exemplo.exemplo.model.*;

import java.time.LocalDate;
import java.util.Set;

public class FeedDTO {

    private ContaUsuarioResumidoDTO contaUsuario;
    private TipoPublicacao tipoPublicacao;
    private String linkPublicacaoS3;
    private LocalDate dataPublicacao;
    private String textoPublicacao;
    private Set<Comentario> comentarios;
    private Set<Curtida> curtidas;
    private LocalizacaoPostagem localizacaoPostagem;

    public ContaUsuarioResumidoDTO getContaUsuario() {
        return contaUsuario;
    }

    public void setContaUsuario(ContaUsuarioResumidoDTO contaUsuario) {
        this.contaUsuario = contaUsuario;
    }

    public TipoPublicacao getTipoPublicacao() {
        return tipoPublicacao;
    }

    public void setTipoPublicacao(TipoPublicacao tipoPublicacao) {
        this.tipoPublicacao = tipoPublicacao;
    }

    public String getLinkPublicacaoS3() {
        return linkPublicacaoS3;
    }

    public void setLinkPublicacaoS3(String linkPublicacaoS3) {
        this.linkPublicacaoS3 = linkPublicacaoS3;
    }

    public LocalDate getDataPublicacao() {
        return dataPublicacao;
    }

    public void setDataPublicacao(LocalDate dataPublicacao) {
        this.dataPublicacao = dataPublicacao;
    }

    public String getTextoPublicacao() {
        return textoPublicacao;
    }

    public void setTextoPublicacao(String textoPublicacao) {
        this.textoPublicacao = textoPublicacao;
    }

    public Set<Comentario> getComentarios() {
        return comentarios;
    }

    public void setComentarios(Set<Comentario> comentarios) {
        this.comentarios = comentarios;
    }

    public Set<Curtida> getCurtidas() {
        return curtidas;
    }

    public void setCurtidas(Set<Curtida> curtidas) {
        this.curtidas = curtidas;
    }

    public LocalizacaoPostagem getLocalizacaoPostagem() {
        return localizacaoPostagem;
    }

    public void setLocalizacaoPostagem(LocalizacaoPostagem localizacaoPostagem) {
        this.localizacaoPostagem = localizacaoPostagem;
    }

    public static FeedDTO toDTO(Feed feed) {
        FeedDTO dto = new FeedDTO();
        dto.setContaUsuario(ContaUsuarioResumidoDTO.toDTO(feed.getContaUsuario()));
        dto.setTipoPublicacao(feed.getTipoPublicacao());
        dto.setComentarios(feed.getComentarios());
        dto.setDataPublicacao(feed.getDataPublicacao());
        dto.setLinkPublicacaoS3(feed.getLinkPublicacaoS3());
        dto.setLocalizacaoPostagem(feed.getLocalizacaoPostagem());
        dto.setCurtidas(feed.getCurtidas());
        dto.setTextoPublicacao(feed.getTextoPublicacao());
        return dto;
    }

    public static Feed fromDTO(FeedDTO dto) {
        Feed entity = new Feed();
        entity.setTipoPublicacao(dto.getTipoPublicacao());
        entity.setComentarios(dto.getComentarios());
        entity.setDataPublicacao(dto.getDataPublicacao());
        entity.setLinkPublicacaoS3(dto.getLinkPublicacaoS3());
        entity.setLocalizacaoPostagem(dto.getLocalizacaoPostagem());
        entity.setCurtidas(dto.getCurtidas());
        entity.setTextoPublicacao(dto.getTextoPublicacao());
        return entity;
    }

}
