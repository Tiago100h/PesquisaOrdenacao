package Trabalho;
import Dados.Multa;

/**Classe que modela um No da arvoreAVL
 *@author Derlandy Belchior, Kevin Sossai, Marilio Freire de Almeida, Mauricio Valentin Junior 
 */

public class NoAVL {
	private Multa info;
	private NoAVL dir, esq;
	private byte fB;
	
	/**
	 * Construtor do NoArv 
	 * @param elem = Item
	 */
	public NoAVL(Multa multas) {
		this.info=multas;
		this.fB=0;
	}

	public Multa getInfo() {
		return info;
	}

	public void setInfo(Multa info) {
		this.info = info;
	}
	/**
	 * Obtém o No à direita
	 * @return
	 */
	public NoAVL getDir() {
		return dir;
	}
	/**
	 * Coloca um No à direita
	 * @param dir
	 */
	public void setDir(NoAVL dir) {
		this.dir = dir;
	}

	/**
	 * Obtém o No à esquerda
	 * @return
	 */
	public NoAVL getEsq() {
		return esq;
	}
	/**
	 * Coloca um No à esquerda
	 * @param esq
	 */
	public void setEsq(NoAVL esq) {
		this.esq = esq;
	}
	/**
	 * Obtém o fator de balancemanto
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
