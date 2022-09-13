package testPackage;

import static org.junit.Assert.*;

import org.junit.Test;

import dominio.PessoaNatural;
import formularios.janelaDeCadastroPF;

public class JUnitTestPF {

	@Test
	public void testNomeCliente() {
		janelaDeCadastroPF janelaPf = new janelaDeCadastroPF();
		PessoaNatural pf = new PessoaNatural();
		assertTrue(pf.getNome().equals(janelaPf));
	}
	
	@Test
	public void testCPFCliente() {
		janelaDeCadastroPF janelaPf = new janelaDeCadastroPF();
		PessoaNatural pf = new PessoaNatural();
		assertTrue(pf.getEstado().equals(janelaPf));
	}

}
