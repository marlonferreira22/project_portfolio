package br.com.prover.portfolio.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.prover.portfolio.model.People;

@Repository
public interface PeopleRepository extends JpaRepository<People, Integer> {

	List<People> findByRole(String name);

	People findByPeopleId(Integer id);

}
