package com.escola.legal.Service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.escola.legal.Model.Empregado;
import com.escola.legal.Repository.EmpregadoRepository;

@Service
public class EmpregadoService {
	
	@Autowired
	public EmpregadoRepository empregadoRepository;
	
	public Empregado porId(long id) {
		return empregadoRepository.findByCodigo(id);
	}
	
	public Empregado salvar(Empregado empregado) {
		return empregadoRepository.save(empregado);
	}
	
	public void excluir(Long idEmpregado) {
		Empregado empregado = new Empregado();
		empregado = porId(idEmpregado);
		if(empregado != null) {
			empregadoRepository.delete(empregado);
		}
	}
	
	public Collection<Empregado> listarTodos(){
		return empregadoRepository.findAll();
	}
	

}
