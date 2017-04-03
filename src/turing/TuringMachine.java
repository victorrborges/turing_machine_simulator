package turing;

import java.util.HashSet;
import java.util.Scanner;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TuringMachine {

	public HashSet<Estado> estados;
	public Estado estadoInicial;
	public Estado estadoAtual;
	public HashSet<Estado> estadosFinais;
	public int passos;
	public Fita fita;

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
		this.passos = 0;
		this.estadoAtual = this.estadoInicial;
		this.fita = new Fita();
		this.fita.escreverPalavra(palavra);
	}

	public void runByStep() throws Exception {
		if (estadosFinais.contains(this.estadoAtual)) {
			return;
		}
		Transicao transicao = this.estadoAtual.getTransicao(this.fita.getSimboloAtual());
		if (transicao == null) {
			transicao = this.estadoAtual.getTransicao("*");
			if (transicao == null) {
				throw new Exception("Alfabeto nao suportado. Mude a palavra (3) ou a sintaxe (4).");
			}
		}
		if (!transicao.getNovoSimbolo().equals("*")) {
			fita.escreverSimbolo(transicao.getNovoSimbolo());
		}
		fita.andar(transicao.getDirecao());
		if (!transicao.getNovoEstado().equals("*")) {
			this.estadoAtual = transicao.getNovoEstado();
		}
		this.passos++;
	}

	public void run() throws Exception {
		while (!this.estadosFinais.contains(estadoAtual)) {
			this.runByStep();
		}
	}

	// leitura de console

	public void readFromConsole() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("\nDigite a sintaxe desejada seguida de 'end' para continuar: ");
		String in;

		while (!(in = reader.readLine()).trim().equalsIgnoreCase("end")) {
			if (!in.isEmpty() && !in.trim().equals("")) {
				String[] read = in.split(" ");
				if (!read[0].equals(";")) {
					addTransicao(read[0], read[1], read[2], read[3], read[4]);
				}
			}

		}
		
	}
	
	public void reset() {
		this.estados = new HashSet<Estado>();
		this.estadoInicial = new Estado("0");
		this.estadoAtual = this.estadoInicial;
		this.estadosFinais = new HashSet<Estado>();
		this.passos = 0;
		this.fita = new Fita();
		this.estados.add(estadoInicial);
	}

	// leitura de arquivos

	protected void scan() {
		Scanner scan = new Scanner(System.in);
		escreverPalavra(scan.nextLine());
		scan.close();
	}

	public void readFile() throws IOException {
		BufferedReader in = new BufferedReader(new FileReader("syntax.txt"));
		String line;

		while ((line = in.readLine()) != null) {
			if (!line.isEmpty()) {
				String[] read = line.split(" ");
				if (!read[0].equals(";")) {
					addTransicao(read[0], read[1], read[2], read[3], read[4]);
				}
			}

		}
		in.close();
	}

}
