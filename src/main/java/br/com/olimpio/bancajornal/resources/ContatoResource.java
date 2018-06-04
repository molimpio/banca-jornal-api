package br.com.olimpio.bancajornal.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
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
	private ContatoRepository contatoRepository;
	
	@RequestMapping(value="/rawcontatos", method=RequestMethod.GET)
	public List<Contato> all() {					
		return contatoRepository.findAll();
		
	}
	
	@RequestMapping(value="/contato", method=RequestMethod.POST)
	public ResponseEntity<Contato> insert(@RequestBody Contato contato) {					
		contato.setId(null);				
		contatoRepository.save(contato);
		return ResponseEntity.ok(contato);
	}
	
	@RequestMapping(value="/contato/{id}", method=RequestMethod.GET)
	public ResponseEntity<Contato> getContatoById(@PathVariable Integer id) {		
		return ResponseEntity.ok(contatoRepository.findOne(id));
	}

}
