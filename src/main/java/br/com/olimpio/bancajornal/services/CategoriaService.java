package br.com.olimpio.bancajornal.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.olimpio.bancajornal.domain.Categoria;
import br.com.olimpio.bancajornal.repositories.CategoriaRepository;;

public class CategoriaService {

	@Autowired
	private CategoriaRepository categoriaRepository;
	
	public List<Categoria> findAll() {
		return categoriaRepository.findAll();
	}
}
