package Dados;



/**Classe que modela um No da arvore Binaria
 *@author Derlandy Belchior, Kevin Sossai, Marilio Freire de Almeida, Mauricio Valentin Junior 
 */

public class NoABB {

	private Multa info;
	private NoABB dir, esq;
	/**
	 * Construtor do NoArv 
	 * @param info = Items
	 */
	public NoABB(Multa multas) {
		this.info=multas;
	}
	/**
	 * Obtém o No à direita
	 * @return
	 */
	public NoABB getDir() {
		return dir;
	}
	/**
	 * Coloca um No à direita
	 * @param dir
	 */
	public void setDir(NoABB dir) {
		this.dir = dir;
	}
	/**
	 * Obtém o No à esquerda
	 * @return
	 */
	public NoABB getEsq() {
		return esq;
	}
	/**
	 * Coloca um No à esquerda
	 * @param esq
	 */
	public void setEsq(NoABB esq) {
		this.esq = esq;
	}
	/**
	 *  Obtém um NoARV
	 * @return
	 */
	public Multa getInfo() {
		return info;
	} 
	/**
	 * Coloca um Item
	 * @param novo
	 */
	public void setInfo(Multa novo) {
		this.info = novo;
	}
}