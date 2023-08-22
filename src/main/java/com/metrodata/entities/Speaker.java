package com.metrodata.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity @Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tb_m_speakers")

public class Speaker {

    // Table Definition
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100, nullable = false)
    private String name;

    @Column(name = "photo_url", columnDefinition = "TEXT", nullable = false)
    private String photoUrl;

    @Column(length = 50, nullable = false)
    private String jobTitle;

    @Column(length = 100, nullable = false)
    private String company;

    // Table Relation
    @ManyToOne
    @JoinColumn(name = "sponsor_id", nullable = false)
    private Sponsor sponsor;

}
