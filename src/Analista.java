import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class Analista {
	private String bigFrase;
	/**
	 * 
	 * @param path
	 * @throws IOException
	 */
	public Analista(String path) throws IOException{
		this.bigFrase=setBigFrase(path);
	}
	
	/**
	 * 
	 * @param path
	 * @return
	 * @throws IOException
	 */
	public String setBigFrase(String path) throws IOException {
		BufferedReader in = new BufferedReader(new FileReader(path));
		StringBuilder sb = new StringBuilder();
		String line;
		while((line = in.readLine())!=null){
			sb.append(line).append(" ");
		}
		in.close();
		return sb.toString();
	}
	
	/**
	 * 
	 * @return
	 */
	public String getBigFrase() {
		return bigFrase;
	}
	/**
	 * 
	 * @param c
	 * @return
	 */
	public int [] quantasOcorrencias(char c){
		int [] numOcorrenciasporLetra = new int [6];
		String str = getBigFrase();
		
		for (String t : str.split("\\s*[ ,.()]\\s*")){
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
	 * 
	 * @param c
	 * @param ficheiro
	 * @throws IOException 
	 */
	public void listaPalavras(char c, String ficheiro) throws IOException{	
		BufferedWriter out = new BufferedWriter(new FileWriter(ficheiro));
		String [] listaString = getBigFrase().split(("\\s*[ ,.()]\\s*"));
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
