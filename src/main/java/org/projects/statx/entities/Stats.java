package org.projects.statx.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "stats")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Stats {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "stat_id")
    private Long statId;

    @ManyToOne
    @JoinColumn(name = "link_id", nullable = false)
    private SocialLink socialLink;

    @Column(name = "followers", columnDefinition = "INT DEFAULT 0")
    private int followers = 0;
}
