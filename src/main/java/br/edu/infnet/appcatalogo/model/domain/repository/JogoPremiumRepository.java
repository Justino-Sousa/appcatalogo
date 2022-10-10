package br.edu.infnet.appcatalogo.model.domain.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.infnet.appcatalogo.model.domain.JogoPremium;

@Repository
public interface JogoPremiumRepository extends CrudRepository<JogoPremium, Integer> {

	@Query("from JogoPremium jp where jp.usuario.id = :idUser")
	Collection<JogoPremium> findAll(Integer idUser);

}