package com.metrodata.repositories;

import com.metrodata.entities.SessionDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SessionDetailRepository extends JpaRepository <SessionDetail, Long> {
}
