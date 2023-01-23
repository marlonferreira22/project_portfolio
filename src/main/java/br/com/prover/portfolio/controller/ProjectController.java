package br.com.prover.portfolio.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.prover.portfolio.dto.ProjectDTO;
import br.com.prover.portfolio.model.People;
import br.com.prover.portfolio.model.Project;
import br.com.prover.portfolio.service.PeopleService;
import br.com.prover.portfolio.service.ProjectService;

@Controller
public class ProjectController {
	
	@Autowired
	private ProjectService service;
	
	@Autowired
	private PeopleService peopleService;
	
	@RequestMapping("/")
	public String showList(ModelMap model, HttpServletRequest request) {
				
		List<Project> proj = this.service.getAllProjects();
		
		List<ProjectDTO> projects = new ArrayList<ProjectDTO>();
		
		for (int i = 0; i < proj.size(); i++) {			
			ProjectDTO p = new ProjectDTO();			
			p = p.convertToDTO(proj.get(i));			
			projects.add(p);
		}
	    		
		request.getAttribute("projects");		
	    model.addAttribute("projects", projects);
	     
	    return "project_list";
	}
	
	@RequestMapping("/projectform")
	public String showForm(ModelMap model) {
		ProjectDTO project = new ProjectDTO();
	    List<String> riskList = Arrays.asList("baixo", "medio", "alto");
	    List<String> statusList = Arrays.asList("em analise", " analise realizada", "analise aprovada", "iniciado", "planejado", "em andamento", "encerrado", "cancelado");
	    List<People> managerList = peopleService.getPeopleByRole("gerente");
	     
	    model.addAttribute("project", project);
	    model.addAttribute("riskList", riskList);
	    model.addAttribute("statusList", statusList);
	    model.addAttribute("managerList", managerList);
	     
	    return "project_register_form";
	}
	
	@PostMapping("/projectregister")
	public String submitForm(@ModelAttribute("project") ProjectDTO proj, BindingResult result,
            ModelMap model) {
	     
	    this.service.insertProject(proj);
	    	     
	    return "redirect:/";
	}
	
	
	@RequestMapping("/projectedit")
	public String showEditForm(Model model, HttpServletRequest request) {
		
		int id = Integer.parseInt(request.getParameter("id"));
		Project project = this.service.getProjectsById(id);
	    List<String> riskList = Arrays.asList("baixo", "medio", "alto");
	    List<String> statusList = Arrays.asList("em analise", " analise realizada", "analise aprovada", "iniciado", "planejado", "em andamento", "encerrado", "cancelado");
	    List<People> managerList = peopleService.getPeopleByRole("gerente");
	     
	    model.addAttribute("project", project);
	    model.addAttribute("riskList", riskList);
	    model.addAttribute("statusList", statusList);
	    model.addAttribute("managerList", managerList);
	     
	    return "project_edit_form";
	}
	
	@PostMapping("/projectupdate")
	public String submitEditForm(@ModelAttribute("project") Project proj) {
	     
	    this.service.updateProject(proj);
	     
	    return "redirect:/";
	}
	
	@RequestMapping("/projectdelete")
	public String showDeleteForm(Model model, HttpServletRequest request) {
		
		int id = Integer.parseInt(request.getParameter("id"));
		Project project = this.service.getProjectsById(id);
	    List<String> riskList = Arrays.asList("baixo", "medio", "alto");
	    List<String> statusList = Arrays.asList("em analise", " analise realizada", "analise aprovada", "iniciado", "planejado", "em andamento", "encerrado", "cancelado");
	    List<People> managerList = peopleService.getPeopleByRole("gerente");
	     
	    model.addAttribute("project", project);
	    model.addAttribute("riskList", riskList);
	    model.addAttribute("statusList", statusList);
	    model.addAttribute("managerList", managerList);
	     
	    return "project_delete_form";
	}
	
	@PostMapping("/projectexclude")
	public String submitExcludeForm(@ModelAttribute("project") Project proj) {
	     
	    this.service.deleteProject(proj);
	    
	    return "redirect:/";
	}
	
}
