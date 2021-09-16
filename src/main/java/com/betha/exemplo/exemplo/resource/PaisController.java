package com.betha.exemplo.exemplo.resource;

import com.betha.exemplo.exemplo.model.Pais;
import com.betha.exemplo.exemplo.repoitory.PaisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@RestController
@RequestMapping("/api/paises")
public class PaisController {

    @Autowired
    private PaisRepository repository;

    @GetMapping
    public List<Pais> getPaises(){
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Pais getPaisesId(@PathVariable(value = "id") Long paisId) throws EntityNotFoundException {

        Pais paisFind = repository.findById(paisId)
                .orElseThrow(() -> new EntityNotFoundException("País não encontrado com ID: " + paisId));

        return paisFind;
    }

    @PostMapping
    public Pais create(@RequestBody Pais pais){
        return repository.save(pais);
    }

    @PutMapping("/{id}")
    public Pais update(@PathVariable(value = "id") Long paisId,
                       @RequestBody Pais pais) throws EntityNotFoundException {
        Pais paisFind = repository.findById(paisId)
                .orElseThrow(() -> new EntityNotFoundException("País não encontrado com ID: " + paisId));
        paisFind.setId(pais.getId());
        paisFind.setNome(pais.getNome());
        paisFind.setPopulacao(pais.getPopulacao());

        return repository.save(paisFind);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable(value = "id") Long paisId) throws EntityNotFoundException{
        Pais paisFind = repository.findById(paisId)
                .orElseThrow(() -> new EntityNotFoundException("País não encontrado com ID: " + paisId));

        repository.delete(paisFind);
        return ResponseEntity.noContent().build();
    }

    

}
