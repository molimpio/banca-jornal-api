package br.com.olimpio.bancajornal.resources;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.olimpio.bancajornal.domain.Item;
import br.com.olimpio.bancajornal.repositories.ItemRepository;

@RestController
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

}