package br.edu.infnet.appcatalogo.model.domain.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.infnet.appcatalogo.model.domain.Catalogo;

@Repository
public interface CatalogoRepository extends CrudRepository<Catalogo, Integer> {

	@Query("from Catalogo c where c.usuario.id = :idUser")
	Collection<Catalogo> findAll(Integer idUser);

}