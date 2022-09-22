package br.edu.infnet.appcatalogo.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import br.edu.infnet.appcatalogo.model.domain.Catalogo;
import br.edu.infnet.appcatalogo.model.test.AppCatalogo;

@Service
public class CatalogoService {
	private static Map<Integer, Catalogo> mapaCatalogo = new HashMap<>();
	private static Integer codigo = 1;

	public void incluir(Catalogo catalogo) {

		catalogo.setCodigo(codigo++);
		mapaCatalogo.put(catalogo.getCodigo(), catalogo);
		AppCatalogo.relatorio("Inclusão do Catalogo " + catalogo.getNome() + " realizada com sucesso!", catalogo);
	}

	public Collection<Catalogo> obterLista() {
		return mapaCatalogo.values();
	}

	public void excluir(Integer id) {
		mapaCatalogo.remove(id);
	}

}
