package br.edu.infnet.appcatalogo.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.appcatalogo.model.domain.JogoPremium;
import br.edu.infnet.appcatalogo.model.domain.Usuario;
import br.edu.infnet.appcatalogo.model.domain.repository.JogoPremiumRepository;
import br.edu.infnet.appcatalogo.model.test.AppCatalogo;

@Service
public class JogoPremiumService {
	
	@Autowired
	JogoPremiumRepository jogoPremiumRepository;

	public void incluir(JogoPremium jogo) {

		jogoPremiumRepository.save(jogo);
		AppCatalogo.relatorio("Inclusão do jogo " + jogo.getNome() + " realizada com sucesso!", jogo);
	}

	public Collection<JogoPremium> obterLista() {
		return (Collection<JogoPremium>) jogoPremiumRepository.findAll();
	}
	
	public Collection<JogoPremium> obterLista(Usuario usuario) {
		return (Collection<JogoPremium>) jogoPremiumRepository.findAll(usuario.getId());
	}

	public void excluir(Integer id) {
		jogoPremiumRepository.deleteById(id);
	}
}
