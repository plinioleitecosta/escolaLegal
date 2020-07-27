package com.escola.legal;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.isEmptyString;
import static org.hamcrest.Matchers.not;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.doThrow;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.escola.legal.model.Empregado;
import com.escola.legal.repository.EmpregadoRepository;
import com.escola.legal.service.EmpregadoService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;



@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT) // porta aleatória
@AutoConfigureMockMvc
public class EmpregadoResourceTest {
	
	public static final String BASE_PATH = "/api/v1/escolalegal/empregados/";	
	
	private MockMvc mockMvc;
	private ObjectMapper mapper;
	
	
	@Mock
	private EmpregadoRepository empregadoRepository;
	
	@InjectMocks
	private EmpregadoService empregadoService;
	
	@SuppressWarnings("deprecation")
	@Test
	public void listarTodos() throws Exception{
		
		final String complementoURL = "/v1/listar";

		final MockHttpServletResponse response = this.mockMvc.perform(get(BASE_PATH + complementoURL))
	    	.andDo(print())
	    	.andExpect(status().isOk())
	        .andReturn().getResponse();		
		assertThat("Response não pode ser vazia.", response.getContentAsString(), not(isEmptyString()));
	}	
	
	@Test
	public void salvar(@RequestBody Empregado empregado) throws JsonProcessingException, Exception{
		
		this.mockMvc.perform(post(BASE_PATH + "/v1/adicionar")
				.contentType(APPLICATION_JSON)
				.content(mapper.writeValueAsString(new Empregado())))
			.andDo(print())
			.andExpect(status().isOk())
			.andReturn();		
	}	
	
	@Test
	public void excluir(@PathVariable long codigo) throws JsonProcessingException, Exception{
		
		this.mockMvc.perform(delete(BASE_PATH + "/v1/excluir")
				.contentType(APPLICATION_JSON)
				.content(mapper.writeValueAsString(new Empregado())))
			.andDo(print())
			.andExpect(status().isOk())
			.andReturn();		
	}
	
	@Test
	public void atualizar(@PathVariable Long codigo, @RequestBody Empregado empregado) throws JsonProcessingException, Exception{
		this.mockMvc.perform(put(BASE_PATH + "/v1/atualizar")
				.contentType(APPLICATION_JSON)
				.content(mapper.writeValueAsString(new Empregado())))
			.andDo(print())
			.andExpect(status().isOk())
			.andReturn();
	}	
	
	

}
