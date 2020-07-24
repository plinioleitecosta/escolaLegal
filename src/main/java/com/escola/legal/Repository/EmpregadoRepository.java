package com.escola.legal.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.escola.legal.Model.Empregado;

public interface EmpregadoRepository extends JpaRepository<Empregado, Long> {
	
	public Empregado findByCodigo(long id);

}
