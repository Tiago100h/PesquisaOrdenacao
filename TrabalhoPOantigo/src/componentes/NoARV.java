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
	 * Obt�m o No � direita
	 * @return
	 */
	public NoARV getDir() {
		return dir;
	}
	/**
	 * Coloca um No � direita
	 * @param dir
	 */
	public void setDir(NoARV dir) {
		this.dir = dir;
	}
	/**
	 * Obt�m o No � esquerda
	 * @return
	 */
	public NoARV getEsq() {
		return esq;
	}
	/**
	 * Coloca um No � esquerda
	 * @param esq
	 */
	public void setEsq(NoARV esq) {
		this.esq = esq;
	}
	/**
	 *  Obt�m um NoARV
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
