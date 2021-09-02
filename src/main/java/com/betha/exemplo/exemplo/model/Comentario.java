package com.betha.exemplo.exemplo.model;

import com.betha.exemplo.exemplo.enterprise.AbstractEntity;
import com.betha.exemplo.exemplo.enterprise.IPublicavel;

import javax.naming.Name;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Transient;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
public class Comentario extends AbstractEntity {

    @Column(name= "DATA_HORA_COMENT")
    private LocalDateTime dataHoraComentario;
    @Column(name= "USUARIO_COMENT")
    private ContaUsuario usuarioComentou;
    @Column(name= "PUBLIC")
    private IPublicavel publicacao;
    @Column(name= "COMENT")
    private String comentario;
    @Transient
    private Set<Curtida> curtidas;

    public LocalDateTime getDataHoraComentario() {
        return dataHoraComentario;
    }

    public void setDataHoraComentario(LocalDateTime dataHoraComentario) {
        this.dataHoraComentario = dataHoraComentario;
    }

    public ContaUsuario getUsuarioComentou() {
        return usuarioComentou;
    }

    public void setUsuarioComentou(ContaUsuario usuarioComentou) {
        this.usuarioComentou = usuarioComentou;
    }

    public IPublicavel getPublicacao() {
        return publicacao;
    }

    public void setPublicacao(IPublicavel publicacao) {
        this.publicacao = publicacao;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public Set<Curtida> getCurtidas() {
        return curtidas;
    }

    public void setCurtidas(Set<Curtida> curtidas) {
        this.curtidas = curtidas;
    }

    @Override
    public String toString() {
        return "Comentario{" +
                "dataHoraComentario=" + dataHoraComentario +
                ", usuarioComentou=" + usuarioComentou +
                ", publicacao=" + publicacao +
                '}';
    }
}
