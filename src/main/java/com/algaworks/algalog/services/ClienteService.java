package com.algaworks.algalog.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.algaworks.algalog.entities.Cliente;
import com.algaworks.algalog.exception.NegocioException;
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
	
	public Cliente buscar(Long clienteId) {
		return repo.findById(clienteId).orElseThrow(() -> new NegocioException("Cliente não encontrado"));
	}
	
	public Cliente salvar(Cliente cliente) {
		boolean emailEMUso = repo.findByEmail(cliente.getEmail()).stream().anyMatch(clienteExistente -> !clienteExistente.equals(cliente));
		
		if(emailEMUso) {
			throw new NegocioException("Já existe um cliente cadastrado com esse e-mail.");
	}
		return repo.save(cliente);
	}
	
	
	
	public void excluir(Long id) {
		repo.deleteById(id);
	}
}
