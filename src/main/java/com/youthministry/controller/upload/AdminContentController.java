package com.youthministry.controller.upload;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.youthministry.domain.File;
import com.youthministry.service.FileService;

@Controller
public class AdminContentController {
	
	@Autowired
	private FileService FileService;

	@RequestMapping(value = "/admin/uploadmedia", method = RequestMethod.POST)
	public String save(@ModelAttribute("document") FileUpload uploadItem, BindingResult result, HttpServletRequest request, HttpServletResponse response, HttpSession session) {

		File file = new File();
		file.setName(uploadItem.getFileName());
		file.setDescription(uploadItem.getFileDescription());
		file.setFileName(uploadItem.getFileData().getOriginalFilename());
		file.setFileData(uploadItem.getFileData().getBytes());
		file.setFileSize(Long.parseLong("0")); // TODO
		file.setContentType(uploadItem.getFileData().getContentType());
		file.setCreated(new Date());
		
		FileService.create(file);
		
		return "redirect:/admin/manage/media";
	}

	@RequestMapping(value="/download/{documentId}", method = RequestMethod.GET)
	public @ResponseBody byte[] download(@PathVariable("documentId") Long documentId, HttpServletResponse response) {

		return FileService.read(documentId).getFileData();
	}

	@RequestMapping("/remove/{documentId}")
	public String remove(@PathVariable("documentId") Long documentId) {

		return "redirect:/admin/manage/media";
	}

}
