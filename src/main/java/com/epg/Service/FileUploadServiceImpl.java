package com.epg.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.epg.Repository.FileUploadEventRepo;
import com.epg.Repository.FileUploadRepository;
import com.epg.dto.ChannelDetailsDTO;
import com.epg.dto.EventDetailsDTO;
import com.epg.entity.ChannelDetailsEntity;
import com.epg.entity.EventDetailsEntity;
import com.epg.helper.JaxBParserHelper;

@Service
public class FileUploadServiceImpl implements IFileUploadService {
	/*
	 * To Injected JaxBParserHelper class for marshaling and unmarshaling xml data
	 * by using @Autowired annotation.
	 * 
	 */

	@Autowired
	private JaxBParserHelper jaxB;
	/*
	 * To Injected FileUploadRepository class for communicating with database by
	 * using @Autowired annotation.
	 * 
	 */
	@Autowired
	private FileUploadRepository fileUploadRepo;

	@Autowired
	private FileUploadEventRepo eventRepo;

	// this method used for save the data in DB

	@Override
	public String fileSave(MultipartFile file) {

		// create the channel details entity class

		ChannelDetailsEntity chDetailsEntity = new ChannelDetailsEntity();

		// call the unMarshing data method

		ChannelDetailsDTO unMarshingData = jaxB.unMarshingData(file);
		System.out.println(unMarshingData);
		// copy data unMarshingData to chDetailsEntity

		BeanUtils.copyProperties(unMarshingData, chDetailsEntity);
		System.out.println(chDetailsEntity);

		// call the save method for channelDetailsEntity
		ChannelDetailsEntity status = fileUploadRepo.save(chDetailsEntity);

		// call the save method for eventDetailsEntity
		List<EventDetailsDTO> eventDetails = unMarshingData.getEventDetails();

		System.out.println(eventDetails);
		eventDetails.forEach(event -> {
			EventDetailsEntity eventEntity = new EventDetailsEntity();
			eventEntity.setChannel(chDetailsEntity);

			BeanUtils.copyProperties(event, eventEntity);

			eventRepo.save(eventEntity);

		});

		// check the status success or failed

		if (status == null) {
			return "File uploaded failed";
		}

		return "File uploaded successful";
	}

	@Override
	public List<ChannelDetailsDTO> getALlDetails() {
		// TODO Auto-generated method stub

		List<ChannelDetailsDTO> listDTO = new ArrayList<>();

		List<ChannelDetailsEntity> findAll = fileUploadRepo.findAll();
		/*
		 * List<EventDetailsEntity> findAll2 = eventRepo.findAll();
		 * 
		 * System.out.println(findAll2);
		 */

		findAll.forEach(chaDetails -> {
			ChannelDetailsDTO chDTO = new ChannelDetailsDTO();
			BeanUtils.copyProperties(chaDetails, chDTO);

			listDTO.add(chDTO);

		});

		System.out.println("Get all details:" + listDTO);
		return listDTO;
	}

}
