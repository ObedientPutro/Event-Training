package com.metrodata.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity @Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tb_tr_session_details")

public class SessionDetail {

    // Table Definition
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100, nullable = false)
    private String name;

    @Column(nullable = false)
    private Integer capacity;

    @Column(columnDefinition = "TEXT")
    private String description;


    // Table Relation
    @ManyToOne
    @JoinColumn(name = "session_id", nullable = false)
    private Session session;

    @OneToMany(mappedBy = "sessionDetail")
    private List<SessionSpeaker> sessionSpeakers;

    @OneToMany(mappedBy = "sessionDetail")
    private List<SessionRegistrant> sessionRegistrants;

    @OneToMany(mappedBy = "sessionDetail", cascade = CascadeType.ALL)
    private List<SessionRoom> sessionRooms;

    @OneToOne(mappedBy = "sessionDetail", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private CertificateTemplate certificateTemplate;

}
