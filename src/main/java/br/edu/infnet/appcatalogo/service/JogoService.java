package br.edu.infnet.appcatalogo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.appcatalogo.model.domain.Jogo;
import br.edu.infnet.appcatalogo.model.domain.Usuario;
import br.edu.infnet.appcatalogo.model.domain.repository.JogoRepository;

@Service
public class JogoService {
	
	@Autowired
	JogoRepository jogoRepository;

	public List<Jogo> obterLista() {
		return (List<Jogo>) jogoRepository.findAll();
	}
	
	public List<Jogo> obterLista(Usuario usuario) {
		return (List<Jogo>) jogoRepository.findAll(usuario.getId());
	}
	
	public void excluir(Integer id) {
		jogoRepository.deleteById(id);
	}

}
