
package arquivo;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Locale;
import java.util.NoSuchElementException;
import java.util.Scanner;

import componentes.Item;

import vetores.VetorHashing;
import vetores.VetorItem;

import arvores.ArvoreAVL;
import arvores.ArvoreBinaria;


/**Classe responsável por gerencia a leituta dos txts. */


public class LeArquivo {
	private Scanner entrada;
	
	/**
	 *  Construtor que recebo como parâmetro  o nome do arquivo que será lido.
	 * @param nome
	 * @throws FileNotFoundException
	 */
	public LeArquivo (String nome) throws FileNotFoundException{
		try{
			this.entrada = new Scanner (new File (nome));
		}
		catch (FileNotFoundException e){
			throw new FileNotFoundException ("ARQUIVO NÃO ENCONTRADO");
		}
	}
	/**
	 * Usado para ler do txt para um vetor de Item.
	 * @param tam
	 * @return
	 * @throws NoSuchElementException
	 * @throws IllegalStateException
	 * @throws ArrayIndexOutOfBoundsException
	 */
	public VetorItem leVetor (int tam)throws NoSuchElementException,
	IllegalStateException, ArrayIndexOutOfBoundsException {
		String linha;
		VetorItem vet = new VetorItem(tam);
		try{
			
			while (this.entrada.hasNext()){
				linha = this.entrada.nextLine();
				vet.insere(leLinha(linha));
			}
			return vet;
		}
		catch (IllegalStateException erro){
			throw new IllegalStateException ("ERRO AO LER O ARQUIVO");
		}
	}
	
	/**
	 * Usado para ler do txt para arvore ABB não balanceada.
	 * @return
	 * @throws NoSuchElementException
	 * @throws IllegalStateException
	 * @throws ArrayIndexOutOfBoundsException
	 */
	public ArvoreBinaria leArvore() throws NoSuchElementException,
	IllegalStateException, ArrayIndexOutOfBoundsException {
		String linha;
		ArvoreBinaria arv= new ArvoreBinaria();
		try{
			while (this.entrada.hasNext()){
				linha = this.entrada.nextLine();
				arv.insere(leLinha(linha));
				
			}
			return arv;
		}
		catch (IllegalStateException erro){
			throw new IllegalStateException ("ERRO AO LER O ARQUIVO");
		}
	}
	
	/**
	 * Usado para ler do txt para uma vetor de hash.
	 * @param tam
	 * @return
	 * @throws NoSuchElementException
	 * @throws IllegalStateException
	 * @throws ArrayIndexOutOfBoundsException
	 */
	//Usado para ler a lista (Carrega na lista)
	public VetorHashing leHash(int tam) throws NoSuchElementException,
	IllegalStateException, ArrayIndexOutOfBoundsException {
		String linha;
		VetorHashing hash= new VetorHashing(tam);
		try{
			while (this.entrada.hasNext()){
				linha = this.entrada.nextLine();
				hash.insere((leLinha(linha)), tam); // terminar
				
			}
			return hash;
		}
		catch (IllegalStateException erro){
			throw new IllegalStateException ("ERRO AO LER O ARQUIVO");
		}
	}
	
	/**
	 * Usado para ler do txt para uma arvore ABB balanceada.
	 * @return
	 * @throws NoSuchElementException
	 * @throws IllegalStateException
	 * @throws ArrayIndexOutOfBoundsException
	 */
	public ArvoreBinaria leArvBalanceada() throws NoSuchElementException,
	IllegalStateException, ArrayIndexOutOfBoundsException {
		
		//int contLinha = 0;
		String linha;
		ArvoreBinaria arv = new ArvoreBinaria();
		try{
			while (this.entrada.hasNext()){
				linha = this.entrada.nextLine();				
				Item it = leLinha(linha);
				arv.insere(it);

				if((arv.getQuantNos() % 500) == 0){ // a cada 500 inserção a arvore a balanceada
					//System.out.print("Banlanceou com " + arv.getQuantNos() + "\n");
					VetorItem ord = arv.CamCentral();
					arv = arv.BalancearArvore(ord);
				}
			}
			return arv;
		}
		catch (IllegalStateException erro){
			throw new IllegalStateException ("ERRO AO LER O ARQUIVO");
		}
	}
	
	/**
	 * Usado para ler do txt para uma arvore AVl.
	 * @return
	 * @throws NoSuchElementException
	 * @throws IllegalStateException
	 * @throws ArrayIndexOutOfBoundsException
	 */
	public ArvoreAVL leAVL() throws NoSuchElementException,
	IllegalStateException, ArrayIndexOutOfBoundsException {
		String linha;
		ArvoreAVL avl = new ArvoreAVL();
		try{
			while (this.entrada.hasNext()){
				linha = this.entrada.nextLine();
				avl.insere(leLinha(linha));
				
			}
			return avl;
		}
		catch (IllegalStateException erro){
			throw new IllegalStateException ("ERRO AO LER O ARQUIVO");
		}
	}
	/**
	 * Usado para ler as linahs do txt  e retorna um Item .
	 * @param linha
	 * @return
	 * @throws NoSuchElementException
	 */
	//Le linah ultilizados em todos os metodos de ler anteriormente
	private Item leLinha (String linha)throws NoSuchElementException {
		Scanner str = new Scanner(linha);

		String nome, funcao, cpf;
		str.useDelimiter(";");
		str.useLocale(Locale.US);
		try{
			nome = str.next();
			cpf = str.next();
			funcao = str.next();
				
			str.close();
			
			return (new Item(nome, cpf, funcao));
		}
		catch (NoSuchElementException e){
			throw new NoSuchElementException ("ARQUIVO DIFERENTE DO REGISTRO " + e.getMessage());
		}
	}
	
	/**
	 * Fecha o  Arquivo
	 * @throws IllegalStateException
	 */
	public void fechaArquivo ()throws IllegalStateException{
		try{
			this.entrada.close();
		}
		catch (IllegalStateException e){
			throw new IllegalStateException ("ERRO AO FECHAR O ARQUIVO");
		}
	}

}
