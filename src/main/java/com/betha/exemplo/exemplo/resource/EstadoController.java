package com.betha.exemplo.exemplo.resource;

        import com.betha.exemplo.exemplo.model.Estado;
        import com.betha.exemplo.exemplo.model.Pais;
        import com.betha.exemplo.exemplo.repoitory.EstadoRepository;
        import com.betha.exemplo.exemplo.repoitory.PaisRepository;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.http.ResponseEntity;
        import org.springframework.web.bind.annotation.*;

        import javax.persistence.EntityNotFoundException;
        import java.util.List;

@RestController
@RequestMapping("/api/estados")
public class EstadoController {

    @Autowired
    private EstadoRepository repository;

    @GetMapping
    public List<Estado> getEstado(){
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Estado getEstadoId(@PathVariable(value = "id") Long estadoId) throws EntityNotFoundException {

        Estado estadoFind = repository.findById(estadoId)
                .orElseThrow(() -> new EntityNotFoundException("Estado não encontrado com ID: " + estadoId));

        return estadoFind;
    }

    @PostMapping
    public Estado create(@RequestBody Estado estado){
        return repository.save(estado);
    }

    @PutMapping("/{id}")
    public Estado update(@PathVariable(value = "id") Long estadoId,
                       @RequestBody Estado estado) throws EntityNotFoundException {
        Estado estadoFind = repository.findById(estadoId)
                .orElseThrow(() -> new EntityNotFoundException("Estado não encontrado com ID: " + estadoId));
        estadoFind.setId(estado.getId());
        estadoFind.setNome(estado.getNome());
        estadoFind.setPopulacao(estado.getPopulacao());

        return repository.save(estadoFind);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable(value = "id") Long estadoId) throws EntityNotFoundException{
        Estado estadoFind = repository.findById(estadoId)
                .orElseThrow(() -> new EntityNotFoundException("Estado não encontrado com ID: " + estadoId));

        repository.delete(estadoFind);
        return ResponseEntity.noContent().build();
    }



}

