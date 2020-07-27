package com.escola.legal.resource;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.escola.legal.model.Empregado;
import com.escola.legal.service.EmpregadoService;

@RestController
@RequestMapping("/empregado")
public class EmpregadoResource {
	
	@Autowired
	EmpregadoService empregadoService;
	
	
	@GetMapping("/v1/listar")
	public Collection<Empregado> listarTodos(){
		return empregadoService.listarTodos();
	}
	
	@PostMapping("/v1/adicionar")
	public ResponseEntity<Empregado> salvar(@RequestBody Empregado empregado){
		
		try {
			Empregado empregadoSalvo = empregadoService.salvar(empregado);
			return ResponseEntity.status(HttpStatus.CREATED).body(empregadoSalvo);	
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
	
	@DeleteMapping("/v1/excluir/{codigo}")
	public ResponseEntity<Empregado> excluir(@PathVariable long codigo){
		
		try {
			Empregado empregado = empregadoService.porId(codigo);
			if(empregado != null) {
				empregadoService.excluir(codigo);
				return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
			}else{
				return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
			}
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
	
	@PutMapping("/v1/atualizar/{codigo}")
	public ResponseEntity<Empregado> atualizar(@PathVariable Long codigo, @RequestBody Empregado empregado){
		try {
			Empregado empregadoSalvo = empregadoService.porId(codigo);
			if(empregadoSalvo != null) {
				empregadoSalvo = empregadoService.salvar(empregado);
				return ResponseEntity.ok(empregadoSalvo);	
			}else{
				return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
			}			
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
	

}
