package com.betha.exemplo.exemplo.resource;

        import com.betha.exemplo.exemplo.model.Estado;
        import com.betha.exemplo.exemplo.repoitory.EstadoRepository;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.http.ResponseEntity;
        import org.springframework.web.bind.annotation.*;

        import javax.persistence.EntityNotFoundException;
        import java.util.List;
        import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/estados")
public class EstadoController {

    @Autowired
    private EstadoRepository repository;

    @GetMapping
    public List<EstadoDTO> getEstado(){
        return repository.findAll().stream().map(p-> EstadoDTO.toDTO(p)).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public EstadoDTO getEstadoId(@PathVariable(value = "id") Long estadoId) throws EntityNotFoundException {

        Estado estadoFind = repository.findById(estadoId)
                .orElseThrow(() -> new EntityNotFoundException("Estado não encontrado com ID: " + estadoId));

        return EstadoDTO.toDTO(estadoFind);
    }

    @PostMapping
    public EstadoDTO create(@RequestBody Estado estado){
        return EstadoDTO.toDTO(repository.save(estado));
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

