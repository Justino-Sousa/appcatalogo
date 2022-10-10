package br.edu.infnet.appcatalogo.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.appcatalogo.model.domain.Catalogo;
import br.edu.infnet.appcatalogo.model.domain.Usuario;
import br.edu.infnet.appcatalogo.model.domain.repository.CatalogoRepository;
import br.edu.infnet.appcatalogo.model.test.AppCatalogo;

@Service
public class CatalogoService {
	
	@Autowired
	CatalogoRepository catalogoRepository;
	
	public void incluir(Catalogo catalogo) {
		
		catalogoRepository.save(catalogo);
		AppCatalogo.relatorio("Inclusão do Catalogo " + catalogo.getNome() + " realizada com sucesso!", catalogo);
	}

	public Collection<Catalogo> obterLista() {
		return (Collection<Catalogo>) catalogoRepository.findAll();
	}
	
	public Collection<Catalogo> obterLista(Usuario usuario) {
		return (Collection<Catalogo>) catalogoRepository.findAll(usuario.getId());
	}

	public void excluir(Integer id) {
		catalogoRepository.deleteById(id);
	}

}
