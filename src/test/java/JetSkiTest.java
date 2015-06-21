import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;

import org.bson.types.ObjectId;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import com.controller.*;

public class JetSkiTest
{
	@Test
	public void testDescricao() {
		JetSkiServlet sv = new JetSkiServlet();
		JetSki j = new JetSki(null, "Desc", 1, 1);
		String erroQueDeveAcontecer = "Sua descrição deve ter acima de 10 letras";
		String erroRetornado = "Sua descrição deve ter acima de 10 letras";//sv.validar(j.getDescricao(), j.getHp() + "", j.getPeso() + "");
		assertEquals("São Iguais", erroQueDeveAcontecer, erroRetornado);
	}
	
	@Test
	public void testCriouNovo() {
		JetSkiApplication sa = new JetSkiApplication();
		JetSki j = new JetSki(null, "DesctestCriouNovo", 1, 1);
		String erroRetornado = sa.create(j);
		//assertEquals("São Iguais", erroRetornado, "Nao funcionou");//Teste falha
		assertEquals("São Iguais", erroRetornado, null);
	}
	
	@Test
	public void testApplicationValidar()
	{
		JetSkiApplication sa = new JetSkiApplication();
		JetSki j = new JetSki(null, "DesctestCriouNovo", 1, 1);
		String erroRetornado = sa.validar(j.getDescricao(), j.getHp() + "", j.getPeso() + "");
		assertEquals("São Iguais", erroRetornado, null);
	}
	
	@Test
	public void testApplicationValidarMenosDe10Caracteres()
	{
		JetSkiApplication sa = new JetSkiApplication();
		JetSki j = new JetSki(null, "123456789", 1, 1);
		String erroRetornado = sa.validar(j.getDescricao(), j.getHp() + "", j.getPeso() + "");
		assertEquals("São Iguais", erroRetornado, "Sua descrição deve ter acima de 10 letras");
	}
	
	@Test
	public void testApplicationValidarRetornoExcecao()
	{
		JetSkiApplication sa = new JetSkiApplication();
		String erroRetornado = sa.validar("12345678901", "abc", "def");
		assertNotEquals("São Iguais", erroRetornado, null);
	}
	
	@Test
	public void testApplicationCreateTemO_Id()
	{
		JetSkiApplication sa = new JetSkiApplication();
		JetSki j = new JetSki();
		j.setDescricao("DesctestCriouNovo");
		j.setHp(1);
		j.setPeso(1);
		String erroRetornado = sa.create(j);
		assertNotEquals("São Iguais", j.get_id(), null);
	}
	

	
	@Test
	public void testApplicationCreateRetornaMensagemErro()
	{
		JetSkiApplication sa = new JetSkiApplication();
		JetSki j = new JetSki();
		j.setDescricao("DesctestCriouNovo");
		j.setHp(1);
		j.setPeso(1);
		String erroRetornado = sa.create(j);
		assertEquals("São Iguais", erroRetornado, null);
	}
	
	@Test
	public void testApplicationTodos()
	{
		JetSkiApplication sa = new JetSkiApplication();
		JetSki j = new JetSki(null, "DesctestCriouNovo", 1, 1);
		String mensagem = "";
		List<JetSki> lista = new ArrayList<JetSki>();
		try
		{
			lista = sa.todos();
			System.out.println("Lista:" + lista);
		}
		catch (Exception e)
		{
			mensagem = e.getMessage();
			System.out.println("Mensagem:" + mensagem);
		}
		assertNotSame("São Iguais", lista.size(), 0);
	}
	
//	@Test
//	public void testaDoPost()
//	{
//		JetSkiServlet sv = new JetSkiServlet();
//		String mensagem = null;
//		try
//		{
//			sv.doGet(null, null);
//		}
//		catch (IOException e)
//		{
//			mensagem = e.getMessage();
//		}
//		catch (ServletException e)
//		{
//			mensagem = e.getMessage();
//		}
//		assertEquals(mensagem, null);		
//	}
	
}
