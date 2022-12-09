package br.com.senac.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import br.com.senac.model.ArquivoModel;

@Transactional
public interface ArquivoRepository extends JpaRepository<ArquivoModel, Long>{	
	public ArquivoModel findByName(String name);
}