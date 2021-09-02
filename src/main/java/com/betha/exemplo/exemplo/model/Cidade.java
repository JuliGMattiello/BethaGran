package com.betha.exemplo.exemplo.model;

import com.betha.exemplo.exemplo.enterprise.AbstractRegion;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Cidade extends AbstractRegion {
    @ManyToOne
    @JoinColumn(name = "I_ESTADOS", referencedColumnName = "ID")
    private Estado estado;
    @Column(name= "IDH")
    private Double idh;
    @Column(name= "NOME_PREF")
    private String nome_prefeito;


    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public Double getIdh() {
        return idh;
    }

    public void setIdh(Double idh) {
        this.idh = idh;
    }

    public String getNome_prefeito() {
        return nome_prefeito;
    }

    public void setNome_prefeito(String nome_prefeito) {
        this.nome_prefeito = nome_prefeito;
    }
}
