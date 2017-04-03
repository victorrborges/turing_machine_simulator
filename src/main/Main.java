package main;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import turing.TuringMachine;

public class Main {
	
	private static TuringMachine turingMachine = new TuringMachine();
	private static Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args) throws IOException {
		init();
		String opcao;
		do {
			System.out.println("");
			System.out.println("O que voce deseja fazer?");
			System.out.println("1 - Rodar ate o fim.");
			System.out.println("2 - Rodar o proximo passo.");
			System.out.println("3 - Mudar a palavra.");
			System.out.println("4 - Mudar a sintaxe.");
			System.out.println("5 - Sair.");
			System.out.print("Opcao desejada: ");
			System.out.println("");
			opcao = scan.nextLine();
			rodar(opcao.trim());
		} while (!opcao.equals("5"));
		
	}
	
	public static void init() throws IOException {
		System.out.println("Bem vindo ao Simulador de Maquina de Turing.");
		turingMachine.readFromConsole();
		System.out.println("");
		System.out.print("Digite a palavra: ");
		turingMachine.escreverPalavra(scan.nextLine());
		printarFita();
		printarCabecote();
		printarEstadoAtual();
		printarPassos();
	}
	
	public static void rodar(String opcao) throws IOException {
		if (opcao.equals("1")) {
			try {
				turingMachine.run();
				print();
			} catch(Exception e) {
				System.out.println(e.getMessage());
			}
		} else if (opcao.equals("2")) {
			try {
				turingMachine.runByStep();
				print();
			} catch(Exception e) {
				System.out.println(e.getMessage());
			}
		} else if(opcao.equals("3")) {
			System.out.println("");
			System.out.print("Digite a palavra: ");
			String palavra = scan.nextLine();
			turingMachine.escreverPalavra(palavra);
			print();
		} else if (opcao.equals("4")) {
			turingMachine.reset();
			turingMachine.readFromConsole();
			System.out.println("");
			System.out.print("Digite a palavra: ");
			String palavra = scan.nextLine();
			turingMachine.escreverPalavra(palavra);
			print();
		}
		
	}
	
	public static void print() {
		printarFita();
		printarCabecote();
		printarEstadoAtual();
		printarPassos();
	}

	public static void printarFita() {
		String toString = "";
		ArrayList<String> fita = turingMachine.fita.palavra;
		for(String string : fita) {
			if(string.equals("_")) 
				toString += " ";
			else toString += string;
		}
		System.out.println("Fita: " + toString);
	}
	
	public static void printarCabecote() {
		String toString = "";
		String[] array = new String[turingMachine.fita.palavra.size()];
		for (int i = 0; i < array.length; i++) {
			array[i] = " ";
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
