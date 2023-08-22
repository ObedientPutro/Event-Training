package com.metrodata.entities;

import com.metrodata.entities.enums.Occupation;
import com.metrodata.entities.enums.ParticipantStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity @Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tb_m_participants")

public class Participant {

    // Table Definition
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100, nullable = false)
    private String name;

    @Column(length = 100, nullable = false)
    private String email;

    @Column(length = 100, nullable = false)
    private String university;

    @Column(name = "phone_number", length = 15)
    private String phoneNumber;

    @Column(columnDefinition = "TEXT")
    private String address;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Occupation occupation;

    @Column(name = "is_feedback_sent", nullable = false)
    private Boolean isFeedbackSend = false;

    // Table Relation
    @OneToMany
    @JoinColumn(name = "event_id", nullable = false)
    private Event event;

    @OneToMany(mappedBy = "participant")
    private List<SessionRegistrant> sessionRegistrants;

}
