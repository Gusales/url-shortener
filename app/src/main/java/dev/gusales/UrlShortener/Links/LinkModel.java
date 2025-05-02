package dev.gusales.UrlShortener.Links;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "tb_links")
public class LinkModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_url_str")
    private Long idUrl;

    @Column(name = "url_long_str")
    private String urlLong;

    @Column(name = "url_short_str")
    private String urlShort;

    @Column(name = "url_qr_code_str")
    private String urlQrCode;

    @Column(name = "url_created_at_date")
    private LocalDateTime urlCreatedAt;

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
