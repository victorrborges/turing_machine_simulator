package turing;

import java.util.ArrayList;

public class Fita {
	public ArrayList<String> palavra;
	public int cabecote;

	public Fita() {
		this.palavra = new ArrayList<String>();
		this.cabecote = 0;
	}

	public void escreverPalavra(String palavra) {
		String[] saida = palavra.split("");
		for (int i = 0; i < saida.length * 10; i++) {
			this.palavra.add("_");
		}
		for (int i = 0; i < saida.length; i++) {
			if(saida[i].equals(" ")) this.palavra.add("_");
			else
				this.palavra.add(saida[i]);
		}
		for (int i = 0; i < saida.length * 10; i++) {
			this.palavra.add("_");
		}
		this.cabecote = saida.length * 10;
	}
	
	public void escreverSimbolo(String simbolo){
		palavra.set(cabecote, simbolo);
	}
	
	public void andar(String andar) {
		if(andar.equals("l")) {
			this.andarParaEsquerda();
		} else if (andar.equals("r")) {
			this.andarParaDireita();
		}
	}
	
	public void andarParaEsquerda(){
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
