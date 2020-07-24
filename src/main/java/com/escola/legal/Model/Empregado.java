package com.escola.legal.Model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="EMPREGADO")
@Getter
@Setter
public class Empregado implements Serializable{
	
 @Id
 @GeneratedValue(strategy =  GenerationType.IDENTITY)
 @Column(name = "IDEMPREGADO")
 private Long codigo;
 
 @Column(name = "NMEMPREGADO")
 private String nomeEmpregado;
 
 @Temporal(TemporalType.DATE)
 @Column(name = "DTNASCIMENTO")
 private Date dataNascimento;
 
 @Temporal(TemporalType.DATE)
 @Column(name = "DTCONTRATACAO")
 private Date dataContratacao;
 
 	@Column(name ="NMLOGRADOURO")
	private String logradouro;
	
	@Column(name ="NUENDERECO")
	private String numero;
	
	@Column(name ="COMPLEMENTO")
	private String complemento;
	
	@Column(name ="BAIRRO")
	private String bairro;
	
	@Column(name ="CIDADE")
	private String cidade;
	
	@Column(name ="ESTADO")
	private String estado; 
	
	

}
