package br.com.erudio.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.erudio.data.vo.PersonVO;
import br.com.erudio.services.PersonServices;
import br.com.erudio.util.MediaType;

@RestController
@RequestMapping("/person/v1")
public class PersonController {
	
	@Autowired
	private PersonServices service;
	
	@GetMapping(produces= {MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML,"application/x-yaml"})
	public List<PersonVO> findAll() {
		return service.findAll();
	}	
	
	@GetMapping(value="/{id}",produces= {MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML,MediaType.APPLICATION_YAML})
	public PersonVO findById(@PathVariable("id") Long id) {
		return service.findById(id);
	}	
	
	@PostMapping(consumes={MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML,MediaType.APPLICATION_YAML},
			produces= {MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML,MediaType.APPLICATION_YAML})
	public PersonVO create(@RequestBody PersonVO person) {
		return service.create(person);
	}
	
	@PutMapping(consumes= {MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML,MediaType.APPLICATION_YAML},
			produces= {MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML,MediaType.APPLICATION_YAML})
	public PersonVO update(@RequestBody PersonVO person) {
		return service.update(person);
	}	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") Long id) {
		service.delete(id);
		return ResponseEntity.ok().build();
	}	
	
}