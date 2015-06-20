import org.junit.Test;


import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import com.controller.*;

public class JetSkiTest
{
	@Test
	public void testSum() {
		JetSkiServlet sv = new JetSkiServlet();
		JetSki j = new JetSki(null, "Desc", 1, 1);
		
		
		String erroQueDeveAcontecer = "Sua descrição deve ter acima de 10 letras";
		String erroRetornado = sv.validar(j.getDescricao(), j.getHp() + "", j.getPeso() + "");
		assertEquals("São Iguais", erroQueDeveAcontecer, erroRetornado);
	}

}
