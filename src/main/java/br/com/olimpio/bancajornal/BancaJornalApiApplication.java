package br.com.olimpio.bancajornal;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.olimpio.bancajornal.domain.Categoria;
import br.com.olimpio.bancajornal.domain.Unidade;
import br.com.olimpio.bancajornal.repositories.CategoriaRepository;
import br.com.olimpio.bancajornal.repositories.UnidadeRepository;

@SpringBootApplication
public class BancaJornalApiApplication implements CommandLineRunner {
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	private UnidadeRepository unidadeRepository;

	public static void main(String[] args) {
		SpringApplication.run(BancaJornalApiApplication.class, args);					
	}
	
	@Override
	public void run(String... arg0) throws Exception {
		
		Categoria cat1 = new Categoria(null, "Jornal");
		Categoria cat2 = new Categoria(null, "Revista");
		Categoria cat3 = new Categoria(null, "Livro");
		Categoria cat4 = new Categoria(null, "Álbum");
		Categoria cat5 = new Categoria(null, "Figurinhas");
		
		categoriaRepository.save(Arrays.asList(cat1, cat2, cat3, cat4, cat5));
		
		Unidade uni1 = new Unidade(null, "Pacote");
		Unidade uni2 = new Unidade(null, "Unitário");
		
		unidadeRepository.save(Arrays.asList(uni1, uni2));
	}
}
