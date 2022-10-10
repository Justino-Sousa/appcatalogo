package br.edu.infnet.appcatalogo.model.domain.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.infnet.appcatalogo.model.domain.JogoBasic;

@Repository
public interface JogoBasicRepository extends CrudRepository<JogoBasic, Integer> {

	@Query("from JogoBasic jb where jb.usuario.id = :idUser")
	Collection<JogoBasic> findAll(Integer idUser);

}