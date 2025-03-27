package org.projects.statx.controllers;

import org.projects.statx.entities.SocialLink;
import org.projects.statx.repositories.SocialLinkRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/api/social-links")
public class SocialLinkController {

    private final SocialLinkRepository socialLinkRepository;

    public SocialLinkController(SocialLinkRepository socialLinkRepository) {
        this.socialLinkRepository = socialLinkRepository;
    }

    @GetMapping
    public List<SocialLink> getSocialLinks() {
        return socialLinkRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<SocialLink> getLinkById(@PathVariable Long id) {
        Optional<SocialLink> link = socialLinkRepository.findById(id);
        return link.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public SocialLink createLink(@RequestBody SocialLink socialLink) {
        return socialLinkRepository.save(socialLink);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<SocialLink>> getLinksByUserId(@PathVariable Long userId) {
        List<SocialLink> links = socialLinkRepository.findByUserId(userId);
        return ResponseEntity.ok(links);
    }
}
