package br.com.olimpio.bancajornal.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.olimpio.bancajornal.domain.Contato;
import br.com.olimpio.bancajornal.repositories.ContatoRepository;

import org.springframework.web.bind.annotation.RequestMethod;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value="/mensageiro")
public class ContatoResource {	
	
	@Autowired
	private ContatoRepository contatoRepositoy;
	
	@RequestMapping(value="/rawcontatos", method=RequestMethod.GET)
	public List<Contato> all() {					
		return contatoRepositoy.findAll();
		
	}
	
	@RequestMapping(value="/contato", method=RequestMethod.POST)
	public boolean insert(@RequestBody Contato contato) {					
		contato.setId(null);				
		contatoRepositoy.save(contato);
		return true;		
	}

}
