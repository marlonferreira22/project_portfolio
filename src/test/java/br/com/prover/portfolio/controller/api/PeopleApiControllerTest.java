package br.com.prover.portfolio.controller.api;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import br.com.prover.portfolio.ApplicationConfigTest;
import br.com.prover.portfolio.model.People;
import br.com.prover.portfolio.service.PeopleService;

@DisplayName("PeopleApiController")
@ExtendWith(MockitoExtension.class)
class PeopleApiControllerTest extends ApplicationConfigTest{

	@InjectMocks
	private PeopleApiController controller;
	
	@Mock
	private PeopleService service;
	
	@Test
	@DisplayName("Should be able to get all people in API")
	void shouldBeAble_ToGetAllPeopleInApi() {
		
		List<People> pp = createPeopleList();
		
		Mockito.when(service.getAllPeople()).thenReturn(pp);
		
		List<People> response = controller.getAllPeople();
		
		Assertions.assertNotNull(response);
		Assertions.assertEquals(People.class, response.get(0).getClass());
		Assertions.assertEquals(4, response.size());
		Assertions.assertEquals(1, response.get(0).getPeopleId());
	}
	
	@Test
	@DisplayName("Should be able to create a new people in API")
	public void shouldBeAble_ToCreateANewPeopleInApi() {
		
		People pp = createPeople();
		
		Mockito.when(service.insertPeople(pp)).thenReturn(pp);
		
		ResponseEntity<People> response = controller.insertPeople(pp);
		
		Assertions.assertNotNull(response);
		Assertions.assertNotNull(response.getBody());
		Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
		Assertions.assertEquals(ResponseEntity.class, response.getClass());
		Assertions.assertEquals(People.class, response.getBody().getClass());
		
		Assertions.assertEquals(pp.getPeopleId(), response.getBody().getPeopleId());
		Assertions.assertEquals(pp.getName(), response.getBody().getName());	
		
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
