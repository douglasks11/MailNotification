package br.com.techlabs.mailnotification;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import br.com.techlabs.mailnotification.domain.Template;
import br.com.techlabs.mailnotification.domain.Usuario;
import br.com.techlabs.mailnotification.repository.TemplateRepository;
import br.com.techlabs.mailnotification.repository.UsuarioRepository;

/*
 * Classe utilitária para adicionar alguns registros no banco de dados
 * quando a aplicação for iniciada
 */

@Component
public class DatabaseInitializer implements CommandLineRunner {

	@Autowired
	private UsuarioRepository usuarioRepository;
	@Autowired
	private TemplateRepository templateRepository;
	
	@Override
	public void run(String... args) throws Exception {
		removeMassaInicial();
		criaMassaInicial();
	}
	
	protected void removeMassaInicial() {
		
	}
	
	protected void criaMassaInicial() {
		
		Usuario victor = Usuario.builder()
				.nome("Victor")
				.email("victorhyuuk1@gmail.com")
				.password("1234")
				.build();

		Usuario douglas = Usuario.builder()
				.nome("Douglas")
				.email("douglasks11@hotmail.com")
				.password("1234")
				.build();


		Template templateVictor = Template.builder()
				.html("<html> <body> Template do Vitão </body> </html>")
				.build();

		templateRepository.save(templateVictor);

		Template templateDouglas = Template.builder()
				.html("<html> <body> Template do Douglão </body> </html>")
				.build();

		templateRepository.save(templateDouglas);

		victor.setTemplates(Arrays.asList(templateVictor));

		usuarioRepository.save(victor);

		douglas.setTemplates(Arrays.asList(templateDouglas));

		usuarioRepository.save(douglas);

	}

}
