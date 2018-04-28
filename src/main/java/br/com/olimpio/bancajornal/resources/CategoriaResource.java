package br.com.olimpio.bancajornal.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.olimpio.bancajornal.domain.Categoria;
import br.com.olimpio.bancajornal.repositories.CategoriaRepository;
import br.com.olimpio.bancajornal.services.CategoriaService;

import org.springframework.web.bind.annotation.RequestMethod;

@RestController
@RequestMapping(value="/categorias")
public class CategoriaResource {	
	
	@Autowired
	private CategoriaRepository categoriaRepositoy;
	
	@RequestMapping(method=RequestMethod.GET)
	public List<Categoria> all() {			
		return categoriaRepositoy.findAll();		
	}

}
