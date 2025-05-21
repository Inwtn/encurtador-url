package com.estudos.encurtadorurl.repository;

import com.estudos.encurtadorurl.model.ShortUrl;

// Importa o repositório base para MongoDB e a classe Optional
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.Optional;

/* Define a interface do repositório que herda de MongoRepository:
   ShortUrl: tipo da entidade.
   String: tipo do ID. */
public interface ShortUrlRepository extends MongoRepository<ShortUrl, String> {
// Método customizado para buscar uma URL encurtada pelo seu código.
    Optional<ShortUrl> findByShortCode(String shortCode);
}
