package br.com.prover.portfolio.service;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import br.com.prover.portfolio.ApplicationConfigTest;
import br.com.prover.portfolio.model.People;
import br.com.prover.portfolio.repository.PeopleRepository;

@DisplayName("PeopleServiceTest")
@ExtendWith(MockitoExtension.class)
public class PeopleServiceTest extends ApplicationConfigTest{
	
	@Mock
	private PeopleRepository repository;
	
	@InjectMocks
	private PeopleService service;
	
	@Captor
	ArgumentCaptor<People> peopleCaptor;
	
	
	@Test
	@DisplayName("Should be able to create a new people")
	public void shouldBeAble_ToCreateANewPeople() {
		
		People pp = createPeople();	
		
		service.insertPeople(pp);
		
		Mockito.verify(repository).save(peopleCaptor.capture());
		People peopleSaved = peopleCaptor.getValue();
		
		Assertions.assertNotEquals(0, peopleSaved.getPeopleId());
		Assertions.assertNotNull(peopleSaved.getName());
		Assertions.assertNotNull(peopleSaved.getRole());		
		
	}
	
	@Test
	@DisplayName("Should be able to get all people")
	public void shouldBeAble_ToGetAllPeople() {
		
		List<People> pp = createPeopleList();
		
		Mockito.when(service.getAllPeople()).thenReturn(pp);
		
		List<People> response = service.getAllPeople();
		
		Mockito.verify(repository).findAll();	
		
		Assertions.assertEquals(People.class, response.get(0).getClass());
		Assertions.assertEquals(4, response.size());		
	}
	
	@Test
	@DisplayName("Should be able to get only employee")
	public void shouldBeAble_ToGetOnlyEmployee() {
		
		List<People> pp = createPeopleList();
		
		Mockito.when(service.getOnlyEmployee()).thenReturn(pp);
		
		List<People> response = service.getOnlyEmployee();
		
		Mockito.verify(repository).findByRole("funcionario");
		
		Assertions.assertNotNull(response);
		Assertions.assertEquals(People.class, response.get(0).getClass());
		Assertions.assertEquals(3, response.size());		
	}
	
	private People createPeople() {
		
		People people = new People();	
		people.setPeopleId(1);
		people.setName("People Name Test");
		people.setRole("funcionario");
		
		return people;
	}
	
	private List<People> createPeopleList() {
		
		List<People> people = new ArrayList<>();
		
		People pp1 = new People();	
		pp1.setPeopleId(1);
		pp1.setName("People Name Test");
		pp1.setRole("funcionario");
		people.add(pp1);
		
		People pp2 = new People();	
		pp2.setPeopleId(2);
		pp2.setName("People Name Test 2");
		pp2.setRole("funcionario");
		people.add(pp2);
		
		People pp3 = new People();	
		pp3.setPeopleId(3);
		pp3.setName("People Name Test 3");
		pp3.setRole("gerente");
		people.add(pp3);
		
		People pp4 = new People();	
		pp4.setPeopleId(4);
		pp4.setName("People Name Test 4");
		pp4.setRole("funcionario");
		people.add(pp4);
		
		return people;
	}

}
