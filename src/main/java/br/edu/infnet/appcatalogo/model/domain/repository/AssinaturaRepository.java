package br.edu.infnet.appcatalogo.model.domain.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.infnet.appcatalogo.model.domain.Assinatura;

@Repository
public interface AssinaturaRepository extends CrudRepository<Assinatura, Integer> {

}
