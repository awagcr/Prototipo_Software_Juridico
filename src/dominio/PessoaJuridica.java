package dominio;

public class PessoaJuridica extends Cliente {

	private String razaoSocial;

	private int CNPJ;

	private PessoaNatural responsavelLegal;

	private Pessoa pessoa;

	public String getRazaoSocial() {
		return razaoSocial;
	}
	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public int getCNPJ() {
		return CNPJ;
	}
	public void setCNPJ(int cNPJ) {
		CNPJ = cNPJ;
	}

	public PessoaNatural getResponsavelLegal() {
		return responsavelLegal;
	}
	public void setResponsavelLegal(PessoaNatural responsavelLegal) {
		this.responsavelLegal = responsavelLegal;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}
	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

}
