package br.com.prover.portfolio.controller.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.prover.portfolio.model.People;
import br.com.prover.portfolio.service.PeopleService;

@RestController
@RequestMapping("/api/people")
public class PeopleApiController {
	
	@Autowired
	private PeopleService service;
	
	@GetMapping("/")
	public List<People> getAllPeople(){
		
		List<People> people = this.service.getAllPeople();
		
		return people;		
	}
	
	@PostMapping("/")
	public ResponseEntity<People> insertPeople(@RequestBody People pp) {
		
		People people = this.service.insertPeople(pp);
		
		return ResponseEntity.ok(people);
	}

}
