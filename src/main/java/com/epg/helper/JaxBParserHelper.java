package com.epg.helper;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.epg.dto.ChannelDetailsDTO;

@Component
public class JaxBParserHelper {

	// Save the uploaded file to this folder
	private static String UPLOADED_FOLDER = "D:\\upload\\";

	public ChannelDetailsDTO unMarshingData(MultipartFile mFile) {

		ChannelDetailsDTO cDetailsCMD = new ChannelDetailsDTO();

		try {

			JAXBContext jaxBContext = JAXBContext.newInstance(ChannelDetailsDTO.class);

			String originalFilename = mFile.getOriginalFilename();

			File file = new File(UPLOADED_FOLDER + originalFilename);

			mFile.transferTo(file);

			System.out.println(file.getPath());

			Unmarshaller createUnmarshaller = jaxBContext.createUnmarshaller();
			cDetailsCMD = (ChannelDetailsDTO) createUnmarshaller.unmarshal(file);
			System.out.println(cDetailsCMD);

		} // try

		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} // catch

		return cDetailsCMD;
	}

}
