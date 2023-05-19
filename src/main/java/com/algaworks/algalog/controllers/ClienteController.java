package com.algaworks.algalog.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.algaworks.algalog.entities.Cliente;
import com.algaworks.algalog.repositories.ClienteRepository;
import com.algaworks.algalog.services.ClienteService;

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
}
