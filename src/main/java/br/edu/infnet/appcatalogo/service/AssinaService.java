package br.edu.infnet.appcatalogo.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import br.edu.infnet.appcatalogo.model.domain.Assinatura;
import br.edu.infnet.appcatalogo.model.test.AppCatalogo;

@Service
public class AssinaService {

	private static Map<Integer, Assinatura> mapaAssinatura = new HashMap<>();
	private static Integer codigo = 1;

	public  void incluir(Assinatura assinatura) {

		assinatura.setCodigo(codigo++);
		mapaAssinatura.put(assinatura.getCodigo(), assinatura);
		AppCatalogo.relatorio("Inclusão da Assinatura " + assinatura.getNome() + " realizada com sucesso!", assinatura);
	}

	public  Collection<Assinatura> obterLista() {
		return mapaAssinatura.values();
	}

	public  void excluir(Integer id) {
		mapaAssinatura.remove(id);
	}

}
