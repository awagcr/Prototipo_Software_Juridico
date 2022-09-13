package JUnitPJ;

import static org.junit.Assert.*;

import org.junit.Test;

import dominio.PessoaJuridica;
import formularios.janelaDeCadastroPJ;

public class TestPJ {

	janelaDeCadastroPJ cadastroPj = new janelaDeCadastroPJ();
	PessoaJuridica pessoaJuridica = new PessoaJuridica();

	@Test
	public void testNome() {		
		assertTrue(pessoaJuridica.getRazaoSocial().equals(cadastroPj));
	}
	
	@Test
	public void testEndereco() {
		assertTrue(pessoaJuridica.getEndereco().equals(cadastroPj));
		
	}

}
