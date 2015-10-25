package componentes;

/**Classe que modela um No da arvore Binaria
 *@author Derlandy Belchior, Kevin Sossai, Marilio Freire de Almeida, Mauricio Valentin Junior 
 */

public class NoARV {

	private Item info;
	private NoARV dir, esq;
	/**
	 * Construtor do NoArv 
	 * @param info = Items
	 */
	public NoARV(Item elem) {
		this.info=elem;
	}
	/**
	 * Obtém o No à direita
	 * @return
	 */
	public NoARV getDir() {
		return dir;
	}
	/**
	 * Coloca um No à direita
	 * @param dir
	 */
	public void setDir(NoARV dir) {
		this.dir = dir;
	}
	/**
	 * Obtém o No à esquerda
	 * @return
	 */
	public NoARV getEsq() {
		return esq;
	}
	/**
	 * Coloca um No à esquerda
	 * @param esq
	 */
	public void setEsq(NoARV esq) {
		this.esq = esq;
	}
	/**
	 *  Obtém um NoARV
	 * @return
	 */
	public Item getInfo() {
		return info;
	} 
	/**
	 * Coloca um Item
	 * @param novo
	 */
	public void setInfo(Item novo) {
		this.info = novo;
	}
}
