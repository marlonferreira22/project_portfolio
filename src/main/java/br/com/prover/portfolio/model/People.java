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
@Table(name = "Peoples")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class People implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "people_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int peopleId;	
	private String name;
	private String role;
	
	@ManyToMany
	Set<Project> projects = new HashSet<Project>();
}
