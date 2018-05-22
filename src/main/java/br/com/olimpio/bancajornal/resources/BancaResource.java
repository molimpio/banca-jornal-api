package br.com.olimpio.bancajornal.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.olimpio.bancajornal.domain.Banca;
import br.com.olimpio.bancajornal.repositories.BancaRepository;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value="/bancas")
public class BancaResource {	
	
	@Autowired
	private BancaRepository bancaRepositoy;
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Banca> insert(@RequestBody Banca banca) {
		banca.setId(null);
		bancaRepositoy.save(banca);
		return ResponseEntity.ok(banca);
		
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public List<Banca> all() {			
		return bancaRepositoy.findAll();
		
	}
	
	@RequestMapping(value="/email", method=RequestMethod.POST)
	public ResponseEntity<Banca> getByEmail(@RequestBody Banca banca) {			
		return ResponseEntity.ok(bancaRepositoy.findByEmail(banca.getEmail()));
	}

}
