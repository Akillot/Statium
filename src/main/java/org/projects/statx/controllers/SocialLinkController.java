package org.projects.statx.controllers;

import jakarta.validation.Valid;
import org.projects.statx.entities.SocialLink;
import org.projects.statx.services.SocialLinkService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/social-links")
public class SocialLinkController {

    private static final Logger logger = LoggerFactory.getLogger(SocialLinkController.class);
    private final SocialLinkService socialLinkService;

    public SocialLinkController(SocialLinkService socialLinkService) {
        this.socialLinkService = socialLinkService;
    }

    // Getting links from user
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<SocialLink>> getLinksByUserId(@PathVariable Long userId) {
        logger.info("Request for getting links from user with ID: {}", userId);
        List<SocialLink> links = socialLinkService.getLinksByUserId(userId);
        return links.isEmpty()
                ? ResponseEntity.notFound().build()
                : ResponseEntity.ok(links);
    }

    // Creating new link
    @PostMapping
    public ResponseEntity<SocialLink> createSocialLink(@Valid @RequestBody SocialLink socialLink) {
        logger.info("Creating new link: {}", socialLink);
        SocialLink savedLink = socialLinkService.createSocialLink(socialLink);
        return ResponseEntity.ok(savedLink);
    }
}