package br.edu.infnet.appcatalogo;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import br.edu.infnet.appcatalogo.model.domain.Assinatura;
import br.edu.infnet.appcatalogo.model.domain.Catalogo;
import br.edu.infnet.appcatalogo.model.domain.Jogo;
import br.edu.infnet.appcatalogo.model.domain.JogoBasic;
import br.edu.infnet.appcatalogo.model.domain.Usuario;
import br.edu.infnet.appcatalogo.model.exceptions.AssinaturaNullException;
import br.edu.infnet.appcatalogo.model.exceptions.CatalogoSemJogosException;
import br.edu.infnet.appcatalogo.service.CatalogoService;

@Component
@Order(6)
public class CatalogoTeste implements ApplicationRunner {

	@Autowired
	CatalogoService catalogoService;

	@Override
	public void run(ApplicationArguments args) {

		Usuario usuario = new Usuario();
		usuario.setId(1);

		Assinatura assinatura = new Assinatura();
		assinatura.setCodigo(1);

		Set<Jogo> jogos = new HashSet<Jogo>();

		JogoBasic jb = new JogoBasic();
		jb.setCodigo(1);
		JogoBasic jb2 = new JogoBasic();
		jb2.setCodigo(2);
		JogoBasic jb3 = new JogoBasic();
		jb3.setCodigo(3);
		Catalogo catalogo;
		try {

			catalogo = new Catalogo(assinatura, jogos);
			catalogo.setDescricao("Catalogo de Jogos primários");
			catalogo.setNome("Catalogo A");
			catalogo.setUsuario(usuario);
			jogos.add(jb);
			jogos.add(jb2);
			jogos.add(jb3);

			catalogoService.incluir(catalogo);

		} catch (AssinaturaNullException e) {
			e.printStackTrace();
		} catch (CatalogoSemJogosException e) {
			e.printStackTrace();
		}

		//
//		// Inicio do catalogo
//		System.out.println("### Catalogo início ####" + "\r\n");
//
//		String dir = "/home/justino/Documentos/Programação/STS-workspace/appcatalogo/data/";
//		String arq = "catalogo.txt";
//
//		try {
//			FileReader fileReader = new FileReader(dir + arq);
//			BufferedReader leitura = new BufferedReader(fileReader);
//			String linha = leitura.readLine();
//			Set<Jogo> jogos = null;
//			List<Catalogo> catalogos = new ArrayList<Catalogo>();
//
//			while (linha != null) {
//
//				String[] campos = linha.split("[;]");
//
//				switch (campos[0].toUpperCase()) {
//
//				case "C":
//					try {
//
//						Assinatura a1 = new Assinatura(campos[1], campos[2],
//								BigDecimal.valueOf(Double.valueOf(campos[3])));
//
//						jogos = new HashSet<Jogo>();
//
//						Catalogo c1 = new Catalogo(a1, jogos);
//
//						c1.setDescricao(campos[4]);
//						c1.setNome(campos[5]);
//						catalogos.add(c1);
//
//					} catch (AssinaturaNullException | PrecoInvalidoException | CatalogoSemJogosException e) {
//						System.out.println("[ERROR - Pedido] " + e.getMessage());
//					}
//
//					break;
//
//				case "JB":
//					try {
//						JogoBasic jb = new JogoBasic();
//						jb.setValor(BigDecimal.valueOf(Double.valueOf(campos[1])));
//						jb.setDescricao(campos[2]);
//						jb.setGenero(campos[3]);
//						jb.setDesenvolvedor(campos[4]);
//						jb.setNome(campos[5]);
//						jogos.add(jb);
//						System.out.println("Calculo de venda avulsa: " + jb.calcularVendaAvulsa());
//					} catch (ValorZeradoException e) {
//						System.out.println("[ERROR - JogoBasic] " + e.getMessage());
//					}
//					break;
//
//				case "JP":
//					try {
//						JogoPremium jp = new JogoPremium();
//						jp.setValor(BigDecimal.valueOf(Double.valueOf(campos[1])));
//						jp.setDescricao(campos[2]);
//						jp.setGenero(campos[3]);
//						jp.setDesenvolvedor(campos[4]);
//						jp.setNome(campos[5]);
//						jogos.add(jp);
//						System.out.println("Calculo de venda avulsa: " + jp.calcularVendaAvulsa());
//					} catch (ValorInvalidoException e) {
//						System.out.println("[ERROR - JogoPremium] " + e.getMessage());
//					}
//					break;
//
//				case "JD":
//					try {
//						JogoDeluxe jd = new JogoDeluxe();
//						jd.setValor(BigDecimal.valueOf(Double.valueOf(campos[1])));
//						jd.setDescricao(campos[2]);
//						jd.setGenero(campos[3]);
//						jd.setDesenvolvedor(campos[4]);
//						jd.setNome(campos[5]);
//						jogos.add(jd);
//						System.out.println("Calculo de venda avulsa: " + jd.calcularVendaAvulsa());
//					} catch (GeneroNaoPodeSerNull e) {
//						System.out.println("[ERROR - JogoDeluxe] " + e.getMessage());
//					}
//					break;
//
//				default:
//					break;
//				}
//
//				linha = leitura.readLine();
//			}
//
//			for (Catalogo c : catalogos) {
//				catalogoService.incluir(c);
//			}
//
//			leitura.close();
//			fileReader.close();
//
//		} catch (FileNotFoundException e) {
//			System.out.println("[ERROR] O arquivo não existe!");
//		} catch (IOException e) {
//			System.out.println("[ERROR] Problema no fechamento do arquivo!");
//		}
//
//		finally {
//			System.out.println("### Fim do carregamento");
//		}
//
//		// Fim do catalogo
//		System.out.println("\r\n" + "### Catalogo Fim ####" + "\r\n");
//
	}
}
