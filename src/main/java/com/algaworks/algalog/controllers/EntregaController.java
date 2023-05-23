package com.algaworks.algalog.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.algaworks.algalog.entities.Entrega;
import com.algaworks.algalog.services.EntregaService;

@RestController
@RequestMapping(value = "/entregas")
public class EntregaController {

	@Autowired
	private EntregaService service;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Entrega solicitar(@RequestBody Entrega entrega) {
		return service.solicitar(entrega);
	}
	
	@GetMapping
	public List<Entrega> findAll(){
		return service.findAll();
	}
}
