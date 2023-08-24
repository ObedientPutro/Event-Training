package com.metrodata.repositories;

import com.metrodata.entities.CertificateTemplate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CertificateTemplateRepository extends JpaRepository <CertificateTemplate, Long> {


}
