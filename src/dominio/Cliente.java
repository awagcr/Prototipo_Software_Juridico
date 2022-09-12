package dominio;

public abstract class Cliente extends Pessoa {

	private boolean ehAutor;

	public void gerarContrato() {

	}

	public boolean isEhAutor() {
		return ehAutor;
	}
	public void setEhAutor(boolean ehAutor) {
		this.ehAutor = ehAutor;
	}
	
}
