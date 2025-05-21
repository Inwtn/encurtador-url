package com.estudos.encurtadorurl.service;

// Importa as classes necessárias, incluindo o repositório, modelo e utilitários.
import com.estudos.encurtadorurl.model.ShortUrl;
import com.estudos.encurtadorurl.repository.ShortUrlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.Random;

// Marca essa classe como um Service, ou seja, contém a lógica de negócio.
@Service
public class ShortUrlService {
    // Injeta automaticamente o repositório para acesso ao banco de dados.
     @Autowired
    private ShortUrlRepository repository;
    // Método que gera uma URL encurtada com tempo de expiração em minutos.
    public ShortUrl encurtarUrl(String urlOriginal, int ttlMinutos) {
        // Gera um código aleatório de 6 caracteres.
        String shortCode = gerarCodigoAleatorio(6);
        // Calcula a data/hora de expiração da URL encurtada.
        LocalDateTime expiration = LocalDateTime.now().plusMinutes(ttlMinutos);
        // Cria e salva a nova URL encurtada no banco.
        ShortUrl shortUrl = new ShortUrl(urlOriginal, shortCode, expiration);
        return repository.save(shortUrl);
    }
        // Gera um código aleatório com letras maiúsculas, minúsculas e números.
    private String gerarCodigoAleatorio(int tamanho) {
        String caracteres = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        StringBuilder sb = new StringBuilder();
        Random rand = new Random();
        for (int i = 0; i < tamanho; i++) {
            sb.append(caracteres.charAt(rand.nextInt(caracteres.length())));
        }
        return sb.toString();
    }
}
