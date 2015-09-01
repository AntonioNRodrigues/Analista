/**
 * Classe que representa um numero inteiro onde cada digito do respectivo numero
 * eh representado por um no
 * 
 * @author Antonio Rodrigues, aluno ????? e Pedro Luis, aluno 45588
 * 
 */
public class BigNatural implements BigNaturalInterface {

	Node head, tail;
	int numDigitos;

	/**
	 * Construtor que permite criar um numero BigNatural apenas com um no e 
	 * cujo valor eh 0 
	 */
	public BigNatural() {

		head = new Node(0, null);
		tail = head;
		numDigitos = 1;
	}

	/**
	 * Construtor que permite criar um numero BigNatural cujo numero de nos
	 * eh igual ao numero de digitos de num e cujo valor de cada no eh igual
	 * ao valor do respectivo digito
	 * @param num Numero a ser convertido para BigNatural
	 */
	public BigNatural(int num) {

		String stringNumber = Integer.toString(num);
		int numLength = stringNumber.length();
		StringBuilder sb = new StringBuilder(stringNumber);
		stringNumber = sb.reverse().toString();

		head = new Node(Character.getNumericValue(stringNumber.charAt(0)), null);
		tail = head;
		numDigitos = 1;

		if (numLength > 1)
			for (int i = 1; i < numLength; i++)
				addLast(Character.getNumericValue(stringNumber.charAt(i)));
	}

	@Override
	public BigNatural suc() {
		return sum(new BigNatural(1));
	}

	@Override
	public BigNatural sum(BigNatural num) {

		BigNatural result = sum(num, 0);
		return result;
	}

	/**
	 * Determina o valor da soma entre dois numeros BigNatural baseado num
	 * determinado desfasamento de posicoes. Esta funcao eh bastante util para
	 * o calculo das somas intermedias resultantes da multiplicacao de dois 
	 * numeros com mais de 1 digito
	 * 
	 * @param num
	 *            Numero a ser somado ao numero atual
	 * @param offset
	 *            Desfasamento a ser aplicado entre os dois numeros
	 * @return Valor da soma
	 * @requires offset <= num.numDigitos;
	 */
	private BigNatural sum(BigNatural num, int offset) {

		Node num1 = head;
		Node num2 = num.head;
		BigNatural result;
		
		int arg1, arg2;
		int soma;
		int item;
		int carry = 0;

		// soma com offset de posicoes
		if (offset > 0) {
			result = new BigNatural(num1.item);
			num1 = num1.next;

			// preencher posicoes do resultado que nao entram na soma
			for (int i = 1; i < offset; i++) {
				result.addLast(num1.item);
				num1 = num1.next;
			}
		// soma sem offset
		// preparar result para o calculo da soma
		} else {
			soma = num1.item + num2.item;
			item = soma % 10;
			carry = (int) soma / 10;
			result = new BigNatural(item);
			num1 = num1.next;
			num2 = num2.next;
		}

		// calculo dos restantes digitos 
		while (num1 != null || num2 != null) {
			// primeiro numero alcancou o ultimo digito
			if (num1 == null) {
				arg1 = 0;
			} 
			else {
				arg1 = num1.item;
				num1 = num1.next;
			}
			
			// segundo numero alcancou o ultimo digito
			if (num2 == null) {
				arg2 = 0;
			}
			else {
				arg2 = num2.item;
				num2 = num2.next;
			}

			soma = arg1 + arg2 + carry;
			item = soma % 10;
			carry = (int) soma / 10;
			result.addLast(item);
		}

		// adicionar valor do ultimo carry caso este exista
		if (carry > 0)
			result.addLast(carry);

		return result;
	}

	@Override
	public BigNatural mult(BigNatural num) {
		BigNatural smaller, bigger;

		// determinar numero com maior numero de digitos de modo a posiciona-lo 
		// na multiplicacao
		if (num.numDigitos <= numDigitos) {
			smaller = num;
			bigger = this;
		} 
		else {
			smaller = this;
			bigger = num;
		}

		// vetor que ira guardar os resultados de cada uma das multiplicacoes
		// intermedias
		BigNatural[] multResults = new BigNatural[smaller.numDigitos];
		Node currSmaller = smaller.head;
		int i = 0;

		// iterar primeiro o numero com menos digitos
		while (currSmaller != null) {
			Node currBigger = bigger.head;
			int mult = currSmaller.item * currBigger.item;
			int item = mult % 10;

			// iniciar primeiro valor
			multResults[i] = new BigNatural(item);
			int carry = (int) mult / 10;
			currBigger = currBigger.next;

			// multiplicar digito atual de currSmaller aos restantes digitos
			// de currBigger
			while (currBigger != null) {
				mult = (currSmaller.item * currBigger.item) + carry;
				item = mult % 10;
				carry = (int) mult / 10;
				multResults[i].addLast(item);
				currBigger = currBigger.next;
			}

			// sobrou um valor de carry
			if (carry > 0)
				multResults[i].addLast(carry);

			currSmaller = currSmaller.next;
			i++;
		}

		// numero menor apenas tem um digito
		BigNatural result = multResults[0];

		// numero com mais de um digito
		// somar todas as parcelas resultantes
		if (multResults.length > 1)
			for (int j = 1; j < multResults.length; j++)
				result = result.sum(multResults[j], j);

		return result;
	}

	@Override
	public void addLast(int item) {
		
		tail.next = new Node(item, null);
		tail = tail.next;
		numDigitos++;
	}

	@Override
	public boolean geq(BigNatural num) {
		
		boolean geq = false;

		// numero tem mais digitos, logo eh automaticamente maior
		if (numDigitos > num.numDigitos)
			geq = true;

		// numeros nao tem o mesmo numero de digitos, logo os digitos de cada
		// numero tem de ser comparados um a um
		else if (numDigitos == num.numDigitos) {
			Node curr1 = head;
			Node curr2 = num.head;
			BigNatural maior = null;
			boolean iguais = true;

			// comparar os digitos de cada numero
			while (curr1.next != null) {
				if (curr1.item > curr2.item) {
					maior = this;
					iguais = false;
				} else if (curr1.item < curr2.item) {
					maior = num;
					iguais = false;
				}

				curr1 = curr1.next;
				curr2 = curr2.next;
			}

			geq = iguais || (maior == this);
		}

		return geq;
	}

	@Override
	public boolean equals(Object obj) {

		return this == obj || obj instanceof BigNatural
				&& equalsList((BigNatural) obj);
	}
	
	/**
	 * 
	 * @param other
	 * @return
	 * @requires other != null;
	 */
	private boolean equalsList(BigNatural other) {

		if (this.numDigitos != other.numDigitos)
			return false;

		Node current1 = this.head;
		Node current2 = other.head;

		while (current1 != null ) {
			if (current1.item != current2.item)
				return false;

			current1 = current1.next;
			current2 = current2.next;
		}

		return true;
	}


	@Override
	public String toString() {

		StringBuilder sb = new StringBuilder();
		Node curr = head;

		while (curr != null) {
			sb.append(curr.item);
			curr = curr.next;
		}

		return sb.reverse().toString();
	}

	
	/**
	 * Classe que representa um no do BigNatural atual 
	 * 
	 * 
	 */
	private static class Node {
		int item;
		Node next;

		public Node(int item, Node next) {
			this.item = item;
			this.next = next;
		}

		@Override
		public String toString() {
			return "Item: " + item;
		}
	}
}
