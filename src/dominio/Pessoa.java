package dominio;

public abstract class Pessoa {

	private String nome;

	private int telefone;

	private String email;

	private String endereco;

	private int CEP;

	private String cidade;

	private String estado;

	public void vincularProcesso(Processo processo) {

	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	

}
