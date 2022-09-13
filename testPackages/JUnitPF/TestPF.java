package JUnitPF;

import static org.junit.Assert.*;

import org.junit.Test;

import dominio.PessoaNatural;
import formularios.janelaDeCadastroPF;

public class TestPF {
	janelaDeCadastroPF cadastroPf = new janelaDeCadastroPF();
	PessoaNatural pessoaNatural = new PessoaNatural();

	@Test
	public void testNome() {		
		assertTrue(pessoaNatural.getNome().equals(cadastroPf));
	}
	
	@Test
	public void testEndereco() {
		assertTrue(pessoaNatural.getEndereco().equals(cadastroPf));
		
	}

}
