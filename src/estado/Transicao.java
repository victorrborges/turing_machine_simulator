package estado;

public class Transicao {

	String simboloAtual;
	String novoSimbolo;
	String direcao;
	Estado novoEstado;
	
	public Transicao(String simboloAtual, String novoSimbolo, String direcao, Estado novoEstado) {
		this.simboloAtual = simboloAtual;
		this.novoSimbolo = novoSimbolo;
		this.direcao = direcao;
	}

	public Estado getNovoEstado() {
		return novoEstado;
	}

	public void setNovoEstado(Estado novoEstado) {
		this.novoEstado = novoEstado;
	}

	public String getSimboloAtual() {
		return simboloAtual;
	}

	public void setSimboloAtual(String simboloAtual) {
		this.simboloAtual = simboloAtual;
	}

	public String getNovoSimbolo() {
		return novoSimbolo;
	}

	public void setNovoSimbolo(String novoSimbolo) {
		this.novoSimbolo = novoSimbolo;
	}

	public String getDirecao() {
		return direcao;
	}

	public void setDirecao(String direcao) {
		this.direcao = direcao;
	}
	
	
	
}
