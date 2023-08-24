package com.metrodata.repositories;

import com.metrodata.entities.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventRepository extends JpaRepository <Event, Long> {
    // Query Method
    Integer countAllByName(String name);

    List<Event> findByIsPublishedTrue();

    // Custom Query JPQL
    @Query("SELECT e FROM Event e WHERE e.isPublished = ?1")
    List<Event> getAllEventByIsPublished(boolean isPublished);

    // Custom Query Native
    @Query(value = "SELECT * FROM tb_m_events WHERE is_published = ?1 AND capacity = ?2", nativeQuery = true)
    List<Event> getAllEventByIsPublishedNative(boolean isPublished, Integer capacity);
}
