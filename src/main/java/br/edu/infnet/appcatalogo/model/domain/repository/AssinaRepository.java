package br.edu.infnet.appcatalogo.model.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.infnet.appcatalogo.model.domain.Assinatura;

@Repository
public interface AssinaRepository extends CrudRepository<Assinatura, Integer> {
	
	@Query("from Assinatura a where a.usuario.id = :id")
	List<Assinatura> obterAssinaturaById(Integer id);
	
}