package com.metrodata.repositories;

import com.metrodata.entities.Sponsor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SponsorRepository extends JpaRepository <Sponsor, Long> {


}
