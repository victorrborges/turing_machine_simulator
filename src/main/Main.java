package main;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import turing.TuringMachine;

public class Main {
	
	private static TuringMachine turingMachine = new TuringMachine();
	private static Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args) throws IOException {
		System.out.println("Bem vindo ao Simulador de Maquina de Turing.");
		System.out.println("Adicione o arquivo .txt com a sintaxe desejada com o nome syntax.txt na raiz do projeto");
		turingMachine.readFile();
		System.out.print("Digite a palavra: ");
		turingMachine.escreverPalavra(scan.nextLine());
		String opcao;
		printarFita();
		printarCabecote();
		do {
			System.out.println("");
			System.out.println("O que você deseja fazer?");
			System.out.println("1 - Rodar ate o fim.");
			System.out.println("2 - Rodar o proximo passo.");
			System.out.println("3 - Sair.");
			System.out.print("Opcao desejada: ");
			System.out.println("");
			opcao = scan.nextLine();
			rodar(opcao.trim());
			printarFita();
			printarCabecote();
			printarEstadoAtual();
			printarPassos();
		} while (opcao.trim().equals("2") && !turingMachine.estadosFinais.contains(turingMachine.estadoAtual));
	}
	
	public static void rodar(String opcao) {
		if (opcao.equals("1")) {
			turingMachine.run();
		} else if (opcao.equals("2")) {
			turingMachine.runByStep();
		}
		
	}

	public static void printarFita() {
		String toString = "";
		ArrayList<String> fita = turingMachine.fita.palavra;
		for(String string : fita) {
			toString += string;
		}
		System.out.println("Fita: " + toString);
	}
	
	public static void printarCabecote() {
		String toString = "";
		String[] array = new String[turingMachine.fita.palavra.size()];
		for (int i = 0; i < array.length; i++) {
			array[i] = "-";
		}
		array[turingMachine.fita.cabecote] = "^";
		
		for (int i = 0; i < array.length; i++) {
			toString += array[i];
		}
		
		System.out.println("Head: " + toString);
	}
	
	public static void printarEstadoAtual() {
		System.out.println("Estado atual: " + turingMachine.estadoAtual.getNome());
	}
	
	public static void printarPassos() {
		System.out.println("Numero de Passos: " + turingMachine.passos);
	}

}
