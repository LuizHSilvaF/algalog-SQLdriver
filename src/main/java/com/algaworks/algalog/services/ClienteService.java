package com.algaworks.algalog.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.algaworks.algalog.entities.Cliente;
import com.algaworks.algalog.repositories.ClienteRepository;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository repo;
	
	public List<Cliente> findAll(){
		return repo.findAll();
	}
	
	public Cliente findById(Long id) {
		return repo.findById(id).get();
	}
	
	public Cliente adicionar(Cliente cliente) {
		return repo.save(cliente);
	}
	
	public Cliente atualizar(Long id, Cliente cliente) {
		cliente.setId(id);
		return repo.save(cliente);
	}
}
