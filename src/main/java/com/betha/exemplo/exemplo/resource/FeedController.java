package com.betha.exemplo.exemplo.resource;

import com.betha.exemplo.exemplo.model.Feed;
import com.betha.exemplo.exemplo.model.Pais;
import com.betha.exemplo.exemplo.repoitory.FeedRepository;
import com.betha.exemplo.exemplo.repoitory.PaisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@RestController
@RequestMapping("/api/feeds")
public class FeedController {

    @Autowired
    private FeedRepository repository;

    @GetMapping
    public List<Feed> getFeed(){
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Feed getFeedId(@PathVariable(value = "id") Long feedId) throws EntityNotFoundException {

        Feed feedFind = repository.findById(feedId)
                .orElseThrow(() -> new EntityNotFoundException("Feed não encontrado com ID: " + feedId));

        return feedFind;
    }

    @PostMapping
    public Feed create(@RequestBody Feed feed){
        return repository.save(feed);
    }

    @PutMapping("/{id}")
    public Feed update(@PathVariable(value = "id") Long feedId,
                       @RequestBody Feed feed) throws EntityNotFoundException {
        Feed feedFind = repository.findById(feedId)
                .orElseThrow(() -> new EntityNotFoundException("Feed não encontrado com ID: " + feedId));
        feedFind.setId(feed.getId());
        feedFind.setContaUsuario(feed.getContaUsuario());
        feedFind.setTipoPublicacao(feed.getTipoPublicacao());
        feedFind.setLinkPublicacaoS3(feed.getLinkPublicacaoS3());
        feedFind.setDataPublicacao(feed.getDataPublicacao());
        feedFind.setComentarios(feed.getComentarios());
        feedFind.setCurtidas(feed.getCurtidas());
        feedFind.setLocalizacaoPostagem(feed.getLocalizacaoPostagem());

        return repository.save(feedFind);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable(value = "id") Long feedId) throws EntityNotFoundException{
        Feed feedFind = repository.findById(feedId)
                .orElseThrow(() -> new EntityNotFoundException("Feed não encontrado com ID: " + feedId));

        repository.delete(feedFind);
        return ResponseEntity.noContent().build();
    }


}
