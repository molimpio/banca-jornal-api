package br.com.olimpio.bancajornal.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.olimpio.bancajornal.domain.Unidade;
import br.com.olimpio.bancajornal.repositories.UnidadeRepository;

import org.springframework.web.bind.annotation.RequestMethod;

@RestController
@RequestMapping(value="/unidades")
public class UnidadeResource {	
	
	@Autowired
	private UnidadeRepository unidadeRepositoy;
	
	@RequestMapping(method=RequestMethod.GET)
	public List<Unidade> all() {			
		return unidadeRepositoy.findAll();
		
	}

}
