import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * Analyses a text file and counts how often a letter occurs in each word.
 *
 * @author antonio
 */
public class Analista {
	private static final String WORD_SEPARATOR = "\\s*[ ,.()]\\s*";

	private String bigFrase;

	public Analista(String path) throws IOException {
		this.bigFrase = setBigFrase(path);
	}

	public String setBigFrase(String path) throws IOException {
		StringBuilder sb = new StringBuilder();
		try (BufferedReader in = new BufferedReader(new FileReader(path))) {
			String line;
			while ((line = in.readLine()) != null) {
				sb.append(line).append(" ");
			}
		}
		return sb.toString();
	}

	public String getBigFrase() {
		return bigFrase;
	}

	private String[] words() {
		List<String> words = new ArrayList<String>();
		for (String token : getBigFrase().split(WORD_SEPARATOR)) {
			if (!token.isEmpty()) {
				words.add(token);
			}
		}
		return words.toArray(new String[words.size()]);
	}

	/**
	 * Returns, for the given letter, how many words contain it 0, 1, 2, 3, 4
	 * or 5+ times. Matching is case-insensitive.
	 */
	public int[] quantasOcorrencias(char c) {
		int[] numOcorrenciasporLetra = new int[6];
		char letra = Character.toLowerCase(c);

		for (String t : words()) {
			int count = 0;
			String lower = t.toLowerCase(Locale.ROOT);
			for (int i = 0; i < lower.length(); i++) {
				if (lower.charAt(i) == letra) {
					count++;
				}
			}

			switch (count) {
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
	 * Writes all words starting with the given letter and their frequencies to
	 * the output file. Matching and output are case-insensitive.
	 */
	public void listaPalavras(char c, String ficheiro) throws IOException {
		char letra = Character.toLowerCase(c);
		String[] listaString = words();
		StringBuilder sb = new StringBuilder();

		try (BufferedWriter out = new BufferedWriter(new FileWriter(ficheiro))) {
			for (int i = 0; i < listaString.length; i++) {
				if (listaString[i].isEmpty()) {
					continue;
				}

				String encontrou = listaString[i].toLowerCase(Locale.ROOT);
				if (encontrou.charAt(0) == letra) {
					int count = 0;
					for (int j = i; j < listaString.length; j++) {
						if (!listaString[j].isEmpty()
								&& encontrou.equals(listaString[j].toLowerCase(Locale.ROOT))) {
							count++;
							listaString[j] = "";
						}
					}
					sb.append(encontrou.toUpperCase(Locale.ROOT)).append(" ");
					sb.append(count).append("\n");
				}
			}
			out.write(sb.toString());
		}
	}
}
