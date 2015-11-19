package Trabalho;
import Dados.Multa;
import Trabalho.NoAVL;
/**Classe que modela uma Arvore AVL*/


public class ArvoreAVL {
	private static NoAVL raiz;
	private boolean h;
	public static String achadosAVL="";
	public  static boolean encontrouAVL = false;
	/**
	 * Construtor da Classe
	 */
	public ArvoreAVL() {
		raiz = null;
		this.h = true;
	}



	/** Método que insere um Item
	 * 
	 */
	public void insere (Multa multas ){
		raiz = this.insere (multas, raiz);
	} 
	
	private NoAVL insere (Multa multas, NoAVL no){
		if (no == null){
			NoAVL novo = new NoAVL(multas);
			this.h = true;
			return novo;
		}
		else{

			if ((multas.getPlaca().compareTo(no.getInfo().getPlaca())) < 0){
				// Insere à esquerda e verifica se precisa balancear à direita
				no.setEsq(this.insere (multas, no.getEsq()));
				no = this.balancearDir (no);
				return no;
			}else{
				// Insere à direita e verifica se precisa balancear à esquerda
				no.setDir(this.insere (multas, no.getDir()));
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
	public static void chamaPesquisaAVL(String[] placa){

		for (int i = 0; i < placa.length; i++) {
			pesquisaAVL(placa[i],raiz);
			if (ArvoreAVL.encontrouAVL == false){
				ArvoreAVL.achadosAVL += placa[i] +" PLACA INEXISTENTE"+ "\n";	
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

	private static NoAVL pesquisaAVL (String placa, NoAVL no){
		NoAVL temp = no;
		if (temp != null){
			if (placa.compareTo(temp.getInfo().getPlaca())== 0){
				ArvoreAVL.achadosAVL += temp.getInfo().toString() + "\n";
				ArvoreAVL.encontrouAVL = true;
				if ((temp.getEsq() != null))
					pesquisaAVL (placa, temp.getEsq());
				if ((temp.getDir() != null))
					pesquisaAVL (placa, temp.getDir());
			}else{	
				if ((temp.getEsq() != null) &&(placa.compareTo(temp.getInfo().getPlaca()) < 0))
					pesquisaAVL (placa, temp.getEsq());
				else{
					if ((temp.getDir() != null) &&(placa.compareTo(temp.getInfo().getPlaca()) > 0))
						pesquisaAVL (placa, temp.getDir());
				}
			}
		}
		return temp;
	}
	
	
	String strArvore = "";
	
	
	
	

}
