package br.com.prover.portfolio.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import br.com.prover.portfolio.model.People;
import br.com.prover.portfolio.service.PeopleService;

@Controller
public class PeopleController {

	@Autowired
	private PeopleService service;
	
	public List<People> getAllPeople(){
		
		List<People> people = this.service.getAllPeople();
		return people;		
	}
	
	public List<People> getOnlyEmployee(){
		
		List<People> people = this.service.getOnlyEmployee();
		return people;		
	}
	
}
