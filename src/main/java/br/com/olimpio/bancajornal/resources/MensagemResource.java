package br.com.olimpio.bancajornal.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.olimpio.bancajornal.domain.Mensagem;
import br.com.olimpio.bancajornal.repositories.MensagemRepository;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value="/mensageiro")
public class MensagemResource {
	
	@Autowired
	private MensagemRepository mensagemRepository;

	@RequestMapping(value="/mensagem", method=RequestMethod.POST)
	public ResponseEntity<Mensagem> insert(@RequestBody Mensagem mensagem) {					
		mensagem.setId(null);				
		mensagemRepository.save(mensagem);
		return ResponseEntity.ok(mensagem);
	}
}
