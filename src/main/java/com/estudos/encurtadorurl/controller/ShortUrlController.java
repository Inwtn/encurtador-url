package com.estudos.encurtadorurl.controller;

import com.estudos.encurtadorurl.model.ShortUrl;
import com.estudos.encurtadorurl.service.ShortUrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/urls")
public class ShortUrlController {

    @Autowired
    private ShortUrlService service;

    @PostMapping
    public ResponseEntity<ShortUrl> createShortUrl(@RequestBody Map<String, String> body) {
        String originalUrl = body.get("originalUrl");
        int expiration = Integer.parseInt(body.getOrDefault("expiration", "60")); // padrão: 60 minutos

        ShortUrl shortUrl = service.createShortUrl(originalUrl, expiration);
        return ResponseEntity.ok(shortUrl);
    }

    @GetMapping("/{shortCode}")
    public ResponseEntity<?> redirectToOriginal(@PathVariable String shortCode) {
        Optional<ShortUrl> shortUrl = service.getOriginalUrl(shortCode);
        return shortUrl
                .map(url -> ResponseEntity.status(302).location(URI.create(url.getOriginalUrl())).build())
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
