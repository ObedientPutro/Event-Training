package com.metrodata.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity @Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tb_m_certificate_templates")

public class CertificateTemplate {

    // Table Definition
    @Id
    private Long id;

    @Column(name = "certificate_url", columnDefinition = "TEXT", nullable = false)
    private String certificateUrl;


    // Table Relation
    @OneToOne
    @MapsId
    @JoinColumn(name = "id", nullable = false)
    private SessionDetail sessionDetail;

}
