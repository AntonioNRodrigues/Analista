public interface BigNaturalInterface {
	/**
	 * Determina o sucessor do numero atual
	 * @return Devolve um novo BigNatural que representa o sucessor do numero
	 * atual
	 */
	public BigNatural suc();

	/**
	 * Determina o valor da soma entre dois numeros BigNatural
	 * 
	 * @param num
	 *            Numero a ser somado ao numero atual
	 * @return Valor da soma
	 */
	public BigNatural sum(BigNatural num);

	/**
	 * Determina o valor da multiplicacao de um determinado numero BigNatural
	 * pelo numero atual
	 * 
	 * @param num
	 *            Numero a multiplicar
	 * @return Valor da multiplicacao
	 * @requires num != null;
	 */
	public BigNatural mult(BigNatural num);

	/**
	 * Determina se um numero num eh maior ou igual que o numero atual
	 * 
	 * @param num
	 * @return
	 * @requires num != null;
	 */
	public boolean geq(BigNatural num);

	/**
	 * Adiciona um numero item ah lista de numeros atual
	 * 
	 * @param item
	 *            Numero a ser adicionado
	 */
	public void addLast(int item);
}
