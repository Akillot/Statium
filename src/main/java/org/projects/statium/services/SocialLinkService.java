package org.projects.statium.services;

import org.projects.statium.entities.SocialLink;
import org.projects.statium.repositories.SocialLinkRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SocialLinkService {

    private final SocialLinkRepository socialLinkRepository;

    public SocialLinkService(SocialLinkRepository socialLinkRepository) {
        this.socialLinkRepository = socialLinkRepository;
    }

    public List<SocialLink> getLinksByUserId(Long userId) {
        return socialLinkRepository.findByUserId(userId);
    }

    public SocialLink createSocialLink(SocialLink socialLink) {
        return socialLinkRepository.save(socialLink);
    }
}
