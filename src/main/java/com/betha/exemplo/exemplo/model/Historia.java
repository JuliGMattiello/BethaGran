package com.betha.exemplo.exemplo.model;

import com.betha.exemplo.exemplo.enterprise.AbstractEntity;
import com.betha.exemplo.exemplo.enterprise.IPublicavel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Transient;
import java.time.LocalDate;
import java.util.Set;

@Entity
public class Historia extends AbstractEntity implements IPublicavel {

    @Column(name= "CONTA_USUARIO")
    private ContaUsuario contaUsuario;
    @Column(name= "TIPO_PUBLIC")
    private TipoPublicacao tipoPublicacao;
    @Column(name= "LINK_PUBLICS3")
    private String linkPublicacaoS3;
    @Column(name= "DATA_PUBLIC")
    private LocalDate dataPublicacao;
    @Transient
    private Set<Curtida> curtidas;
    @Column(name= "LOCAL_POST")
    private LocalizacaoPostagem localizacaoPostagem;
    @Transient
    private Set<Comentario> comentarios;

    public ContaUsuario getContaUsuario() {
        return contaUsuario;
    }

    public void setContaUsuario(ContaUsuario contaUsuario) {
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

    @Override
    public ContaUsuario getUsuarioPublicou() {
        return getContaUsuario();
    }

    @Override
    public Set<Comentario> getComentarios() {
        return comentarios;
    }
}
