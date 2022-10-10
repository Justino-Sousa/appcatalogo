package br.edu.infnet.appcatalogo.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.appcatalogo.model.domain.JogoBasic;
import br.edu.infnet.appcatalogo.model.domain.Usuario;
import br.edu.infnet.appcatalogo.model.domain.repository.JogoBasicRepository;
import br.edu.infnet.appcatalogo.model.test.AppCatalogo;

@Service
public class JogoBasicService {

	@Autowired
	private JogoBasicRepository jogoBasicRepository;

	public void incluir(JogoBasic jogo) {

		jogoBasicRepository.save(jogo);
		AppCatalogo.relatorio("Inclusão do jogo " + jogo.getNome() + " realizada com sucesso!", jogo);
	}

	public Collection<JogoBasic> obterLista() {
		return (Collection<JogoBasic>) jogoBasicRepository.findAll();
	}
	
	public Collection<JogoBasic> obterLista(Usuario usuario) {
		return (Collection<JogoBasic>) jogoBasicRepository.findAll(usuario.getId());
	}

	public void excluir(Integer id) {
		jogoBasicRepository.deleteById(id);
	}
}
