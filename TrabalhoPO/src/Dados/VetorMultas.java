package Dados;

import Dados.Multa;
/**Classe que modela um Vetor de Item*/


public class VetorMultas {
	private Multa vetItem [];
	private int nElem;


	/**
	 * Construtor da Classe VetorItem() sem parâmetro
	 */
	public VetorMultas() {
		this.vetItem=null;
		this.nElem=0;
	}

	/**
	 * Construtor da Classe VetorItem() com parâmetro
	 *  @param tam = tamanho do vetor
	 */
	public VetorMultas(int tam){
		this.vetItem=new Multa[tam];
		this.nElem=0;
	}

	/**
	 * Obtém o tamanho do vetor
	 * @return tamanho do vetor
	 */
	public int tamVet(){
		return vetItem.length;
	}
	/**
	 * Obtém o Conteúdo da posição passado no parâmetor
	 * @param i 
	 * @return   
	 */
	public Multa getVetItem(int i) {
		return vetItem[i];
	}
	/**
	 * Coloca a um Item na posição passado no parâmetro
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
