package br.com.prover.portfolio;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import br.com.prover.portfolio.model.People;
import br.com.prover.portfolio.repository.PeopleRepository;
import br.com.prover.portfolio.repository.ProjectRepository;

@SpringBootApplication
public class PortfolioApplication {	

	public static void main(String[] args) {
		SpringApplication.run(PortfolioApplication.class, args);
		
	}
	
	@Bean
	public CommandLineRunner init(PeopleRepository peopleRepository, ProjectRepository projectRepository) {
		
		return args -> {			
			List<People> peoples = new ArrayList<>();
			
			People pp1 = new People();	
			pp1.setPeopleId(1);
			pp1.setName("People Name Test");
			pp1.setRole("funcionario");
			peoples.add(pp1);
			
			People pp2 = new People();	
			pp2.setPeopleId(2);
			pp2.setName("People Name Test 2");
			pp2.setRole("funcionario");
			peoples.add(pp2);
			
			People pp3 = new People();	
			pp3.setPeopleId(3);
			pp3.setName("People Name Test 3");
			pp3.setRole("gerente");
			peoples.add(pp3);
			
			People pp4 = new People();	
			pp4.setPeopleId(4);
			pp4.setName("People Name Test 4");
			pp4.setRole("funcionario");
			peoples.add(pp4);
			
			People pp5 = new People();	
			pp5.setPeopleId(5);
			pp5.setName("People Name Test 5");
			pp5.setRole("gerente");
			peoples.add(pp5);
			
			for (int i = 0; i < peoples.size(); i++) {				
				peopleRepository.save(peoples.get(i));
			}
        };
		
	}

}
