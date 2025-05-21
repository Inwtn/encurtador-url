// Define o pacote onde essa classe está localizada
package com.estudos.encurtadorurl.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "short_urls")
public class ShortUrl {
    /*  id: identificador único no MongoDB.
        originalUrl: URL original que será encurtada.
        shortCode: código encurtado.
        expiration: data/hora de expiração. */
    private String id;
    private String originalUrl;
    private String shortCode;
    private LocalDateTime expiration;

// Construtor padrão (necessário para o Spring/Data funcionar corretamente).
    public ShortUrl () {}

// Construtor com parâmetros, usado para criar novos objetos ShortUrl.
    public ShortUrl (String originalUrl, String shortCode, LocalDateTime expiration) {
        this.originalUrl = originalUrl;
        this.shortCode = shortCode;
        this.expiration = expiration;
    }
    // Retorna o valor do id.
    public String getId() {
        return id;
    }
 
    // Get e set da URL original.
    public String getOriginalUrl() {
        return originalUrl;
    }

    public void setOriginalUrl (String originalUrl) {
        this.originalUrl = originalUrl;
    }

    // Get e set do código encurtado.
    public String getShortCode () {
        return shortCode;
    }

    public void setShortCode(String shortCode) {
        this.shortCode = shortCode;
    }

    // Get e set da data de expiração.
    public LocalDateTime getExpiration () {
        return expiration;
    }

    public void setExpiration(LocalDateTime expiration) {
        this.expiration = expiration;
    }
}
