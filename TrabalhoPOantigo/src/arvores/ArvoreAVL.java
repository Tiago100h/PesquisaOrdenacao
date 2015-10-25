package arvores;


import componentes.Item;
import componentes.ItemComparator;
import componentes.NoAVL;
/**Classe que modela uma Arvore AVL*/


public class ArvoreAVL {
	private NoAVL raiz;
	private boolean h;
	public static String achadosAVL="";
	public  static boolean encontrouAVL = false;
	/**
	 * Construtor da Classe
	 */
	public ArvoreAVL() {
		this.raiz = null;
		this.h = true;
	}



	/** Método que insere um Item
	 * 
	 */
	public void insere (Item elem){
		this.raiz = this.insere (elem, this.raiz);
	} 
	
	private NoAVL insere (Item elem, NoAVL no){
		if (no == null){
			NoAVL novo = new NoAVL(elem);
			this.h = true;
			return novo;
		}
		else{
			if ((ItemComparator.compare(elem, no.getInfo())<0)){
				no.setEsq(this.insere (elem, no.getEsq()));
				no = this.balancearDir (no);
				return no;
			}
			else{
				no.setDir(this.insere (elem, no.getDir()));
				no = this.balancearEsq (no);
				return no;
			}
		}
	}
	/**
	 * Balanceia a Arvore para a Esquerda
	 * @param no
	 * @return
	 */
	private NoAVL balancearEsq (NoAVL no){
		if (this.h)
			switch (no.getfB()){
			case -1: no.setfB((byte)0);
			this.h = false;
			break;
			case 0 : no.setfB((byte)1);
			break;
			case 1 : no = this.rotaçãoEsquerda (no); }
		return no;
	}
	/**
	 * Balanceia a Arvore para Direita
	 * @param no
	 * @return
	 */
	private NoAVL balancearDir (NoAVL no){
		if (this.h)
			switch (no.getfB()){
			case 1 : no.setfB((byte)0);
			this.h = false;
			break;
			case 0 : no.setfB((byte)-1);
			break;
			case -1: no = this.rotaçãoDireita (no);
			}
		return no;
	}
	/**
	 * Rotáciona a Arvore para Esquerda
	 * @param no
	 * @return
	 */
	private NoAVL rotaçãoEsquerda (NoAVL no){
		NoAVL temp1, temp2;
		temp1 = no.getDir();
		if (temp1.getfB() == 1){
			no.setDir (temp1.getEsq());
			temp1.setEsq(no);
			no.setfB((byte)0);
			no = temp1;
		}
		else {
			temp2 = temp1.getEsq();
			temp1.setEsq(temp2.getDir());
			temp2.setDir(temp1);
			no.setDir(temp2.getEsq());
			temp2.setEsq(no);
			if (temp2.getfB() == 1)
				no.setfB((byte)-1);
			else
				no. setfB((byte)0);
			if (temp2. getfB() == -1)
				temp1. setfB((byte)1);
			else
				temp1. setfB((byte)0);
			no = temp2;
		}
		no.setfB((byte)0);
		this.h = false;
		return no;
	}
	
	/**
	 * Rotáciona a Arvore para Direita
	 * @param no
	 * @return
	 */
	private NoAVL rotaçãoDireita (NoAVL no){
		NoAVL temp1, temp2;
		temp1 = no.getEsq();
		if (temp1.getfB() == -1){
			no.setEsq(temp1.getDir());
			temp1.setDir(no);
			no.setfB((byte)0);
			no = temp1;
		}
		else {
			temp2 = temp1.getDir();
			temp1.setDir(temp2.getEsq());
			temp2.setEsq(temp1);
			no.setEsq(temp2.getDir());
			temp2.setDir(no);
			if (temp2.getfB() == -1)
				no.setfB((byte)1);
			else
				no.setfB((byte)0);
			if (temp2.getfB() == 1)
				temp1.setfB((byte)-1);
			else
				temp1.setfB((byte)0);
			no = temp2;
		}
		no.setfB((byte)0);
		this.h = false;
		return no;
	}
	
	/**
	 * Método de pesquisar os 200 cpfs na arvore AVL
	 * @param vetString
	 */
	public void chamaPesquisaAVL(String []vetString){

		for (int i = 0; i < vetString.length; i++) {
			pesquisaAVL(vetString[i], this.raiz);
			if (ArvoreAVL.encontrouAVL == false){
				ArvoreAVL.achadosAVL += vetString[i] +" NOME INEXISTENTE"+ "\n";	
			}
			ArvoreAVL.encontrouAVL = false;
		}
	}
	/**
	 * Recursão do chamaPesquisaAVL
	 * @param nome
	 * @param no
	 * @return
	 */

	private NoAVL pesquisaAVL (String nome, NoAVL no){
		NoAVL temp = no;
		if (temp != null){
			if (nome.compareTo(temp.getInfo().getNome())== 0){
				ArvoreAVL.achadosAVL += temp.getInfo().toString() + "\n";
				ArvoreAVL.encontrouAVL = true;
				if ((temp.getEsq() != null))
					this.pesquisaAVL (nome, temp.getEsq());
				if ((temp.getDir() != null))
					this.pesquisaAVL (nome, temp.getDir());
			}else{	
				if ((temp.getEsq() != null) &&(nome.compareTo(temp.getInfo().getNome()) < 0))
					this.pesquisaAVL (nome, temp.getEsq());
				else{
					if ((temp.getDir() != null) &&(nome.compareTo(temp.getInfo().getNome()) > 0))
						this.pesquisaAVL (nome, temp.getDir());
				}
			}
		}
		return temp;
	}
	
	
	String strArvore = "";
	
	public String toString(){
		
		String strArvore = "";
		imprimirAVL(this.raiz);					
		return strArvore;
	}
	
	
	private void imprimirAVL(NoAVL no){
		
		if(no != null) {
		
			imprimirAVL(no.getEsq());
			//System.out.print(no.getInfo().getNome() + ";" + no.getInfo().getCpf() + ";" + no.getInfo().getFuncao() + "\n");
			strArvore += no.getInfo().getNome() + ";" + no.getInfo().getCpf() + ";" + no.getInfo().getFuncao() + "\n";
			imprimirAVL(no.getDir());
		}
		
	}



}
