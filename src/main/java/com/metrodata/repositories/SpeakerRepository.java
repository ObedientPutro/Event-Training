package com.metrodata.repositories;

import com.metrodata.entities.Speaker;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpeakerRepository extends JpaRepository <Speaker, Long> {


}