package test;

import org.junit.Before;
import org.junit.Test;

import turing.TuringMachine;

public class TuringMachineTest {

private TuringMachine turing;
	
	@Before
	public void inicial() {
		turing = new TuringMachine();
	}

	@Test
	public void testMachine() throws Exception {
		try {
			turing.readFile();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	
		turing.escreverPalavra("101");
		
		turing.run();
		System.out.println(turing.estadoAtual.getNome());
		System.out.println(turing.fita.toString());
		System.out.println(turing.passos);
	}
	
}
