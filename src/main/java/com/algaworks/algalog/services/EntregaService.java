package com.algaworks.algalog.services;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.algaworks.algalog.entities.Cliente;
import com.algaworks.algalog.entities.Entrega;
import com.algaworks.algalog.entities.enums.StatusEntrega;
import com.algaworks.algalog.repositories.EntregaRepository;

import jakarta.transaction.Transactional;

@Service
public class EntregaService {

	@Autowired
	private ClienteService clienteService;
	
	@Autowired
	private EntregaRepository repo;

	@Transactional
	public Entrega solicitar(Entrega entrega){
		Cliente cliente = clienteService.buscar(entrega.getCliente().getId());
		
		entrega.setCliente(cliente);
		entrega.setStatus(StatusEntrega.PENDENTE);
		entrega.setDataPedido(LocalDateTime.now());
		entrega.setDataFinalizacao(LocalDateTime.now());
		return repo.save(entrega);
	}
	
	public List<Entrega> findAll(){
		return repo.findAll();
	}
}
