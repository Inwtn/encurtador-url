package com.estudos.encurtadorurl.repository;

import com.estudos.encurtadorurl.model.ShortUrl;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface ShortUrlRepository extends MongoRepository<ShortUrl, String> {
    Optional<ShortUrl> findByShortCode(String shortCode);
}
