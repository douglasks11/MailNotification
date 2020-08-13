package br.com.techlabs.mailnotification.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*
 * Expoe um serviço REST 
 * 
 * http://localhost:8080/rest
 */

@RestController
@RequestMapping("/rest")
@CrossOrigin("*")
public class TestRestController {

	@GetMapping
	public ResponseEntity<String> testaServicoRest(){
		return ResponseEntity.ok().body("<html> <h1> Welcome to Mail-Notification! </h1> </html>");
	}
}
