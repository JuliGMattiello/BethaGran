package com.betha.exemplo.exemplo.model;

import com.betha.exemplo.exemplo.enterprise.AbstractEntity;
import com.betha.exemplo.exemplo.enterprise.IPublicavel;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Curtida extends AbstractEntity {

    @Column(name= "CONTA_USUARIO")
    private ContaUsuario contaUsuario;
    @Column(name= "PUBLIC")
    private IPublicavel publicacao;

    public ContaUsuario getContaUsuario() {
        return contaUsuario;
    }

    public void setContaUsuario(ContaUsuario contaUsuario) {
        this.contaUsuario = contaUsuario;
    }

    public IPublicavel getPublicacao() {
        return publicacao;
    }

    public void setPublicacao(IPublicavel publicacao) {
        this.publicacao = publicacao;
    }

    @Override
    public String toString() {
        return "Curtida{" +
                "contaUsuario=" + contaUsuario +
                ", publicacao=" + publicacao +
                '}';
    }
}
