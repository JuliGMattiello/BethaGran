package com.betha.exemplo.exemplo.model;

import java.util.Set;

import com.betha.exemplo.exemplo.enterprise.AbstractEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Transient;

@Entity
public class Usuario extends AbstractEntity {

    @Column(name= "LOGIN")
    private String login;
    @Column(name= "PASSWORD")
    private String password;
    @Column(name= "EMAIL_RECUP")
    private String emailRecuperacao;
    @Transient
    private Set<ContaUsuario> contasAssociadas;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmailRecuperacao() {
        return emailRecuperacao;
    }

    public void setEmailRecuperacao(String emailRecuperacao) {
        this.emailRecuperacao = emailRecuperacao;
    }

    public Set<ContaUsuario> getContasAssociadas() {
        return contasAssociadas;
    }

    public void setContasAssociadas(Set<ContaUsuario> contasAssociadas) {
        this.contasAssociadas = contasAssociadas;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "login='" + login + '\'' +
                ", contasAssociadas=" + contasAssociadas +
                '}';
    }
}
