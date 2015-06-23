import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

import org.bson.types.ObjectId;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import com.controller.*;

public class JetSkiTest
{
//	//Teste com selenium
//	private static WebDriver driver;
//	// Método que inicia tudo que for necessário para o teste
//	// Cria uma instância do navegador e abre a página inicial da DevMedia.
//	@BeforeClass
//	public static void setUpTest(){
//		driver = new FirefoxDriver();
//		driver.get("http://pijavafinal.herokuapp.com/");
//	}
//	
//	// Método que finaliza o teste, fechando a instância do WebDriver.    
//	@AfterClass
//	public static void tearDownTest(){
//		driver.quit();
//	}
//	
//	@Test
//	public void testaMensagemRertornoDaPagina(){
//		WebElement mensagem = driver.findElement(By.id("mensagem"));
//		assertEquals("", mensagem.getText());
//	}
//	
//	// Método que testa o login no site DevMedia.
//	@Test
//	public void testSeleniumJUnit() {
//
//	// Instancia um novo objeto do tipo "WebElement", e passa como parâmetro
//	// um elemento da tela cujo valor do atributo "name" seja igual a "usuario".
//	WebElement descricao = driver.findElement(By.name("descricao"));
//	WebElement hp = driver.findElement(By.name("hp"));
//	WebElement peso = driver.findElement(By.name("peso"));
//	
//	// Insere dados no elemento "senha".
//	descricao.sendKeys("testSeleniumJUnit");
//	hp.sendKeys("12");
//	peso.sendKeys("123");
//	
//	// Clica no botão "OK" e submete os dados para concluir o login.
//		driver.findElement(By.id("buscar")).click();
//	}
//	
	@Test
	public void testDescricaoNullEntaoRetornaMensagemDeErro()
	{
		JetSkiApplication application = new JetSkiApplication();
		StringBuffer sb = new StringBuffer();
		application.validar(null, "1", "1", sb);
		assertEquals(sb.toString(), "Descrição está vazio ou menor que 10 caracteres.");
	}
	
	@Test
	public void testDescricaoVazioEntaoRetornaMensagemDeErro()
	{
		JetSkiApplication application = new JetSkiApplication();
		StringBuffer sb = new StringBuffer();
		application.validar("", "1", "1", sb);
		assertEquals(sb.toString(), "Descrição está vazio ou menor que 10 caracteres.");
	}
	
	@Test
	public void testDescricaoMenorQue10CaracteresEntaoRetornaMensagemDeErro()
	{
		JetSkiApplication application = new JetSkiApplication();
		StringBuffer sb = new StringBuffer();
		application.validar("menosq10", "1", "1", sb);
		assertEquals(sb.toString(), "Descrição está vazio ou menor que 10 caracteres.");
	}
	
	@Test
	public void testHPNullEntaoRetornaMensagemDeErro()
	{
		JetSkiApplication application = new JetSkiApplication();
		StringBuffer sb = new StringBuffer();
		application.validar("BemMaiorque10", null, "1123", sb);
		System.out.println("sb.toString()"+sb.toString());
		StringBuffer sba = new StringBuffer("HP está vazio.");
		assertEquals(sb.toString(), sba.toString());
	}
	
	@Test
	public void testHPVazioEntaoRetornaMensagemDeErro()
	{
		JetSkiApplication application = new JetSkiApplication();
		StringBuffer sb = new StringBuffer();
		application.validar("maiorque10", "", "1", sb);
		assertEquals(sb.toString(), "HP está vazio.HP deve ser um número.");
	}
	
	@Test
	public void testPesoNullEntaoRetornaMensagemDeErro()
	{
		JetSkiApplication application = new JetSkiApplication();
		StringBuffer sb = new StringBuffer();
		application.validar("maiorque10", "1", null, sb);
		assertEquals(sb.toString(), "Peso está vazio.");
	}
	
	@Test
	public void testPesoVazioEntaoRetornaMensagemDeErro()
	{
		JetSkiApplication application = new JetSkiApplication();
		StringBuffer sb = new StringBuffer();
		application.validar("maiorque10", "1", "", sb);
		assertEquals(sb.toString(), "Peso está vazio.Peso deve ser um número.");
	}
	
	@Test
	public void testCriouNovo() {
		JetSkiApplication sa = new JetSkiApplication();
		JetSki j = new JetSki(null, "DesctestCriouNovo", 1, 1);
		try
		{
			int totalAntes = sa.todos().size();
			String erroRetornado = sa.create(j);
			int totalDepois = sa.todos().size();
			assertEquals("São Iguais", totalAntes + 1, totalDepois);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	
	@Test
	public void testApplicationValidar()
	{
		JetSkiApplication sa = new JetSkiApplication();
		JetSki j = new JetSki(null, "DesctestCriouNovo", 1, 1);
		StringBuffer sb = new StringBuffer();
		boolean valido = sa.validar(j.getDescricao(), j.getHp() + "", j.getPeso() + "", sb);
		System.out.println("testApplicationValidar:sb:" + sb + "-");
		assertEquals("São Iguais", valido, true);
	}
	
	@Test
	public void testApplicationValidarMenosDe10Caracteres()
	{
		JetSkiApplication sa = new JetSkiApplication();
		JetSki j = new JetSki(null, "123456789", 1, 1);
		boolean valido = sa.validar(j.getDescricao(), j.getHp() + "", j.getPeso() + "", new StringBuffer());
		System.out.println("testApplicationValidarMenosDe10Caracteres:valido:" + valido + "-" + j);
		assertEquals("São Iguais", valido, false);
	}
	
//	@Test
//	public void testApplicationValidarRetornoExcecao()
//	{
//		JetSkiApplication sa = new JetSkiApplication();
//		boolean valido = sa.validar("12345678901", "abc", "def", new StringBuffer());
//		assertEquals("São Iguais", valido, false);
//	}
	
	@Test
	public void testApplicationNaoDeuErroAoCriar()
	{
		JetSkiApplication sa = new JetSkiApplication();
		JetSki j = new JetSki();
		j.setDescricao("DesctestCriouNovo");
		j.setHp(1);
		j.setPeso(1);
		StringBuffer sb = new StringBuffer();
		sa.validar(j.getDescricao(), j.getHp() + "", j.getPeso() + "", sb);
		sb.append(sa.create(j));
		System.out.println("erroRetornado:" + sb);
		assertEquals("São Iguais", sb.toString(), "");
	}
	

	
	@Test
	public void testApplicationCreateRetornaMensagemErro()
	{
		JetSkiApplication sa = new JetSkiApplication();
		JetSki j = new JetSki();
		j.setDescricao("DesctestCriouNovo");
		j.setHp(1);
		j.setPeso(1);
		StringBuffer sb = new StringBuffer();
		sa.validar(j.getDescricao(), j.getHp() + "", j.getPeso() + "", sb);
		sb.append(sa.create(j));
		assertEquals("Criou jetsky sem falhar.", sb.toString(), "");
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
	
	@Test
	public void testPreencheDoPostEDoGet()
	{
		JetSkiServlet js = new JetSkiServlet();
		String mensagem = null;
		HttpServletRequest request = mock(HttpServletRequest.class);       
        HttpServletResponse response = mock(HttpServletResponse.class);
        try {
			js.doPost(request, response);
			js.doGet(request, response);
		} catch (IOException e) {
			mensagem = e.getMessage();
		} catch (ServletException e) {
			mensagem = e.getMessage();
		}
        catch(Exception e) {
			mensagem = e.getMessage();
		}
        
		assertNotEquals(mensagem, null);
	}

}
