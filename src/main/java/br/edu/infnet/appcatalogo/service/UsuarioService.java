package br.edu.infnet.appcatalogo.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.appcatalogo.model.domain.Usuario;
import br.edu.infnet.appcatalogo.model.domain.repository.UsuarioRepository;
import br.edu.infnet.appcatalogo.model.test.AppCatalogo;

@Service
public class UsuarioService {

	private static Map<String, Usuario> mapaUsuario = new HashMap<>();
	
	@Autowired
	private UsuarioRepository usuarioRepository;

	public void incluir(Usuario usuario) {

		mapaUsuario.put(usuario.getEmail(), usuario);
		usuarioRepository.save(usuario);
		AppCatalogo.relatorio("Inclusão da Usuário " + usuario.getNome() + " realizada com sucesso!", usuario);
	}

	public Collection<Usuario> obterLista() {
		return (Collection<Usuario>) usuarioRepository.findAll();
		
	}

	public Usuario validar(String email, String senha) {

		Usuario usuario = mapaUsuario.get(email);

		if (usuario != null && senha.equals(usuario.getSenha())) {
			return usuario;
		}
		return null;
	}

	public void excluir(String email) {
		mapaUsuario.remove(email);
	}

}
