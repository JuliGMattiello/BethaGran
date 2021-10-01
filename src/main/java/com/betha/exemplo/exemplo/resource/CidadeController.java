package com.betha.exemplo.exemplo.resource;

import com.betha.exemplo.exemplo.model.Cidade;
import com.betha.exemplo.exemplo.repository.CidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/cidades")
public class CidadeController {

    @Autowired
    private CidadeRepository repository;

    @GetMapping
    public List<CidadeDTO> getCidades(){
        return repository.findAll().stream().map(p-> CidadeDTO.toDTO(p)).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public CidadeDTO getCidadesId(@PathVariable(value = "id") Long cidadeId) throws EntityNotFoundException {

        Cidade cidadeFind = repository.findById(cidadeId)
                .orElseThrow(() -> new EntityNotFoundException("País não encontrado com ID: " + cidadeId));

        return CidadeDTO.toDTO(cidadeFind);
    }

    @PostMapping
    public CidadeDTO create(@RequestBody Cidade cidade){
        return CidadeDTO.toDTO(repository.save(cidade));
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
