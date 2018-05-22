package br.com.olimpio.bancajornal.resources;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.olimpio.bancajornal.domain.Item;
import br.com.olimpio.bancajornal.repositories.ItemRepository;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value="/items")
public class ItemResource {	
	
	@Autowired
	private ItemRepository itemRepositoy;
	
	@RequestMapping(method=RequestMethod.POST)
	public boolean insert(@RequestBody Item item) {					
		item.setId(null);		
		item.setData(new Date());
		item.setAtivo(true);
		itemRepositoy.save(item);
		return true;		
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public List<Item> all() {			
		return itemRepositoy.findAll();
		
	}
	
	 
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		Item item = new Item();
		item = itemRepositoy.findOne(id);		
		item.setAtivo(false);
		itemRepositoy.save(item);	
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public ResponseEntity<Void> update(@RequestBody Item itemObj, @PathVariable Integer id) {
		
		Item item = new Item(itemObj.getId(), itemObj.getCodigo(), itemObj.getCategoria(), itemObj.getUnidade(),
				 itemObj.getQtde(), new Date(), itemObj.getDescricao(), true, itemObj.getBanca());
		
		item.setId(id);				
		itemRepositoy.save(item);	
		return ResponseEntity.noContent().build();
	}

}
