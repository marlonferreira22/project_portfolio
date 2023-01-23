package br.com.prover.portfolio.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.prover.portfolio.dto.ProjectDTO;
import br.com.prover.portfolio.model.People;
import br.com.prover.portfolio.model.Project;
import br.com.prover.portfolio.service.PeopleService;
import br.com.prover.portfolio.service.ProjectService;

@Controller
public class MemberController {
	
	@Autowired
	private ProjectService projectService;
	
	@Autowired
	private PeopleService peopleService;

	@RequestMapping("/memberedit")
	public String showEditForm(Model model, HttpServletRequest request) {
		
		int id = Integer.parseInt(request.getParameter("id"));
		Project project = projectService.getProjectsById(id);
	    List<People> memberList = peopleService.getPeopleByRole("funcionario");
	     
	    model.addAttribute("project", project);
	    model.addAttribute("memberList", memberList);
	     
	    return "member_edit_form";
	}
	
	@PostMapping("/memberinsert")
	public String submitEditForm(@ModelAttribute("project") ProjectDTO proj) {
	     //System.out.println(proj.toString());
	    projectService.insertMemberProject(proj);
	     
	    return "redirect:/";
	}
}
