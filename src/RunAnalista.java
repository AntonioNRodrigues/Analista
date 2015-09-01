import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


public class RunAnalista {
	private static final String EXT1 = ".txt";
	private static final String EXT2 = ".out";
	
	
	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		
		String str;
		Scanner sc = new Scanner(System.in);
		BufferedWriter out;
		System.out.print("Introduza o nome do ficheiro: ");
		str = sc.nextLine();
		Analista a = new Analista(str+EXT1);
		
		while(!(str.equals("terminar"))){
			System.out.print("Opção desejada: ");
			str = sc.nextLine();
			
			if(str.startsWith("letra")){
				out = new BufferedWriter(new FileWriter(str.charAt(str.length()-1)+EXT2));
				int [] numeroOcorrencias = a.quantasOcorrencias(str.charAt(str.length()-1));
					for (int j = 0; j <numeroOcorrencias.length; j++) {
						if(j<=4){
							out.write(j + " "+ numeroOcorrencias[j] + "\n");
						}else  {
							out.write(j + "+ "+ numeroOcorrencias[j] + "\n");
							}
						}
						out.close();
						System.out.println("Ficheiro "+ str.charAt(str.length()-1)+EXT2+ " gravado com sucesso.");
			}else if(str.startsWith("ficheiro")){
				char letra = encontraLetra(str);
				String nomeFicheiro = selecionaNomeFicheiro(str);
				a.listaPalavras(letra, nomeFicheiro);
				System.out.println("Ficheiro "+ nomeFicheiro+ " gravado com sucesso.");
				
			}
			else if(str.equals("terminar")){
				
				System.out.println("Sessão terminada");
			}
		}	
	}

	
	/**
	 * 
	 * @param str
	 * @return
	 */
	private static String selecionaNomeFicheiro(String str) {
		StringBuilder nomeFile = new StringBuilder();
		int count = 0;
		int i = 0;
		while (count !=2 && i < str.length()){
			if(str.charAt(i)== ' '){
				count++;
			}
			i++;
		}
		nomeFile.append(str.substring(i, str.length()));
	
		return nomeFile.toString();
	}

	/**
	 * 
	 * @param str
	 * @return
	 */
	private static char encontraLetra(String str) {
		char letra = 0;
		for (int i = str.length()-1; i > 0; i--) {
			if(str.charAt(i) == ' '){
				letra = str.charAt(i+1);
			}
		}
		return letra;
	}
	

}
