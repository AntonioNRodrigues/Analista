import java.io.IOException;

/**
 * 
 */

/**
 * @author antonio
 *
 */
public class Test {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		Analista a = new Analista("doc.txt");
		String str = a.getBigFrase();

		
		int [] teste = a.quantasOcorrencias('e');
		

		
		for (int i = 0; i < teste.length; i++) {
			System.out.println(teste[i]);
		}
		int [] test = a.quantasOcorrencias('m');
		

		
		for (int i = 0; i < test.length; i++) {
			System.out.println(test[i]);
		}
		
		int [] t = a.quantasOcorrencias('x');
		

		
		for (int i = 0; i < t.length; i++) {
			System.out.println(t[i]);
		}
		
		
		a.listaPalavras('e', "output.txt");
	}

}
