package Dados;
import Dados.Multa;
/**Classe que modela uma ListaSimples de nos de Itens*/


public class ListaSimples {
	private  NoItem prim;
	private NoItem ult;
	private int quantNos;
/**
 * Construtor da Lista Simples sem parâmentro
 * this.prim = Primeiro da Lista.
 * this.ult = Ultimo da Lista
 * this.quantNos = quantidade de elementos 
 */
	 public ListaSimples() {
		this.prim=null;
		this.ult=null;
		this.quantNos=0;
	}
	/** 
	 *Obtém o primeiro da Lista  
	 * @return
	 */
	public NoItem getPrim() {
		return prim;
	}
	
	/**
	 * Coloca um No de item na primeira posição
	 * @param prim
	 */
	public void setPrim(NoItem prim) {
		this.prim = prim;
	}
	/**
	 * Obtém o ultimo da Lista
	 * @return
	 */
	public NoItem getUlt() {
		return ult;
	}
	/**
	 * Coloca um No de Item na última poisção 
	 * @param ult
	 */
	public void setUlt(NoItem ult) {
		this.ult = ult;
	}

	/**
	 * Obtém a quantidade de Nos inseridos
	 * @return
	 */
	public int getQuantNos() {
		return quantNos;
	}
	 /**
	  * Verifica de a Lista está vazia
	  * @return
	  */
	public boolean éVazia (){
		return (this.prim == null);
	}
/**
 * Insere um Item na Lista
 * @param elem
 */
	public void inserir (Multa multas){
		NoItem novoNo = new NoItem (multas);
		if (this.éVazia()){
			this.prim = novoNo; 
		} else {
			this.ult.setProx(novoNo); 
		}
		this.ult = novoNo; 
		this.quantNos++;
	}
	
//	public boolean pesquisar (Item elem){
//		NoItem atual = this.prim;
//		while (atual != null){
//			//if (atual.getInfo().getCpf().compareTo(elem.getCpf()) == 0){
//			if (ItemComparator.compare(atual.getInfo(), elem) == 0){
//				return false;
//			}
//			atual = atual.getProx();
//		}	
//		return true;
//	}
	
//	public NoItem pesquisarCpf (String cpf){
//		NoItem atual = this.prim; 
//		while (atual != null)
//		{ 
//			if (atual.getInfo().getCpf().equalsIgnoreCase(cpf))
//				return atual;
//			else atual = atual.getProx();
//		}	
//		return atual; 
//	}
	/**
	 * Imprime todos os elementos da Lista
	 */
	public String toString(){
		String msg="";
		NoItem atual = this.prim;
		while (atual != null){
			msg += atual.getInfo().toString()+"\n";
			atual = atual.getProx();
		}
		return msg;
	}
}

	

