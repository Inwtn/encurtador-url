@Document(collection = "short_urls")
public class ShortUrl {

    @Id
    private String id;

    private String originalUrl;
    private String shortCode;
    private LocalDateTime expiration;

    public ShortUrl () {}

    public ShortUrl (String originalUrl, String shortCode, LocalDateTime expiration) {
        this.originalUrl = originalUrl;
        this.shortCode = shortCode;
        this.expiration = expiration;
    }

    public String getId() {
        return id;
    }

    public String getOriginalUrl() {
        return originalUrl;
    }

    public void setOriginalUrl (String originalUrl) {
        this.originalUrl = originalUrl;
    }

    public String getShortCode () {
        return shortCode;
    }

    public void setShortCode(String shortCode) {
        this.shortCode = shortCode;
    }

    public LocalDateTime getExpiration () {
        return expiration;
    }

    public void setExpiration(LocalDateTime expiration) {
        this.expiration = expiration;
    }
}
