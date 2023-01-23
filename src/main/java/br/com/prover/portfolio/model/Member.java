package br.com.prover.portfolio.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Member")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Member implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "member_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int memberId;
	
	/*@Column(name = "project_id")
	private Project projectId;*/
	
	@ManyToMany
	@Column(name = "project_id")
	private Set<Project> project = new HashSet<Project>();
	
	@Column(name = "people_id")
	private People people;
	
	

}
