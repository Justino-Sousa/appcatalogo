package br.edu.infnet.appcatalogo.model.domain.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.infnet.appcatalogo.model.domain.JogoDeluxe;

@Repository
public interface JogoDeluxeRepository extends CrudRepository<JogoDeluxe, Integer> {

	@Query("from JogoDeluxe jd where jd.usuario.id = :idUser")
	Collection<JogoDeluxe> findAll(Integer idUser);

}