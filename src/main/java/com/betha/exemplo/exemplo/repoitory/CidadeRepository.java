package com.betha.exemplo.exemplo.repoitory;

import com.betha.exemplo.exemplo.model.Cidade;
import com.betha.exemplo.exemplo.model.Pais;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CidadeRepository extends JpaRepository<Cidade, Long> {

}