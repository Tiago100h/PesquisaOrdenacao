package componentes;

/**Classe que modela um No da arvoreAVL
 *@author Derlandy Belchior, Kevin Sossai, Marilio Freire de Almeida, Mauricio Valentin Junior 
 */

public class NoAVL {
	private Item info;
	private NoAVL dir, esq;
	private byte fB;
	
	/**
	 * Construtor do NoArv 
	 * @param elem = Item
	 */
	public NoAVL(Item elem) {
		this.info=elem;
		this.fB=0;
	}

	public Item getInfo() {
		return info;
	}

	public void setInfo(Item info) {
		this.info = info;
	}
	/**
	 * Obt�m o No � direita
	 * @return
	 */
	public NoAVL getDir() {
		return dir;
	}
	/**
	 * Coloca um No � direita
	 * @param dir
	 */
	public void setDir(NoAVL dir) {
		this.dir = dir;
	}

	/**
	 * Obt�m o No � esquerda
	 * @return
	 */
	public NoAVL getEsq() {
		return esq;
	}
	/**
	 * Coloca um No � esquerda
	 * @param esq
	 */
	public void setEsq(NoAVL esq) {
		this.esq = esq;
	}
	/**
	 * Obt�m o fator de balancemanto
	 * @param esq
	 */
	public byte getfB() {
		return fB;
	}
	/**
	 * Coloca o fator de balanceamento
	 * @param esq
	 */
	public void setfB(byte fB) {
		this.fB = fB;
	}
	

}
