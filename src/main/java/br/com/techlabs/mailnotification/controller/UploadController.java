package br.com.techlabs.mailnotification.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.techlabs.mailnotification.storage.StorageService;

@Controller
public class UploadController {
	
	private final String UPLOAD_DIR = "./files/";
	
	@RequestMapping(method = RequestMethod.GET, path = "/upload")
	public String upload () {
		return "upload";
	}
	
	@PostMapping("/upload")
	public String uploadFile(@RequestParam("file") MultipartFile file, RedirectAttributes attributes) {
		
		 if (file.isEmpty()) {
	            attributes.addFlashAttribute("message", "Please select a file to upload.");
	            return "redirect:/";
	        }

	        // normalize the file path
	        String fileName = StringUtils.cleanPath(file.getOriginalFilename());

	        // save the file on the local file system
	        try {
	            Path path = Paths.get(UPLOAD_DIR + fileName);
	            Files.copy(file.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
	        } catch (IOException e) {
	            e.printStackTrace();
	        }

	        // return success response
	        attributes.addFlashAttribute("message", "You successfully uploaded " + fileName + '!');
	        
		return "upload";
	}
	
}
