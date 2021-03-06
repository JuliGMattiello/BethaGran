package com.betha.exemplo.exemplo.enterprise;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.math.BigInteger;

@MappedSuperclass
public abstract class AbstractEntity {

    @Id //Chave primária da entidade
    @GeneratedValue(strategy = GenerationType.AUTO) // Faz o autoincremento do Id
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
