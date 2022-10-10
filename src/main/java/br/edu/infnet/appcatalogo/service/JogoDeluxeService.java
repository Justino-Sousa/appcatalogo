package br.edu.infnet.appcatalogo.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.appcatalogo.model.domain.JogoDeluxe;
import br.edu.infnet.appcatalogo.model.domain.Usuario;
import br.edu.infnet.appcatalogo.model.domain.repository.JogoDeluxeRepository;
import br.edu.infnet.appcatalogo.model.test.AppCatalogo;

@Service
public class JogoDeluxeService {

	@Autowired
	private JogoDeluxeRepository jogoDeluxeRepository;
	
	public void incluir(JogoDeluxe jogo) {

		jogoDeluxeRepository.save(jogo);
		AppCatalogo.relatorio("Inclusão do jogo " + jogo.getNome() + " realizada com sucesso!", jogo);
	}

	public Collection<JogoDeluxe> obterLista() {
		return (Collection<JogoDeluxe>) jogoDeluxeRepository.findAll();
	}
	
	public Collection<JogoDeluxe> obterLista(Usuario usuario) {
		return (Collection<JogoDeluxe>) jogoDeluxeRepository.findAll(usuario.getId());
	}

	public void excluir(Integer id) {
		jogoDeluxeRepository.deleteById(id);
	}
}
