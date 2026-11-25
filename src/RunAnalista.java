import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Locale;
import java.util.Scanner;

/**
 * Interactive command line runner for {@link Analista}.
 *
 * Commands:
 *   letter <letter>             writes <letter>.out with occurrence counts
 *   words <letter> <output>     writes words starting with <letter>
 *   quit                        exits
 *
 * The input file may be supplied with or without the .txt suffix.
 *
 * @author antonio
 */
public class RunAnalista {
	private static final String EXT1 = ".txt";
	private static final String EXT2 = ".out";

	public static void main(String[] args) throws IOException {
		try (Scanner sc = new Scanner(System.in)) {
			System.out.print("Enter the file name: ");
			String nome = sc.nextLine().trim();
			Analista a = new Analista(withTxtExtension(nome));

			while (true) {
				System.out.print("Choose an option: ");
				String linha = sc.nextLine().trim();
				if (linha.isEmpty()) {
					continue;
				}

				String[] partes = linha.split("\\s+");
				String comando = partes[0].toLowerCase(Locale.ROOT);

				if (comando.equals("quit")) {
					System.out.println("Session finished");
					break;
				}

				if (comando.equals("letter") && partes.length >= 2) {
					char letra = partes[1].charAt(0);
					String nomeFicheiro = letra + EXT2;
					int[] numeroOcorrencias = a.quantasOcorrencias(letra);
					try (BufferedWriter out = new BufferedWriter(new FileWriter(nomeFicheiro))) {
						for (int j = 0; j < numeroOcorrencias.length; j++) {
							out.write((j <= 4 ? String.valueOf(j) : j + "+") + " "
									+ numeroOcorrencias[j] + "\n");
						}
					}
					System.out.println("File " + nomeFicheiro + " written successfully.");
				} else if (comando.equals("words") && partes.length >= 3) {
					char letra = partes[1].charAt(0);
					String nomeFicheiro = partes[2];
					a.listaPalavras(letra, nomeFicheiro);
					System.out.println("File " + nomeFicheiro + " written successfully.");
				} else {
					System.out.println("Unknown command. Use: letter <letter>, words <letter> <file>, or quit.");
				}
			}
		}
	}

	private static String withTxtExtension(String nome) {
		return nome.toLowerCase(Locale.ROOT).endsWith(EXT1) ? nome : nome + EXT1;
	}
}
