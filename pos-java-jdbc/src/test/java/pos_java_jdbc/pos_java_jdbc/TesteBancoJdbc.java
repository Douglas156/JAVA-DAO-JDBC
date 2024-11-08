package pos_java_jdbc.pos_java_jdbc;

import java.util.List;

import org.junit.jupiter.api.Test;

import conexaojdbc.SingleConnection;
import dao.UserPosDAO;
import model.BeanUserFone;
import model.Telefone;
import model.Userposjava;

public class TesteBancoJdbc {
	
	@Test
	public void initbanco() {
		UserPosDAO userPosDAO = new UserPosDAO();
		Userposjava userposjava = new Userposjava();
		
		
		userposjava.setNome("Douglas");
		userposjava.setEmail("douglas@gmail.com");
		
		userPosDAO.salvar(userposjava);
	}
	
	
	
	@Test
	public void initAtualizar () {
		try {
		UserPosDAO dao = new UserPosDAO();
		
		Userposjava objetoBanco = dao.buscar(5L);
		
		objetoBanco.setNome("Nome mudado com metodo atualizar");
		
		dao.atualizar(objetoBanco);
		
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	@Test
	public void initDeletar() {
		try {
			UserPosDAO dao = new UserPosDAO();
			dao.deletar(5L);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testeInsertTelefone() {
		
		Telefone telefone = new Telefone();
		telefone.setNumero("(87) 4445-4545");
		telefone.setTipo("Casa");
		telefone.setUsuario(15L);
		
		UserPosDAO manipulador = new UserPosDAO();
		manipulador.salvarTelefone(telefone);
	}
	
	@Test
	public void testeCarregaFoneUser () {
		UserPosDAO daozinho = new UserPosDAO();
		
		
		List<BeanUserFone> listinhaUserFone = daozinho.listaUserFone(9L);
		
		for (BeanUserFone itemDaLista : listinhaUserFone) {
			System.out.println(itemDaLista);
			System.out.println("-----------------------------------------------------");
		}
	}
	
	@Test
	public void testeDelete() {
		
		UserPosDAO instancia = new UserPosDAO();
		
		instancia.deleteFonesPorUser(8L);
	}
	
	
}
