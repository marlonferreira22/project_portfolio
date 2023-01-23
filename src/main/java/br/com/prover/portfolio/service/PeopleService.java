package br.com.prover.portfolio.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.prover.portfolio.model.People;
import br.com.prover.portfolio.repository.PeopleRepository;

@Service
public class PeopleService {

	@Autowired
	private PeopleRepository repository;
	
	public List<People> getAllPeople() {
		
		List<People> people = repository.findAll();
		
		return people;
	}
	
	public People insertPeople(People pp) {
		
		People people = repository.save(pp);
		
		return people;
	}
	
	public List<People> getOnlyEmployee() {
		
		List<People> people = repository.findByRole("funcionario");
		
		people.removeIf(p -> (!p.getRole().equalsIgnoreCase("funcionario")));
		
		return people;
	}
	
	public List<People> getPeopleByRole(String role) {
		
		List<People> people = repository.findByRole(role);
		
		people.removeIf(p -> (!p.getRole().equalsIgnoreCase(role)));
		
		return people;
	}
}
