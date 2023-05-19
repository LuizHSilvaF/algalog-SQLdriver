package com.algaworks.algalog.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.algaworks.algalog.entities.Cliente;
import com.algaworks.algalog.repositories.ClienteRepository;
import com.algaworks.algalog.services.ClienteService;

@RestController
public class ClienteController {

	@Autowired
	private ClienteService service;
	
	@GetMapping(value = "/clientes")
	public List<Cliente> findAll(){
		return service.findAll(); 
	}
}
