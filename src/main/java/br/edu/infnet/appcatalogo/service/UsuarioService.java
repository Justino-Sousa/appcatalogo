package br.edu.infnet.appcatalogo.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import br.edu.infnet.appcatalogo.model.domain.Usuario;
import br.edu.infnet.appcatalogo.model.test.AppCatalogo;

@Service
public class UsuarioService {

	private static Map<String, Usuario> mapaUsuario = new HashMap<>();

	public void incluir(Usuario usuario) {

		mapaUsuario.put(usuario.getEmail(), usuario);
		AppCatalogo.relatorio("Inclusão da Usuário " + usuario.getNome() + " realizada com sucesso!", usuario);
	}

	public Collection<Usuario> obterLista() {
		return mapaUsuario.values();
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
