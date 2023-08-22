package com.metrodata.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.metrodata.entities.enums.ParticipantStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.time.ZoneId;

@Entity @Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tb_tr_session_registrants")

public class SessionRegistrant {

    // Table Definition
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm")
    @Column(name = "attended_at")
    private LocalDateTime AttendedAt;

    @Column(name = "is_attended")
    private Boolean isAttended;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ParticipantStatus status = ParticipantStatus.Active;

    @Column(name = "registered_at", nullable = false)
    private LocalDateTime registeredAt = LocalDateTime.now(ZoneId.of("Asia/Jakarta"));

    @Column(name = "is_reminder_sent", nullable = false)
    private Boolean isReminderSent = false;

    // Table Relation
    @ManyToOne
    @JoinColumn(name = "participant_id", nullable = false)
    private Participant participant;

    @ManyToOne
    @JoinColumn(name = "session_detail_id", nullable = false)
    private SessionDetail sessionDetail;

}
