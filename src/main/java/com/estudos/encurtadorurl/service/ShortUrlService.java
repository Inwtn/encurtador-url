package com.estudos.encurtadorurl.service;

import com.estudos.encurtadorurl.model.ShortUrl;
import com.estudos.encurtadorurl.repository.ShortUrlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

@Service
public class ShortUrlService {

    @Autowired
    private ShortUrlRepository repository;

    public ShortUrl createShortUrl(String originalUrl, int expirationInMinutes) {
        String shortCode = UUID.randomUUID().toString().substring(0, 8);
        LocalDateTime expiration = LocalDateTime.now().plusMinutes(expirationInMinutes);

        ShortUrl shortUrl = new ShortUrl(originalUrl, shortCode, expiration);
        return repository.save(shortUrl);
    }

    public Optional<ShortUrl> getOriginalUrl(String shortCode) {
        Optional<ShortUrl> optional = repository.findByShortCode(shortCode);
        if (optional.isPresent() && optional.get().getExpiration().isAfter(LocalDateTime.now())) {
            return optional;
        } else {
            return Optional.empty();
        }
    }
}
