package br.com.prover.portfolio.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Project")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Project implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "project_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int projectId;
	
	private String name;
	private String description;
	
	@DateTimeFormat(pattern="dd/MM/yyyy")
	private LocalDate startDate;
	
	@DateTimeFormat(pattern="dd/MM/yyyy")
	private LocalDate endPrevisionDate;
	
	@DateTimeFormat(pattern="dd/MM/yyyy")
	private LocalDate endDate;
	
	private String status;
	private Float budget;
	private String risk;
	
	@ManyToOne
	private People manager;
	
	@ManyToMany
	private Set<Member> member = new HashSet<Member>();
	
	/*@ManyToMany
	private Set<People> people = new HashSet<People>();*/
	

}
