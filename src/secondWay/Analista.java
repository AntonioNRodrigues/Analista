package secondWay;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class Analista {
	private String [] listaPalavras;

	/**
	 * Constructor that initializes the class field
	 * @param nameFile String with the name of the file to read
	 * @throws IOException 
	 * @requires nameFile != null && name.equals("file name entered by the user")
	 */
	public Analista(String nameFile) throws IOException{
		this.listaPalavras = setListaPalavras(nameFile);
	}

	/**
	 * Reads the file and puts each word in an array, skipping characters that are not relevant to the analysis 
	 * @param path String with the name of the file to read
	 * @return array of String filled with the words from the file
	 * @throws IOException
	 * @requires nameFile != null && name.equals("file name entered by the user")
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
	 * Getter for the listaPalavras field
	 * @return the listaPalavras field
	 */
	public String[] getListaPalavras() {
		return listaPalavras;
	}
	/**
	 * Method that analyses listaPalavras and counts how many words contain c i times
	 * @param c char to compare against each word
	 * @return integer array with the number of words where c occurs i times
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
	 * Method that writes to a file the list of all words 
	 * starting with c, along with how many times those words occur in the text
	 * @param c letter to analyse
	 * @param ficheiro name of the file where the information is written
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
