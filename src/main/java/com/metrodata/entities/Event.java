package com.metrodata.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.websocket.Session;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Entity @Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tb_m_events")

public class Event {

    // Table Definition
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(length = 100, nullable = false)
    private String name;

    @Column(length = 50, nullable = false, unique = true)
    private String slug;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm")
    @Column(name = "start_date_time", nullable = false)
    private LocalDateTime startDateTime;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm")
    @Column(name = "end_date_time", nullable = false)
    private LocalDateTime endDateTime;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm")
    @Column(name = "start_registration", nullable = false)
    private LocalDateTime startRegistration;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm")
    @Column(name = "end_registration", nullable = false)
    private LocalDateTime endRegistration;

    @Column(nullable = false)
    private Integer capacity;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String location;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String imageUrl;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String theme;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String venue;

    @Column(name = "status", nullable = false)
    private Boolean isPublished;


    // Table Relation
    @OneToMany(mappedBy = "event", fetch = FetchType.EAGER)
    private List<Session> sessions;

    @OneToMany(mappedBy = "event", fetch = FetchType.EAGER)
    private List<Participant> participants;

    @OneToMany(mappedBy = "event", fetch = FetchType.EAGER)
    private List<Sponsor> sonpors;

}
