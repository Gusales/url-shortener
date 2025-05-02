package dev.gusales.UrlShortener.Links;

import jakarta.persistence.*;

import java.time.LocalDateTime;

public class LinkResponse {
    private Long idUrl;
    private String urlLong;
    private String urlShort;
    private String urlQrCode;
    private LocalDateTime urlCreatedAt;

    public LinkResponse(Long idUrl, String urlLong, String urlShort, String urlQrCode, LocalDateTime urlCreatedAt) {
        this.idUrl = idUrl;
        this.urlLong = urlLong;
        this.urlShort = urlShort;
        this.urlQrCode = urlQrCode;
        this.urlCreatedAt = urlCreatedAt;
    }

    public Long getIdUrl() {
        return idUrl;
    }

    public void setIdUrl(Long idUrl) {
        this.idUrl = idUrl;
    }

    public String getUrlLong() {
        return urlLong;
    }

    public void setUrlLong(String urlLong) {
        this.urlLong = urlLong;
    }

    public String getUrlShort() {
        return urlShort;
    }

    public void setUrlShort(String urlShort) {
        this.urlShort = urlShort;
    }

    public String getUrlQrCode() {
        return urlQrCode;
    }

    public void setUrlQrCode(String urlQrCode) {
        this.urlQrCode = urlQrCode;
    }

    public LocalDateTime getUrlCreatedAt() {
        return urlCreatedAt;
    }

    public void setUrlCreatedAt(LocalDateTime urlCreatedAt) {
        this.urlCreatedAt = urlCreatedAt;
    }
}
