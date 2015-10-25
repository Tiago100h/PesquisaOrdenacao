package arquivo;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import arvores.ArvoreBinaria;
import arvores.ArvoreAVL;
import vetores.VetorItem;
/**Classe que  manipula para gravar no arquivo
 *@author Derlandy Belchior, Kevin Sossai, Marilio Freire de Almeida, Mauricio Valentin Junior 
 */


public class GravaArquivo {
	private FileWriter writer;
	private PrintWriter saida;

	/**
	 * Construtor da classe GravaArquivo, recebe com parâmetro o nome do arquivo que será gerá deposi de gravado.
	 * @param nome
	 * @throws IOException
	 */
	public GravaArquivo (String nome) throws IOException{
		try{
			writer = new FileWriter(new File(nome));
			saida = new PrintWriter (writer);
		}
		catch (IOException e){
			throw new IOException ("ARQUIVO NÃO PODE SER ABERTO PARA GRAVAÇÃO");
		}
	}


	public void gravaArquivo (VetorItem vetor) throws IOException {
		this.saida.write(vetor.toString());
	}

	public void gravarArquivo(ArvoreBinaria arv) throws IOException {
		this.saida.write(arv.toString());
	}
	
	public void gravarArquivo(ArvoreAVL arv) throws IOException {
		this.saida.write(arv.toString());
	}
	
	public void gravaTexto (String texto) throws IOException {
		this.saida.write(texto);
	}
	
	/**
	 * Método responsável por fecahr o arquivo depois que foi gravado algo.
	 * @throws IOException
	 */
	public void fechaArquivo ()throws IOException{
		try{
			this.saida.close();
			this.writer.close();
		}
		catch (IOException e){
			throw new IOException ("ERRO AO FECHAR O ARQUIVO");
		}
	}
}
