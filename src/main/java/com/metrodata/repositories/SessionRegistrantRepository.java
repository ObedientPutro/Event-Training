package com.metrodata.repositories;

import com.metrodata.entities.SessionRegistrant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SessionRegistrantRepository extends JpaRepository <SessionRegistrant, Long> {


}
