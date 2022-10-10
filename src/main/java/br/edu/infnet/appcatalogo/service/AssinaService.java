package br.edu.infnet.appcatalogo.service;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.appcatalogo.model.domain.Assinatura;
import br.edu.infnet.appcatalogo.model.domain.Usuario;
import br.edu.infnet.appcatalogo.model.domain.repository.AssinaRepository;

@Service
public class AssinaService {
	
	@Autowired
	AssinaRepository assinaRepository;

	public void incluir(Assinatura assinatura) {
		
		assinaRepository.save(assinatura);
		
	}

	public Collection<Assinatura> obterLista() {  
		
		List<Assinatura> assinaturas = (List<Assinatura>) assinaRepository.findAll(); 
		return assinaturas;
	}
	
	public Collection<Assinatura> obterLista(Usuario usuario) {  
		 
		return assinaRepository.obterAssinaturaById(usuario.getId());
	}

	public void excluir(Integer id) {
		assinaRepository.deleteById(id);
	}
	
	public Assinatura getAssinaByTipo(String tipo) {
		Collection<Assinatura> assinaturas = obterLista();
		for (Assinatura a : assinaturas) {
			if(a.getTipoAssinatura().toString().equals(tipo)) {
				return a;
			}
		}
		return null;
	}
	

}
