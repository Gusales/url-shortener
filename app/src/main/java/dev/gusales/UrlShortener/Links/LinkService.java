package dev.gusales.UrlShortener.Links;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
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
        try {
            QRCodeWriter qrCodeWriter = new QRCodeWriter();
            BitMatrix bitMatrix = qrCodeWriter.encode(link.getUrlShort(), BarcodeFormat.QR_CODE, 200, 200);

            ByteArrayOutputStream pngOutputStream = new ByteArrayOutputStream();
            MatrixToImageWriter.writeToStream(bitMatrix, "PNG", pngOutputStream);

            byte[] pngQrCodeData = pngOutputStream.toByteArray();

            // Escolher onde salvar o link da imagem do qrcode
            link.setUrlQrCode("QR CODE IS NOW UNAVAILABLE");
        } catch (Exception e) {
            link.setUrlQrCode("QR CODE IS NOW UNAVAILABLE");
        }

        return linkRepository.save(link);
    }

    public LinkModel getUrlOriginal(String shortedUrl){
        try {
            return linkRepository.findByUrlShort(shortedUrl);
        } catch (Exception error) {
            throw new RuntimeException("Url not found!");
        }
    }
}
