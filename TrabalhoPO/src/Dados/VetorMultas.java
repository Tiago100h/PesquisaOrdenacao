package Dados;

import Dados.Multa;
/**Classe que modela um Vetor de Item*/


public class VetorMultas {
	private Multa vetItem [];
	private int nElem;


	/**
	 * Construtor da Classe VetorItem() sem par�metro
	 */
	public VetorMultas() {
		this.vetItem=null;
		this.nElem=0;
	}

	/**
	 * Construtor da Classe VetorItem() com par�metro
	 *  @param tam = tamanho do vetor
	 */
	public VetorMultas(int tam){
		this.vetItem=new Multa[tam];
		this.nElem=0;
	}

	/**
	 * Obt�m o tamanho do vetor
	 * @return tamanho do vetor
	 */
	public int tamVet(){
		return vetItem.length;
	}
	/**
	 * Obt�m o Conte�do da posi��o passado no par�metor
	 * @param i 
	 * @return   
	 */
	public Multa getVetItem(int i) {
		return vetItem[i];
	}
	/**
	 * Coloca a um Item na posi��o passado no par�metro
	 * @param i
	 * @param elem
	 */
	public void setVetItem(int i, Multa Multas) {
		this.vetItem[i] = Multas;
	}
	/**
	 * 
	 */
	//	public String toString (){
	//		String str="";
	//		for (int i=0; i< this.nElem; i++)
	//			str += this.vetItem[i].toString()+"\n";
	//		return str;
	//	}
	/**
	 *  Impprime i Item
	 * @return
	 */
}
