package secondWay;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class Analista {
	private String [] listaPalavras;

	/**
	 * construtor que inicializa o argumento da classe
	 * @param nameFile String com o nome do ficheiro que vai ser lido
	 * @throws IOException 
	 * @requires nameFile != null && name.equals("nome do ficheiro que eh introduzido pelo utilizador")
	 */
	public Analista(String nameFile) throws IOException{
		this.listaPalavras = setListaPalavras(nameFile);
	}

	/**
	 * le o ficheiro e coloca cada palavra num array de [] sem os caracteres que nao interessa analisar 
	 * @param path String com o nome do ficheiro que vai ser lido
	 * @return array de String preenchido com as palavras do ficheiro
	 * @throws IOException
	 * @requires nameFile != null && name.equals("nome do ficheiro que eh introduzido pelo utilizador")
	 */
	private String[] setListaPalavras(String path) throws IOException {
		BufferedReader in = new BufferedReader(new FileReader(path));
		StringBuilder sb = new StringBuilder();
		String line;

		while((line = in.readLine()) != null){
			sb.append(line).append(" ");
		}

		String [] listaString = sb.toString().split(("\\s*[ ,.()]\\s*"));
		in.close();

		return listaString;
	}

	/**
	 * getter do argumento listaPalavras
	 * @return o argumento listaPalavras
	 */
	public String[] getListaPalavras() {
		return listaPalavras;
	}
	/**
	 * metodo que analisa a listaPalavras e conta o numero de palavras em que c ocorre i vezes
	 * @param c char que irah ser comparado em cada palavra
	 * @return array de integer em que c ocorre i vezes em cada palavra
	 */
	public int [] quantasOcorrencias(char c){
		int [] numOcorrenciasporLetra = new int [6];
		String [] lista = getListaPalavras();

		for (String t : lista){
			int count = 0;
			for (int i = 0; i < t.length(); i++){
				char cComparar = t.toLowerCase().charAt(i);	
				if(cComparar == c){
					count ++;
				}
			}

			switch(count){
			case 0:
				numOcorrenciasporLetra[0]++;
				break;
			case 1:
				numOcorrenciasporLetra[1]++;
				break;
			case 2:
				numOcorrenciasporLetra[2]++;
				break;
			case 3:
				numOcorrenciasporLetra[3]++;
				break;
			case 4:
				numOcorrenciasporLetra[4]++;
				break;
			default:
				numOcorrenciasporLetra[5]++;
				break;
			}
		}

		return numOcorrenciasporLetra;
	}

	/**
	 * metodo que escreve num ficheiro a lsita de todas as palavras 
	 * comecadas com c bem como o numero de vezes que essas palavras ocorrem no texto
	 * @param c letra que irah ser analisada
	 * @param ficheiro nome do ficheiro em que vai ser escrita a informacao
	 * @requires ficheiro != null
	 * @throws IOException 
	 */
	public void listaPalavras(char c, String ficheiro) throws IOException{	
		BufferedWriter out = new BufferedWriter(new FileWriter(ficheiro));
		String [] listaString = getListaPalavras();
		String encontrou = "";
		StringBuilder sb = new StringBuilder();

		for(int i = 0; i < listaString.length; i++){
			if(listaString[i].toLowerCase().charAt(0) == c){
				int count = 0;
				encontrou = listaString[i].toLowerCase();
				for (int j = i; j < listaString.length; j++) {
					if(encontrou.equals(listaString[j].toLowerCase())){
						count++;
						listaString[j] = " ";
					}
				}
				sb.append(encontrou.toUpperCase()).append(" ");
				sb.append(count).append("\n");
			}
		}
		out.write(sb.toString());
		out.close();
	}

}
