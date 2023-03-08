package com.epg.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.epg.entity.ChannelDetailsEntity;

@Repository
public interface FileUploadRepository extends JpaRepository<ChannelDetailsEntity, Integer> {

}