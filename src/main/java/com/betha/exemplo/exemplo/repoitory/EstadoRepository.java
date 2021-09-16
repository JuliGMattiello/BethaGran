package com.betha.exemplo.exemplo.repoitory;

import com.betha.exemplo.exemplo.model.Estado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstadoRepository extends JpaRepository<Estado, Long>{


}
