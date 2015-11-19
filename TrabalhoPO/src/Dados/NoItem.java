package Dados;
import Dados.Multa;
/**Classe que modela um No de Item utilizado na ListaSimples
 *@author Derlandy Belchior, Kevin Sossai, Marilio Freire de Almeida, Mauricio Valentin Junior 
 */
public class NoItem {
	private Multa info;
	private NoItem prox;
	/**
	 * Construtor da classe
	 * @param elem
	 */
	public NoItem(Multa multas){
		this.info = multas;
	}

	/**
	 * Obtém o Item 
	 * @return
	 */
	public Multa getInfo() {
		return info;
	}
	/**
	 * Coloca um Item
	 * @param info
	 */
	public void setInfo(Multa info) {
		this.info = info;
	}
	/**
	 * Obtém o ponteiro para o próximo da lista
	 * @return
	 */
	public NoItem getProx() {
		return prox;
	}

	/**
	 * Coloca um NoItem na no ponteiro para proxima posição na Lista
	 * @param prox
	 */
	public void setProx(NoItem prox) {
		this.prox = prox;
	}

}
