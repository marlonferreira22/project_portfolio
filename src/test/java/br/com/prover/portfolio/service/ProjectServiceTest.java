package br.com.prover.portfolio.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.ArgumentMatchers;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import br.com.prover.portfolio.ApplicationConfigTest;
import br.com.prover.portfolio.dto.ProjectDTO;
import br.com.prover.portfolio.model.People;
import br.com.prover.portfolio.model.Project;
import br.com.prover.portfolio.repository.PeopleRepository;
import br.com.prover.portfolio.repository.ProjectRepository;

@DisplayName("ProjectServiceTest")
@ExtendWith(MockitoExtension.class)
class ProjectServiceTest extends ApplicationConfigTest{

	@InjectMocks
	private ProjectService service;
	
	@Mock
	private ProjectRepository repository;
	
	@Mock
	private PeopleRepository peopleRepository;
	
	@Captor
	ArgumentCaptor<Project> projectCaptor;	
	
	@Test
	@DisplayName("Should be able to get all project")
	public void shouldBeAble_ToGetAllProject() {
		
		List<Project> pp = createProjectList();
		
		Mockito.when(service.getAllProjects()).thenReturn(pp);
		
		List<Project> response = service.getAllProjects();
		
		Mockito.verify(repository).findAll();	
		
		Assertions.assertEquals(Project.class, response.get(0).getClass());
		Assertions.assertEquals(3, response.size());		
	}
	
	@Test
	@DisplayName("Should be able to create a new project")
	public void shouldBeAble_ToCreateANewProject() {
		
		ProjectDTO pp = createProjectDTO();	
				
		Mockito.when(peopleRepository.findByPeopleId(anyInt())).thenReturn(createPeople());

		service.insertProject(pp);
		
		Mockito.verify(repository, Mockito.times(1)).save(ArgumentMatchers.any(Project.class));		
		Mockito.verify(repository).save(projectCaptor.capture());		
		Project projectSaved = projectCaptor.getValue();
		Assertions.assertNotNull(projectSaved.getName());
		Assertions.assertNotNull(projectSaved.getDescription());	
		
	}
	
	@Test
	@DisplayName("Should be able to update a project")
	public void shouldBeAble_ToUpdateAProject() {
		
		Optional<Project> project = Optional.of(createProject());
		
		Mockito.when(repository.findById(anyInt())).thenReturn(project);

		service.updateProject(createProjectUpdt());
		
		Mockito.verify(repository, Mockito.times(1)).save(ArgumentMatchers.any(Project.class));		
		Mockito.verify(repository).save(projectCaptor.capture());		
		Project projectSaved = projectCaptor.getValue();
		
		Assertions.assertEquals("alto", projectSaved.getRisk());
		Assertions.assertNotNull(projectSaved.getName());
		Assertions.assertNotNull(projectSaved.getDescription());	
		
	}
	
	@Test
	@DisplayName("Should be able to delete a project")
	public void shouldBeAble_ToDeleteAProject() {
		
		Mockito.doNothing().when(repository).delete(createProjectDel());
		String message = service.deleteProject(createProjectDel());
		
		Mockito.verify(repository, Mockito.times(1)).delete(createProjectDel());
		Assertions.assertEquals("Projeto deletado com sucesso!", message);
	}
	
	@Test
	@DisplayName("Should not be able to delete a project")
	public void shouldNotBeAble_ToDeleteAProject() {
		
		String message = service.deleteProject(createProject());
		
		Mockito.verify(repository, Mockito.times(0)).delete(createProject());
		Assertions.assertEquals("Este projeto não pode ser deletado!", message);
	}
	
	@Test
	@DisplayName("Should be able to get project by id")
	public void shouldBeAble_ToGetProjectById() {
		
		Optional<Project> project = Optional.of(createProject());
		
		Mockito.when(repository.findByProjectId(anyInt())).thenReturn(project);
		
		Project response = service.getProjectsById(1);
		
		Assertions.assertNotNull(response);
		Assertions.assertEquals(Project.class, response.getClass());
		Assertions.assertEquals(1, response.getProjectId());	
	}
	
	@Test
	@DisplayName("Should be able to get a people list by id")
	public void shouldBeAble_ToGetPeopleListById() {
				
		Mockito.when(peopleRepository.findByPeopleId(anyInt())).thenReturn(createPeople());
		
		List<People> response = service.getListPeopleById("1");
		
		Assertions.assertNotNull(response);
		Assertions.assertEquals(People.class, response.get(0).getClass());
		Assertions.assertEquals(1, response.get(0).getPeopleId());
		Assertions.assertEquals(1, response.size());
	}
	
	private ProjectDTO createProjectDTO() {
		
		ProjectDTO project = new ProjectDTO();
		Date now = new Date();
		
		project.setProjectId(1);
		project.setName("Project Test");
		project.setDescription("Project Test Description");
		project.setStartDate(now);
		project.setEndPrevisionDate(now);
		project.setEndDate(now);
		project.setStatus("iniciado");
		project.setBudget((float) 1000.0);
		project.setRisk("medio");
		project.setPeople("1");
		
		return project;
	}
	
	private Project createProject() {
		
		Project project = new Project();
		LocalDate now = LocalDate.now();
		Set<People> people = createPeopleSet();
		
		project.setProjectId(1);
		project.setName("Project Test");
		project.setDescription("Project Test Description");
		project.setStartDate(now);
		project.setEndPrevisionDate(now);
		project.setEndDate(now);
		project.setStatus("iniciado");
		project.setBudget((float) 1000.0);
		project.setRisk("medio");
		project.setPeople(people);
		
		return project;
	}
	
	private Project createProjectUpdt() {
		
		Project project = new Project();
		LocalDate now = LocalDate.now();
		Set<People> people = createPeopleSet();
		
		project.setProjectId(1);
		project.setName("Project Test");
		project.setDescription("Project Test Description");
		project.setStartDate(now);
		project.setEndPrevisionDate(now);
		project.setEndDate(now);
		project.setStatus("iniciado");
		project.setBudget((float) 1000.0);
		project.setRisk("alto");
		project.setPeople(people);
		
		return project;
	}
	
	private Project createProjectDel() {
		
		Project project = new Project();
		LocalDate now = LocalDate.now();
		Set<People> people = createPeopleSet();
		
		project.setProjectId(1);
		project.setName("Project Test");
		project.setDescription("Project Test Description");
		project.setStartDate(now);
		project.setEndPrevisionDate(now);
		project.setEndDate(now);
		project.setStatus("em analise");
		project.setBudget((float) 1000.0);
		project.setRisk("medio");
		project.setPeople(people);
		
		return project;
	}
	
	private List<Project> createProjectList() {
		
		List<Project> projectList = new ArrayList<Project>();
		LocalDate now = LocalDate.now();
		
		Project project = new Project();
		Set<People> people = createPeopleSet();		
		project.setProjectId(1);
		project.setName("Project Test");
		project.setDescription("Project Test Description");
		project.setStartDate(now);
		project.setEndPrevisionDate(now);
		project.setEndDate(now);
		project.setStatus("iniciado");
		project.setBudget((float) 1000.0);
		project.setRisk("medio");
		project.setPeople(people);
		
		Project project2 = new Project();
		Set<People> people2 = createPeopleSetList();		
		project2.setProjectId(2);
		project2.setName("Project Test 2");
		project2.setDescription("Project Test Description 2");
		project2.setStartDate(now);
		project2.setEndPrevisionDate(now);
		project2.setEndDate(now);
		project2.setStatus("em analise");
		project2.setBudget((float) 1000.0);
		project2.setRisk("baixo");
		project2.setPeople(people2);
		
		Project project3 = new Project();
		Set<People> people3 = createPeopleSet();		
		project3.setProjectId(3);
		project3.setName("Project Test 3");
		project3.setDescription("Project Test Description 3");
		project3.setStartDate(now);
		project3.setEndPrevisionDate(now);
		project3.setEndDate(now);
		project3.setStatus("planejado");
		project3.setBudget((float) 1000.0);
		project3.setRisk("alto");
		project3.setPeople(people3);
		
		projectList.add(project);
		projectList.add(project2);
		projectList.add(project3);
		
		return projectList;
	}
	
	private Set<People> createPeopleSet() {
		
		People people = new People();
		Set<People> peopleList = new HashSet<People>();
		people.setPeopleId(1);
		people.setName("People Name Test");
		people.setRole("funcionario");
		
		peopleList.add(people);
		
		return peopleList;
	}
	
	private Set<People> createPeopleSetList() {
		
		Set<People> peopleList = new HashSet<People>();
		
		People people = new People();
		people.setPeopleId(1);
		people.setName("People Name Test");
		people.setRole("funcionario");
		
		People people2 = new People();
		people2.setPeopleId(2);
		people2.setName("People Name Test 2");
		people2.setRole("funcionario");
		
		People people3 = new People();
		people3.setPeopleId(3);
		people3.setName("People Name Test 3");
		people3.setRole("funcionario");
		
		peopleList.add(people);
		peopleList.add(people2);
		peopleList.add(people3);
		
		return peopleList;
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
		
		People pp1 = Mockito.mock(People.class); //new People();	
		pp1.setPeopleId(1);
		pp1.setName("People Name Test");
		pp1.setRole("funcionario");
		people.add(pp1);
		
		People pp2 = Mockito.mock(People.class); //new People();	
		pp2.setPeopleId(2);
		pp2.setName("People Name Test 2");
		pp2.setRole("funcionario");
		people.add(pp2);
		
		People pp3 = Mockito.mock(People.class); //new People();	
		pp3.setPeopleId(3);
		pp3.setName("People Name Test 3");
		pp3.setRole("gerente");
		people.add(pp3);
		
		People pp4 = Mockito.mock(People.class); //new People();	
		pp4.setPeopleId(4);
		pp4.setName("People Name Test 4");
		pp4.setRole("funcionario");
		people.add(pp4);
		
		return people;
	}

}
