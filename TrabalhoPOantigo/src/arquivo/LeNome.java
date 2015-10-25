package arquivo;



import java.io.File;
import java.io.FileNotFoundException;
import java.util.Locale;
import java.util.NoSuchElementException;
import java.util.Scanner;
/**Classe que manipula a leitura dos 200 cpfs*/


public class LeNome{

	private Scanner entrada;
	 /**
	  * Construtor que recebe o nome do arquivo de 200 cpfs
	  * @param nome
	  * @throws FileNotFoundException
	  */
	public LeNome (String nome) throws FileNotFoundException{
		try{
			this.entrada = new Scanner (new File (nome));
		}
		catch (FileNotFoundException e){
			throw new FileNotFoundException ("ARQUIVO NÃO ENCONTRADO");
		}
	}
	
	/**
	 * Método manipula a leitura dos cpfs, passando eles para um vetor de String.
	 * @param tam
	 * @return
	 * @throws NoSuchElementException
	 * @throws IllegalStateException
	 * @throws ArrayIndexOutOfBoundsException
	 */
	public String[] leNome (int tam)throws NoSuchElementException,
	IllegalStateException, ArrayIndexOutOfBoundsException {
		String linha;
		String [] vet = new String[tam];
		try{
			int i=0;
				while (this.entrada.hasNext()){
					linha = this.entrada.nextLine();
					vet[i] = (leLinhaCpf(linha));
					i++;
				}
			
			return vet;
		}
		catch (IllegalStateException erro){
			throw new IllegalStateException ("ERRO AO LER O ARQUIVO");
		}
	}
	
	/**
	 * Método que lê cada linha do txt, retorna o cpf com String
	 * @param linha
	 * @return
	 * @throws NoSuchElementException
	 */
	private String leLinhaCpf (String linha)throws NoSuchElementException {
		Scanner str = new Scanner(linha);
		String  cpf;
		str.useDelimiter(";");
		str.useLocale(Locale.US);
		try{

			cpf = str.next();
			str.close();
			return cpf;
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

