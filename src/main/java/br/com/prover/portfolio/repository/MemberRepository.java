package br.com.prover.portfolio.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.prover.portfolio.model.Member;

public interface MemberRepository extends JpaRepository<Member, Integer>{

}
