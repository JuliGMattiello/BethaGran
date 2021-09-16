package com.betha.exemplo.exemplo.resource;

import com.betha.exemplo.exemplo.model.Cidade;
import com.betha.exemplo.exemplo.repoitory.CidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@RestController
@RequestMapping("/api/cidades")
public class CidadeController {

    @Autowired
    private CidadeRepository repository;

    @GetMapping
    public List<Cidade> getCidades(){
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Cidade getCidadesId(@PathVariable(value = "id") Long cidadeId) throws EntityNotFoundException {

        Cidade cidadeFind = repository.findById(cidadeId)
                .orElseThrow(() -> new EntityNotFoundException("País não encontrado com ID: " + cidadeId));

        return cidadeFind;
    }

    @PostMapping
    public Cidade create(@RequestBody Cidade cidade){
        return repository.save(cidade);
    }

    @PutMapping("/{id}")
    public Cidade update(@PathVariable(value = "id") Long cidadeId,
                       @RequestBody Cidade cidade) throws EntityNotFoundException {
        Cidade cidadeFind = repository.findById(cidadeId)
                .orElseThrow(() -> new EntityNotFoundException("Cidade não encontrada com ID: " + cidadeId));
        cidadeFind.setId(cidade.getId());
        cidadeFind.setNome(cidade.getNome());
        cidadeFind.setEstado(cidade.getEstado());
        cidadeFind.setIdh(cidade.getIdh());
        cidadeFind.setNome_prefeito(cidade.getNome_prefeito());

        return repository.save(cidadeFind);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable(value = "id") Long cidadeId) throws EntityNotFoundException{
        Cidade cidadeFind = repository.findById(cidadeId)
                .orElseThrow(() -> new EntityNotFoundException("Cidade não encontrada com ID: " + cidadeId));

        repository.delete(cidadeFind);
        return ResponseEntity.noContent().build();
    }

}
