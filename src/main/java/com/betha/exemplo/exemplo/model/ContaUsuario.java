package com.betha.exemplo.exemplo.model;

import com.betha.exemplo.exemplo.enterprise.AbstractEntity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.Set;

import static javax.persistence.CascadeType.ALL;

@Entity
public class ContaUsuario extends AbstractEntity {

    @NotNull(message = "O apelido não pode ser nulo!")
    @Size(max = 25)
    @Column(name= "APELIDO")
    private String nomeConta;

    @NotNull(message = "O nome não pode ser nulo!")
    @Size(max = 200, message = "O nome deve ter no máximo {max} caracteres")
    @Column(name= "NOME")
    private String nomeCompleto;

    @Column(name= "DATA_NASC")
    private LocalDate dataNascimento;

    @NotNull(message = "A data de criação não pode ser nula!")
    @Column(name= "DATA_CRIACAO")
    private LocalDate daraCriacaoConta;

    @NotNull(message = "A biografia não pode ser nula!")
    @Size(max = 500, message = "O nome deve ter no máximo {max} caracteres")
    @Column(name= "BIO")
    private String biografia;

    @NotNull(message = "O link não pode ser nulo!")
    @Size(max = 100, message = "O link deve ter no máximo {max} caracteres")
    @Column(name= "LINK")
    private String link;

    @Column(name= "SEXO")
    private Sexo sexo;

    @Column(name= "DOCUMENTO")
    private Documento documento;

    @Column(name= "ESCOLARIDADE")
    private Escolaridade escolaridade;

    @Column(name= "RACA")
    private Raca raca;

    @ManyToOne
    @JoinColumn(name = "I_CIDADES", referencedColumnName = "ID")
    private Cidade cidade;
    @OneToMany(cascade = ALL, mappedBy = "contaUsuario")
    private Set<Feed> publicacoes;
    @Transient
    private Set<Historia> historias;
    @Transient
    private Set<ContaUsuario> seguidores;
    @Transient
    private Set<ContaUsuario> seguindo;

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

    public Set<Feed> getPublicacoes() {
        return publicacoes;
    }

    public void setPublicacoes(Set<Feed> publicacoes) {
        this.publicacoes = publicacoes;
    }

    public Set<Historia> getHistorias() {
        return historias;
    }

    public void setHistorias(Set<Historia> historias) {
        this.historias = historias;
    }

    public Set<ContaUsuario> getSeguidores() {
        return seguidores;
    }

    public void setSeguidores(Set<ContaUsuario> seguidores) {
        this.seguidores = seguidores;
    }

    public Set<ContaUsuario> getSeguindo() {
        return seguindo;
    }

    public void setSeguindo(Set<ContaUsuario> seguindo) {
        this.seguindo = seguindo;
    }

    public Sexo getSexo() {
        return sexo;
    }

    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }

    public Documento getDocumento() {
        return documento;
    }

    public void setDocumento(Documento documento) {
        this.documento = documento;
    }

    public Escolaridade getEscolaridade() {
        return escolaridade;
    }

    public void setEscolaridade(Escolaridade escolaridade) {
        this.escolaridade = escolaridade;
    }

    public Raca getRaca() {
        return raca;
    }

    public void setRaca(Raca raca) {
        this.raca = raca;
    }

    @Override
    public String toString() {
        return "ContaUsuario{" +
                "nomeConta='" + nomeConta + '\'' +
                ", nomeCompleto='" + nomeCompleto + '\'' +
                '}';
    }
}
