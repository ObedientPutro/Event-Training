package com.metrodata.repositories;

import com.metrodata.entities.Participant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParticipantRepository extends JpaRepository <Participant, Long> {


}
