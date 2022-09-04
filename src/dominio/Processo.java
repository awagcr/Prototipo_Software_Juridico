package dominio;

import java.util.Date;

public class Processo {

	private int numeroDoAutos;

	private EnumeradorDeClassesProcessuais classeDoProcesso;

	private EnumeradorDeTiposProcessuais tipoDoProcesso;

	private String identificacaoDoJuizo;

	private boolean ehSegredoDeJustica;

	private boolean possuiAssistenciaGratuita;

	private Date dataDeInicio;

	public void vincularCliente(Cliente cliente) {

	}

}
