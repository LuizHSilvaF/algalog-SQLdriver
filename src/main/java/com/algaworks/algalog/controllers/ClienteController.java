package com.algaworks.algalog.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.algaworks.algalog.entities.Cliente;
import com.algaworks.algalog.services.ClienteService;

import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/clientes")
public class ClienteController {

	@Autowired
	private ClienteService service;
	
	@GetMapping
	public List<Cliente> findAll(){
		return service.findAll(); 
	}
	
	@GetMapping(value = "/{id}")
	public Cliente findById(@PathVariable Long id){
		return service.findById(id);
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Cliente adicionar(@Valid @RequestBody Cliente cliente) {
		return service.salvar(cliente);
	}
	
	@PutMapping(value = "/{id}")
	public Cliente atualizar(@PathVariable Long id,@Valid @RequestBody Cliente cliente) {
		cliente.setId(id);
		return service.salvar(cliente);
	}
	
	@DeleteMapping(value = "/{id}")
	public void excluir(@PathVariable Long id) {
		service.excluir(id);
	}
}
