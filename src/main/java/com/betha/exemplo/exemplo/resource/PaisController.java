package com.betha.exemplo.exemplo.resource;

import com.betha.exemplo.exemplo.model.Pais;
import com.betha.exemplo.exemplo.repoitory.PaisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/paises")
public class PaisController {

    @Autowired
    private PaisRepository repository;

    @GetMapping
    public List<PaisDTO> getPaises(){
        return repository.findAll().stream().map(p-> PaisDTO.toDTO(p)).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public PaisDTO getPaisesId(@PathVariable(value = "id") Long paisId) throws EntityNotFoundException {

        Pais paisFind = repository.findById(paisId)
                .orElseThrow(() -> new EntityNotFoundException("País não encontrado com ID: " + paisId));

        return PaisDTO.toDTO(paisFind);
    }

    @PostMapping
    public Pais create(@RequestBody Pais pais){
        return repository.save(pais);
    }

    @PutMapping("/{id}")
    public PaisDTO update(@PathVariable(value = "id") Long paisId,
                       @RequestBody Pais pais) throws EntityNotFoundException {
        Pais paisFind = repository.findById(paisId)
                .orElseThrow(() -> new EntityNotFoundException("País não encontrado com ID: " + paisId));
        paisFind.setId(pais.getId());
        paisFind.setNome(pais.getNome());
        paisFind.setPopulacao(pais.getPopulacao());

        return PaisDTO.toDTO(repository.save(paisFind));

    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable(value = "id") Long paisId) throws EntityNotFoundException{
        Pais paisFind = repository.findById(paisId)
                .orElseThrow(() -> new EntityNotFoundException("País não encontrado com ID: " + paisId));

        repository.delete(paisFind);
        return ResponseEntity.noContent().build();
    }

    

}
