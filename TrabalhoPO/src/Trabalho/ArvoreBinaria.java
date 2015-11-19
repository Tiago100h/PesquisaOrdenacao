package Trabalho;

import Dados.Multa;

import Dados.NoABB;
import Dados.VetorMultas;



/**Classe que modela a Arovore Binaria 
 *@author Derlandy Belchior, Kevin Sossai, Marilio Freire de Almeida, Mauricio Valentin Junior 
 */


public class ArvoreBinaria {
	private int quantNos;
	private NoABB raiz;
	public static String achadosARV="";
	public  static boolean encontrouARV = false;
	/**
	 * Construtor da Arvore Binária
	 */
	public ArvoreBinaria(){
		this.raiz = null;
		this.quantNos=0;
	}
	/**
	 * Teste se a Arvore está vazia
	 * @return
	 */
	public boolean éVazia(){
		return (this.raiz==null);
	}
	/**
	 * Obtém a o tamanho da Arvore
	 * @return
	 */
	public int getQuantNos() {
		return quantNos;
	}
	/**
	 * Obtém a  raiz da Arvore
	 * @return
	 */
	public NoABB getRaiz() {
		return raiz;
	}
	/**
	 * Coloca um NoARV na raiz da Arvore
	 * @param raiz
	 */
	public void setRaiz(NoABB raiz) {
		this.raiz = raiz;
	}


	/**
	 * Insere uma Item na Arvore binária
	 * @param elem
	 * @return
	 */
	
	int cont = 0;
	
	public boolean insere (Multa multas){
		boolean existe;
		existe = this.pesquisa (multas);
		
		if (existe)
			return false;
		else{
			this.raiz = this.insere (multas, this.raiz);
			this.quantNos++;
			return true;
		}
	}
	/**
	 * Recursão para a Inserção
	 * @param elem
	 * @param no
	 * @return
	 */
	private NoABB insere (Multa multas, NoABB no){
		
		NoABB novo = null;
		if (no == null){
			novo = new NoABB(multas);
			return novo;
		}
		else {

			if ((multas.getPlaca().compareTo(no.getInfo().getPlaca()))<0) {
				no.setEsq(this.insere (multas, no.getEsq()));
				return no;
			}
			else{
				no.setDir(this.insere (multas, no.getDir()));
				return no;
			}
		}
	}

	/**
	 * Faz a pesquisa na Arvore binaria
	 * Utilizada na Inserção de um Item
	 * @param elem
	 * @return
	 */

	public boolean pesquisa (Multa multas){
		NoABB temp;
		temp = this.pesquisa (multas, this.raiz);
		if (temp != null)
			return true;
		else
			return false;
	}
	/**
	 * Recurção da Pesquisa
	 * @param elem
	 * @param no
	 * @return
	 */	
	private NoABB pesquisa (Multa multas, NoABB no){
		NoABB temp;
		temp = no;
		if (temp != null){
			if(temp.getInfo().getPlaca().compareTo(multas.getPlaca())<0) 
				temp = this.pesquisa (multas, temp.getEsq());
			else{
				if (temp.getInfo().getPlaca().compareTo(multas.getPlaca())>0) 
					temp = this.pesquisa (multas, temp.getDir());
			}
		}
		return temp;
	}

	//
	//	private NoARV pesquisa (String cpf, NoARV no){
	//		NoARV temp;
	//		temp = no;
	//		if (temp != null){
	//			if(temp.getInfo().getCpf().compareTo(cpf)<0) 
	//
	//				temp = this.pesquisa (cpf, temp.getEsq());
	//			else{
	//				if (temp.getInfo().getCpf().compareTo(cpf)>0) 
	//					temp = this.pesquisa (cpf, temp.getDir());
	//			}
	//		}
	//		return temp;
	//	}




	/**
	 * Caminhamento Central utilizado na ABB Balanceada
	 * @return
	 */
	public VetorMultas CamCentral (){
		int []n= new int[1];
		n[0]=0;
		VetorMultas vet = new VetorMultas(this.getQuantNos());
		return (FazCamCentral (this.raiz, vet, n));
	}
	/**
	 * Recursão do Caminhamento Central
	 * @param arv
	 * @param vet
	 * @param n
	 * @return
	 */
	private VetorMultas FazCamCentral (NoABB arv, VetorMultas vet, int []n){
		if (arv != null) {
			vet = FazCamCentral (arv.getEsq(),vet,n);
			vet.setVetItem(n[0], arv.getInfo());
			n[0]++;
			vet = FazCamCentral (arv.getDir(),vet,n);
		}
		return vet;
	}
	/**
	 * Balanceia a Arvore ABB Balanceada
	 * @param vetor
	 * @return
	 */

	public ArvoreBinaria BalancearArvore (VetorMultas vetor) {
		ArvoreBinaria temp = new ArvoreBinaria();
		this.Balancear (vetor, temp, 0, (vetor.tamVet())-1);
		return temp;
	}
	/**
	 * Recursão do BalancearArvore
	 * @param vetor
	 * @param temp
	 * @param inic
	 * @param fim
	 */
	private void Balancear (VetorMultas vetor, ArvoreBinaria temp, int inic, int fim) {
		int meio;
		if (fim >= inic){
			meio = (inic+fim)/2;
			temp.insere(vetor.getVetItem(meio));
			this.Balancear (vetor, temp, inic, meio - 1);
			this.Balancear (vetor, temp, meio + 1, fim);
		}
	}

	
	/**
	 * Pesquisa os 200 Nomes na Arvore
	 * @param vetString
	 */
	public void chamaPesquisaABB(String []vetString){

		for (int i = 0; i < vetString.length; i++) {
			pesquisaABB(vetString[i],raiz);
			if (ArvoreBinaria.encontrouARV == false){
				ArvoreBinaria.achadosARV += vetString[i] +" NOME INEXISTENTE"+ "\n";	
			}
			ArvoreBinaria.encontrouARV = false;
		}
	}
	/**
	 * Recursão do  chamaPesquisaABB
	 * @param nome
	 * @param no
	 * @return
	 */
	private NoABB pesquisaABB (String placa, NoABB no){
		NoABB temp = no;
		if (temp != null){
			if (placa.compareTo(temp.getInfo().getPlaca())== 0){
				ArvoreBinaria.achadosARV += temp.getInfo().toString() + "\n";
				ArvoreBinaria.encontrouARV = true;
				if ((temp.getEsq() != null))
					this.pesquisaABB (placa, temp.getEsq());
				if ((temp.getDir() != null))
					this.pesquisaABB (placa, temp.getDir());
			}else{	
				if ((temp.getEsq() != null) &&(placa.compareTo(temp.getInfo().getPlaca()) < 0))
					this.pesquisaABB (placa, temp.getEsq());
				else{
					if ((temp.getDir() != null) &&(placa.compareTo(temp.getInfo().getPlaca()) > 0))
						this.pesquisaABB (placa, temp.getDir());
				}
			}
		}
		return temp;
	}
	
	
	String strArvore;
	
	
	
	



}

