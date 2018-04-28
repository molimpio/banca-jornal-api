package br.com.olimpio.bancajornal;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.olimpio.bancajornal.domain.Categoria;
import br.com.olimpio.bancajornal.repositories.CategoriaRepository;

@SpringBootApplication
public class BancaJornalApiApplication implements CommandLineRunner {
	
	@Autowired
	private CategoriaRepository categoriaRepository; 

	public static void main(String[] args) {
		SpringApplication.run(BancaJornalApiApplication.class, args);					
	}
	
	@Override
	public void run(String... arg0) throws Exception {
		
		Categoria cat1 = new Categoria(null, "Jornal");
		Categoria cat2 = new Categoria(null, "Revista");
		
		categoriaRepository.save(Arrays.asList(cat1, cat2));
	}
}
