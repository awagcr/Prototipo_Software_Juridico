package dominio;

public class PessoaNatural extends Cliente {

	private int CPF;

	private int dataDeNascimento;

	public int getCPF() {
		return CPF;
	}
	public void setCPF(int cPF) {
		CPF = cPF;
	}

	public int getDataDeNascimento() {
		return dataDeNascimento;
	}
	public void setDataDeNascimento(int dataDeNascimento) {
		this.dataDeNascimento = dataDeNascimento;
	}
	

}
