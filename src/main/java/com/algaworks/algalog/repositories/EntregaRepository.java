package com.algaworks.algalog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.algaworks.algalog.entities.Entrega;

@Repository
public interface EntregaRepository extends JpaRepository<Entrega, Long>{

}
