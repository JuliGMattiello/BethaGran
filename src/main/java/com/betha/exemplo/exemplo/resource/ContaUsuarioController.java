package com.betha.exemplo.exemplo.resource;

import com.betha.exemplo.exemplo.model.ContaUsuario;
import com.betha.exemplo.exemplo.repoitory.ContaUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@RestController
@RequestMapping("/api/contausuario")
public class ContaUsuarioController {

    @Autowired
    private ContaUsuarioRepository repository;

    @GetMapping
    public List<ContaUsuario> getContaUsuario(){
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public ContaUsuario getContaUsuarioId(@PathVariable(value = "id") Long contaUsuarioId) throws EntityNotFoundException {

        ContaUsuario contaUsuarioFind = repository.findById(contaUsuarioId)
                .orElseThrow(() -> new EntityNotFoundException("País não encontrado com ID: " + contaUsuarioId));

        return contaUsuarioFind;
    }

    @PostMapping
    public ContaUsuario create(@RequestBody ContaUsuario contaUsuario){
        return repository.save(contaUsuario);
    }

    @PutMapping("/{id}")
    public ContaUsuario update(@PathVariable(value = "id") Long contaUsuarioId,
                       @RequestBody ContaUsuario contaUsuario) throws EntityNotFoundException {
        ContaUsuario contaUsuarioFind = repository.findById(contaUsuarioId)
                .orElseThrow(() -> new EntityNotFoundException("Usuário não encontrado com ID: " + contaUsuarioId));
        contaUsuarioFind.setId(contaUsuario.getId());
        contaUsuarioFind.setNomeConta(contaUsuario.getNomeConta());
        contaUsuarioFind.setNomeCompleto(contaUsuario.getNomeCompleto());
        contaUsuarioFind.setDataNascimento(contaUsuario.getDataNascimento());
        contaUsuarioFind.setDaraCriacaoConta(contaUsuario.getDaraCriacaoConta());
        contaUsuarioFind.setBiografia(contaUsuario.getBiografia());
        contaUsuarioFind.setLink(contaUsuario.getLink());
        contaUsuarioFind.setCidade(contaUsuario.getCidade());
//        contaUsuarioFind.setPublicacoes(contaUsuario.getPublicacoes());
        contaUsuarioFind.setHistorias(contaUsuario.getHistorias());
        contaUsuarioFind.setSeguidores(contaUsuario.getSeguidores());
        contaUsuarioFind.setSeguindo(contaUsuario.getSeguindo());

        return repository.save(contaUsuarioFind);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable(value = "id") Long contaUsuarioId) throws EntityNotFoundException{
        ContaUsuario contaUsuarioFind = repository.findById(contaUsuarioId)
                .orElseThrow(() -> new EntityNotFoundException("Conta não encontrada com ID: " + contaUsuarioId));

        repository.delete(contaUsuarioFind);
        return ResponseEntity.noContent().build();
    }


}
