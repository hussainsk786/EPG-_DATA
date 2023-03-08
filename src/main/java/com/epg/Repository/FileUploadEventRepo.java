package com.epg.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.epg.entity.EventDetailsEntity;

@Repository
public interface FileUploadEventRepo extends JpaRepository<EventDetailsEntity, Integer> {

}
