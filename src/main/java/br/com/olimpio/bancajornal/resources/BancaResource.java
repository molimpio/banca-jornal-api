package br.com.olimpio.bancajornal.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.olimpio.bancajornal.domain.Banca;
import br.com.olimpio.bancajornal.repositories.BancaRepository;

@RestController
@RequestMapping(value="/bancas")
public class BancaResource {	
	
	@Autowired
	private BancaRepository bancaRepositoy;
	
	@RequestMapping(method=RequestMethod.POST)
	public boolean insert(@RequestBody Banca banca) {
		banca.setId(null);
		bancaRepositoy.save(banca);
		return true;
		
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public List<Banca> all() {			
		return bancaRepositoy.findAll();
		
	}

}
