package dev.gusales.UrlShortener.Links;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Map;

@RestController
public class LinkController {
    private LinkService linkService;

    public LinkController(LinkService linkService) {
        this.linkService = linkService;
    }

    @PostMapping("/shorten-url")
    public ResponseEntity<LinkResponse> generateShortenUrl(@RequestBody Map<String, String> request) {
        String urlOriginal = request.get("urlOriginal");
        LinkModel link = linkService.shortenUrl(urlOriginal);

        String generateUserRedirectUrl = "http://localhost:8080/r/" + link.getUrlShort();

        LinkResponse response = new LinkResponse(
                link.getIdUrl(),
                link.getUrlLong(),
                generateUserRedirectUrl,
                link.getUrlQrCode(),
                link.getUrlCreatedAt()
        );

        return ResponseEntity.status(HttpStatus.CREATED).body(response);


    }

    @GetMapping("/r/{shortenUrl}")
    public void redirectLink(@PathVariable String shortenUrl, HttpServletResponse respose) throws IOException {
        LinkModel link = linkService.getUrlOriginal(shortenUrl);
        if (link != null){
            respose.sendRedirect(link.getUrlLong());
        } else {
            respose.sendError(HttpServletResponse.SC_NOT_FOUND);
        }
    }
}
