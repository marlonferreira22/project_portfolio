package br.com.prover.portfolio.service;

import java.time.ZoneId;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.prover.portfolio.dto.ProjectDTO;
import br.com.prover.portfolio.model.People;
import br.com.prover.portfolio.model.Project;
import br.com.prover.portfolio.repository.PeopleRepository;
import br.com.prover.portfolio.repository.ProjectRepository;

@Service
public class ProjectService {
	
	@Autowired
	private ProjectRepository repository;
	
	@Autowired
	private PeopleRepository peopleRepository;

	public List<Project> getAllProjects() {
		
		List<Project> projects = repository.findAll();
		
		return projects;
	}
	
	public Project insertProject(ProjectDTO proj) {
		
		Project project = new Project();
		List<People> people = getListPeopleById(proj.getPeople());
		if(!people.isEmpty()) {
			Set<People> peopleSet = new HashSet<People>(people);
			project.setPeople(peopleSet);
		}
		
		project.setName(proj.getName());
		project.setDescription(proj.getDescription());
		project.setStartDate(proj.getStartDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
		project.setEndPrevisionDate(proj.getEndPrevisionDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
		project.setEndDate(proj.getEndDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
		project.setStatus(proj.getStatus());
		project.setBudget(proj.getBudget());
		project.setRisk(proj.getRisk());
		
		
		Project pReturn = repository.save(project);
		
		return pReturn;
	}
	
	public Project updateProject(Project proj) {
		
		Optional<Project> project = repository.findById(proj.getProjectId());
		
		project.get().setPeople(validPeopleList(proj.getPeople(), project.get().getPeople()));		
		project.get().setName(proj.getName());
		project.get().setDescription(proj.getDescription());
		project.get().setStartDate(proj.getStartDate());
		project.get().setEndPrevisionDate(proj.getEndPrevisionDate());
		project.get().setEndDate(proj.getEndDate());
		project.get().setStatus(proj.getStatus());
		project.get().setBudget(proj.getBudget());
		project.get().setRisk(proj.getRisk());		
		
		repository.save(project.get());
				
		return project.get();
	}
	
	public String deleteProject(Project proj) {
		String message = "";
		if(proj.getStatus().equalsIgnoreCase("iniciado") || proj.getStatus().equalsIgnoreCase("em andamento") || proj.getStatus().equalsIgnoreCase("encerrado")) {
			message = "Este projeto não pode ser deletado!";
			
		} else {
			repository.delete(proj);
			message = "Projeto deletado com sucesso!";			
		}
		
		return message;
	}

	public Project getProjectsById(int id) {
		Optional<Project> project = repository.findByProjectId(id);
		return project.get();
	}
	
	public List<People> getListPeopleById(String p){
		
		List<People> pList = new ArrayList<People>();
		
		if(p != null && !p.isEmpty() && !p.trim().isEmpty()) {
			
			String[] arrOfStr = p.split(",");			
			
			for (String a : arrOfStr) {				
				People pp = new People();			
				pp = peopleRepository.findByPeopleId((Integer.valueOf(a)));
				if(pp != null && pp.getRole().equalsIgnoreCase("funcionario"))
					pList.add(pp);
			}			
		}
		return pList;
	}
	
	public Set<People> validPeopleList(Set<People> pForm, Set<People> pBd){
		
		boolean result = pForm.equals(pBd);
		
		if(result)
			return pBd;
		
		return pForm;
	}
}
