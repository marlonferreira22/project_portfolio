package br.com.prover.portfolio.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.prover.portfolio.model.Project;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Integer> {

	Optional<Project> findByProjectId(int id);

}
