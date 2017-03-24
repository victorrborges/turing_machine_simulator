package turing;

import java.util.ArrayList;

public class Fita {
	private ArrayList<String> palavra;
	private int cabecote;

	public Fita() {
		this.palavra = new ArrayList<String>();
		this.cabecote = 0;
	}

	public void escreverPalavra(String palavra) {
		String[] saida = palavra.split("");
		for (int i = 0; i < saida.length; i++) {
			this.palavra.add(saida[i]);
		}
		this.palavra.add("_");
	}
	
	public void escreverSimbolo(String simbolo){
		palavra.remove(cabecote);
		palavra.add(cabecote, simbolo);
	}
	
	public void andar(String andar) {
		if(andar.equals("l")) {
			this.andarParaEsquerda();
		} else if (andar.equals("r")) {
			this.andarParaDireita();
		}
	}
	
	public void andarParaEsquerda(){
		if (cabecote == 0) {
			return;
		}
		cabecote--;
	}
	public void andarParaDireita(){
		cabecote++;
	}
	
	public ArrayList<String> getPalavra(){
		return palavra;
	}
	
	public String getSimboloAtual() {
		return palavra.get(cabecote);
	}
}
