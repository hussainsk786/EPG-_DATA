package com.epg.Service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.epg.dto.ChannelDetailsDTO;

public interface IFileUploadService {

	public String fileSave(MultipartFile file);

	public List<ChannelDetailsDTO> getALlDetails();

}
