package com.escola.legal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.escola.legal.model.Empregado;

public interface EmpregadoRepository extends JpaRepository<Empregado, Long> {
	
	public Empregado findByCodigo(long id);

}
