package br.com.olimpio.bancajornal.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.olimpio.bancajornal.domain.Contato;
import br.com.olimpio.bancajornal.domain.Mensagem;
import br.com.olimpio.bancajornal.repositories.ContatoRepository;
import br.com.olimpio.bancajornal.repositories.MensagemRepository;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value="/mensageiro")
public class MensagemResource {
	
	@Autowired
	private MensagemRepository mensagemRepository;
	
	@Autowired
	private ContatoRepository contatoRepository;

	@RequestMapping(value="/mensagem", method=RequestMethod.POST)
	public ResponseEntity<Mensagem> insert(@RequestBody Mensagem mensagem) {					
		mensagem.setId(null);				
		mensagem.setOrigem(null);
		mensagem.setDestino(null);
		mensagemRepository.save(mensagem);
		return ResponseEntity.ok(mensagem);
	}
	
	@RequestMapping(value="/rawmensagens/{id_mensagem}/{id_remetente}/{id_destinatario}", method=RequestMethod.GET)
	public List<Mensagem> getMensagensByIds(@PathVariable Integer id_mensagem,
													 @PathVariable Integer id_remetente,
													 @PathVariable Integer id_destinatario) {		
		
		List<Mensagem> mensagens = mensagemRepository.findAll();		
		List<Mensagem> msgFiltradas = new ArrayList<>();
		
		for (Mensagem mensagem: mensagens) {
			
			if (mensagem.getOrigem_id() == id_remetente && mensagem.getDestino_id() == id_destinatario) {
				Contato origem = new Contato();
				origem = contatoRepository.findOne(mensagem.getOrigem_id());
				mensagem.setOrigem(origem);
				
				Contato destino = new Contato();
				destino = contatoRepository.findOne(mensagem.getDestino_id());
				
				mensagem.setDestino(destino);
				
				msgFiltradas.add(mensagem);				
			}			
		}
		return msgFiltradas;
	}
}
