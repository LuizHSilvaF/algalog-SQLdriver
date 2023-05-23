package com.algaworks.algalog.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.algaworks.algalog.entities.Entrega;
import com.algaworks.algalog.repositories.EntregaRepository;
import com.algaworks.algalog.services.EntregaService;

import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/entregas")
public class EntregaController {

	@Autowired
	private EntregaRepository repo;
	
	@Autowired
	private EntregaService service;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Entrega solicitar(@Valid @RequestBody Entrega entrega) {
		return service.solicitar(entrega);
	}
	
	@GetMapping
	public List<Entrega> findAll(){
		return service.findAll();
	}
	
	@GetMapping("/{entregaId}")
	public ResponseEntity<Entrega> buscar(@PathVariable Long entregaId){
		return repo.findById(entregaId).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
	}
}
