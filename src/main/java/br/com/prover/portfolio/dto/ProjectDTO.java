package br.com.prover.portfolio.dto;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

import br.com.prover.portfolio.model.Project;
import lombok.Data;

@Data
public class ProjectDTO {
	
	private int projectId;	
	private String name;
	private String description;
	private Date startDate;
	private Date endPrevisionDate;
	private Date endDate;
	private String status;
	private Float budget;
	private String risk;
	private String people;
	
	public ProjectDTO convertToDTO(Project proj) {
		
		ProjectDTO projDTO = new ProjectDTO();
		
		projDTO.setProjectId(proj.getProjectId());
		projDTO.setName(proj.getName());
		projDTO.setDescription(proj.getDescription());
		projDTO.setStartDate(convertToDate(proj.getStartDate()));
		projDTO.setEndPrevisionDate(convertToDate(proj.getEndPrevisionDate()));
		projDTO.setEndDate(convertToDate(proj.getEndDate()));
		projDTO.setStatus(proj.getStatus());
		projDTO.setBudget(proj.getBudget());
		projDTO.setRisk(proj.getRisk());
		
		return projDTO;
	}
	
	public Date convertToDate(LocalDate local) {
		
		ZoneId defaultZoneId = ZoneId.systemDefault();		
		Date date = Date.from(local.atStartOfDay(defaultZoneId).toInstant());
		
		return date;
	}

}
