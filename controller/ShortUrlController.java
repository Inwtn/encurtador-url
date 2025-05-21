package com.estudos.encurtadorurl.controller;

// Importa o modelo, serviço e anotações do Spring Web.
import com.estudos.encurtadorurl.model.ShortUrl;
import com.estudos.encurtadorurl.service.ShortUrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/* @RestController: define a classe como controller REST.
   @RequestMapping("/api"): prefixa todas as rotas com /api. */
@RestController
@RequestMapping("/api")
public class ShortUrlController {
// Injeta o serviço que lida com a lógica de encurtar URLs.
    @Autowired
    private ShortUrlService service;

    /* Define um endpoint POST /api/encurtar que recebe:
        url: a URL original.
        ttl: tempo para expiração (em minutos), com valor padrão 10.
        Chama o serviço para encurtar a URL.
        Retorna a URL encurtada no formato http://localhost:8080/api/codigo. */
    @PostMapping("/encurtar")
    public String encurtarUrl(@RequestParam String url, @RequestParam(defaultValue = "10") int ttl) {
        ShortUrl shortUrl = service.encurtarUrl(url, ttl);
        return "http://localhost:8080/api/" + shortUrl.getShortCode();
    }
}
