package teste;

import org.junit.*;

import turing.*;

public class Teste {
	private TuringMachine turing;
	
	@Before
	public void inicial() {
		turing = new TuringMachine();
	}

	@Test
	public void testMachine() {
		try {
			turing.readFile();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	
		turing.escreverPalavra("10110101101");
		turing.run();
		System.out.println(turing.estadoAtual.getNome());
	}
}
