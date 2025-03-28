package org.projects.statx.controllers;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.projects.statx.entities.SocialLink;
import org.projects.statx.services.SocialLinkService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/social-links")
@Slf4j
public class SocialLinkController {

    private final SocialLinkService socialLinkService;

    public SocialLinkController(SocialLinkService socialLinkService) {
        this.socialLinkService = socialLinkService;
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<SocialLink>> getLinksByUserId(@PathVariable Long userId) {
        log.info("Запрос на получение ссылок пользователя с ID: {}", userId);
        List<SocialLink> links = socialLinkService.getLinksByUserId(userId);
        return links.isEmpty()
                ? ResponseEntity.notFound().build()
                : ResponseEntity.ok(links);
    }

    @PostMapping
    public ResponseEntity<SocialLink> createSocialLink(@Valid @RequestBody SocialLink socialLink) {
        log.info("Создание новой ссылки: {}", socialLink);
        SocialLink savedLink = socialLinkService.createSocialLink(socialLink);
        return ResponseEntity.ok(savedLink);
    }
}
