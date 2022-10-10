package br.edu.infnet.appcatalogo.model.domain.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.infnet.appcatalogo.model.domain.Jogo;

@Repository
public interface JogoRepository extends CrudRepository<Jogo, Integer> {

	@Query("from Jogo j where j.usuario.id = :idUser")
	Collection<Jogo> findAll(Integer idUser);

}