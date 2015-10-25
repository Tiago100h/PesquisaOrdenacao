package componentes;

/**Classe que modela um No de Item utilizado na ListaSimples
 *@author Derlandy Belchior, Kevin Sossai, Marilio Freire de Almeida, Mauricio Valentin Junior 
 */
public class NoItem {
	private Item info;
	private NoItem prox;
	/**
	 * Construtor da classe
	 * @param elem
	 */
	public NoItem(Item elem){
		this.info = elem;
	}

	/**
	 * Obt�m o Item 
	 * @return
	 */
	public Item getInfo() {
		return info;
	}
	/**
	 * Coloca um Item
	 * @param info
	 */
	public void setInfo(Item info) {
		this.info = info;
	}
	/**
	 * Obt�m o ponteiro para o pr�ximo da lista
	 * @return
	 */
	public NoItem getProx() {
		return prox;
	}

	/**
	 * Coloca um NoItem na no ponteiro para proxima posi��o na Lista
	 * @param prox
	 */
	public void setProx(NoItem prox) {
		this.prox = prox;
	}

}
