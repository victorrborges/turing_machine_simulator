package turing;

import java.util.HashSet;
import java.util.Scanner;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.FileWriter;

public class TuringMachine {

	HashSet<Estado> estados;
	Estado estadoInicial;
	public Estado estadoAtual;
	HashSet<Estado> estadosFinais;
	int passos;
	Fita fita;

	public TuringMachine() {
		this.estados = new HashSet<Estado>();
		this.estadoInicial = new Estado("0");
		this.estadoAtual = this.estadoInicial;
		this.estadosFinais = new HashSet<Estado>();
		this.passos = 0;
		this.fita = new Fita();
		this.estados.add(estadoInicial);
	}

	protected void criaEstado(String estado) {
		if (this.buscaEstado(estado) == null) {
			Estado novoEstado = new Estado(estado);
			estados.add(novoEstado);

			String[] palavra = estado.split("");
			if (palavra.length >= 4) {
				String checkHalt = palavra[0] + palavra[1] + palavra[2] + palavra[3];
				if (checkHalt.equals("halt")) {
					estadosFinais.add(novoEstado);
				}
			}
		}
	}

	protected Estado buscaEstado(String estado) {
		for (Estado state : estados) {
			if (state.getNome().equals(estado)) {
				return state;
			}
		}
		return null;
	}

	public void addTransicao(String estado1, String simboloAtual, String simboloNovo, String direcao, String estado2) {
		this.criaEstado(estado1);
		this.criaEstado(estado2);

		Estado e1 = this.buscaEstado(estado1);
		Estado e2 = this.buscaEstado(estado2);

		Transicao transicao = new Transicao(simboloAtual, simboloNovo, direcao, e2);

		e1.addTransicao(transicao);
	}

	public void escreverPalavra(String palavra) {
		this.fita.escreverPalavra(palavra);
	}

	public void runByStep() {
		this.runByStep(this.estadoAtual);
	}

	private void runByStep(Estado estado) {
//		if (estadosFinais.contains(estado)) {
//			return;
//		}
//
//		for (Transicao transicao : estado.getTransicoes()) {
//			if (transicao.getSimboloAtual().equals(fita.getSimboloAtual()) || transicao.getSimboloAtual().equals("*")) {
//				if (!transicao.getNovoSimbolo().equals("*")) {
//					fita.escreverSimbolo(transicao.getNovoSimbolo());
//				}
//				fita.andar(transicao.getDirecao());
//				if (!transicao.getNovoEstado().equals("*")) {
//					this.estadoAtual = transicao.getNovoEstado();
//				}
//			}
//		}

	}

	public void run() {
		this.run(estadoInicial);
	}

	public void run(Estado estado) {
//		if (estadosFinais.contains(estado)) {
//			return;
//		}
//
//		for (Transicao transicao : estado.getTransicoes()) {
//			if (transicao.getSimboloAtual().equals(fita.getSimboloAtual()) || transicao.getSimboloAtual().equals("*")) {
//				if (!transicao.getNovoSimbolo().equals("*")) {
//					fita.escreverSimbolo(transicao.getNovoSimbolo());
//				}
//				fita.andar(transicao.getDirecao());
//				if (!transicao.getNovoEstado().equals("*")) {
//					this.estadoAtual = transicao.getNovoEstado();
//				}
//			}
//		}
//		run(this.estadoAtual);
	}

	// leitura de arquivos

	protected void scan() {
		Scanner scan = new Scanner(System.in);
		escreverPalavra(scan.nextLine());
		scan.close();
	}

	public void readFile() throws IOException {
		BufferedReader in = new BufferedReader(new FileReader("/home/dayvsonwcn/workspace1/turing/machine.txt"));
		BufferedWriter out = new BufferedWriter(new FileWriter("teste.txt"));
		String line;
	
		while ((line = in.readLine()) != null) {
			out.write(line + "\n");
			if (!line.isEmpty()) {
				String[] read = line.split(" ");
				addTransicao(read[0], read[1], read[2], read[3], read[4]);

			}

		}
		in.close();
		out.close();
	}

}
