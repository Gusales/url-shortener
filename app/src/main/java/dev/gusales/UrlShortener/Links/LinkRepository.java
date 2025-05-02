package dev.gusales.UrlShortener.Links;

import org.springframework.data.jpa.repository.JpaRepository;

public interface LinkRepository extends JpaRepository<LinkModel, Long> {
}
