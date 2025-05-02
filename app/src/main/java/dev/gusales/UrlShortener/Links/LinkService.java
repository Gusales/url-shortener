package dev.gusales.UrlShortener.Links;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class LinkService {

    /**
     * TODO: Step By Step
     * 1 - Gerar uma Url Aleatória
     * 2 - Conectar essa Url com o QrCode
     * 3 - Tentar pegar os analytcs da url aleatória
     * */

    private LinkRepository linkRepository;

    public LinkService(LinkRepository linkRepository) {
        this.linkRepository = linkRepository;
    }

    public String generateRandomUrl(){
        return RandomStringUtils.randomAlphanumeric(5, 10);
    }

    public LinkModel shortenUrl(String originalUrl){
        LinkModel link = new LinkModel();

        link.setUrlLong(originalUrl);
        link.setUrlShort(this.generateRandomUrl());
        link.setUrlCreatedAt(LocalDateTime.now());
        link.setUrlQrCode("QR CODE IS NOW UNAVAILABLE");

        return linkRepository.save(link);
    }

    public LinkModel getUrlOriginal(String shortedUrl){
        try {
            return linkRepository.findByUrlLong(shortedUrl);
        } catch (Exception error) {
            throw new RuntimeException("Url not found!");
        }
    }
}
