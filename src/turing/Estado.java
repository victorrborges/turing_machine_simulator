package turing;

import java.util.HashSet;

public class Estado {
	private String nome;
	private HashSet<Transicao> transicoes;
	
	public Estado(String nome) {
		this.nome = nome;
		this.transicoes = new HashSet<Transicao>();
	}
	
	public void addTransicao(Transicao transicao){
		transicoes.add(transicao);
	}
	
	public HashSet<Transicao> getTransicoes(){
		return transicoes;
	}

	public String getNome() {
		return nome;
	}
	
	public Transicao getTransicao(String simboloFita) {
		for (Transicao transicao : this.transicoes) {
			if (transicao.simboloAtual.equals(simboloFita)) {
				return transicao;
			}
		}
		return null;
	}
}
