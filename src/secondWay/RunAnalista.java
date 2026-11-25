package secondWay;
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
		System.out.print("Enter the file name: ");
		str = sc.nextLine();
		Analista a = new Analista(str+EXT1);
		
		while(!(str.equals("quit"))){
			System.out.print("Choose an option: ");
			str = sc.nextLine();
			
			if(str.startsWith("letter")){
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
						System.out.println("File "+ str.charAt(str.length()-1)+EXT2+ " written successfully.");
			}else if(str.startsWith("words")){
				char letra = encontraLetra(str);
				String nomeFicheiro = selecionaNomeFicheiro(str);
				a.listaPalavras(letra, nomeFicheiro);
				System.out.println("File "+ nomeFicheiro+ " written successfully.");
				
			}
			else if(str.equals("quit")){
				
				System.out.println("Session finished");
			}
		}	
	}

	
	/**
	 * Helper method that extracts the file name from the string supplied by the user
	 * @param str string entered by the user
	 * @return string with the file name
	 * @requires str.equals("words n filename")
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
	 * Method that isolates the letter to analyse
	 * @param str string entered by the user
	 * @return char with the letter to analyse
	 * @requires str.equals("words n filename")
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
