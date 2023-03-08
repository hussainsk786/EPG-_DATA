package com.epg.Controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.epg.Service.IFileUploadService;
import com.epg.dto.ChannelDetailsDTO;
import com.epg.entity.ChannelDetailsEntity;

/**
 * @author Apalya
 *
 */

@Controller
public class FileUploadController {

	/*
	 * To Injected IFileUploadService interface by using @Autowired annotation.
	 * 
	 */

	@Autowired
	private IFileUploadService fService;

	Logger logger = LoggerFactory.getLogger(FileUploadController.class);

	/*
	 * this method is used for display File upload Form
	 * 
	 * @return "file_upload_form" jsp page
	 */
	@GetMapping("/loadForm")
	public String getFileUploadForm() {

		return "file_upload_form";
	}// getFileUploadForm

	@GetMapping("/createEPG")
	public String loadCreateForm(Model model) {

		ChannelDetailsEntity chEntity = new ChannelDetailsEntity();

		model.addAttribute("chEntity", chEntity);

		return "epgCreatePage";
	}

	/*
	 * This method is used to for file submit form.
	 * 
	 *
	 * @param file
	 * 
	 * @param reAttr
	 * 
	 * @param model
	 * 
	 * @return "file_upload_status" jsp page
	 */
	@PostMapping("/fileSubmit")
	public String fileSubmit(@RequestParam("file") MultipartFile file, RedirectAttributes reAttr, Model model) {
		if (file.isEmpty()) {
			reAttr.addFlashAttribute("alertMesg", "Please select a file  to upload");
			return "redirect:loadForm";
		}

		String mesg = fService.fileSave(file);
		model.addAttribute("successMesg", mesg);
		return "file_upload_status";

	}// fileSubmit

	@GetMapping("/getAllDetails")
	public String getAllChannelDetails(RedirectAttributes rtAtt, Model model) {

		List<ChannelDetailsDTO> aLlDetails = fService.getALlDetails();

		System.out.println("Controller Detials" + aLlDetails);

		model.addAttribute("listDTO", aLlDetails);

		return "all_details";

	}// getAllChannelDetails

}
