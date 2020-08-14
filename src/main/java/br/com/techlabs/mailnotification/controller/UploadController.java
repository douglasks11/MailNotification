package br.com.techlabs.mailnotification.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UploadController {
	
	
	@RequestMapping(method = RequestMethod.GET, path = "/upload")
	public String upload () {
		return "upload";
	}
	
}
