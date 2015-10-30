package Trabalho;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import Dados.Multa;


public class Apoio {
		
	/**
	 * Lê e grava multas de um arquivo no vetor
	 * @param caminhoArquivo Pasta em que o arquivo se encontra
	 * @param tamanhoVetor Tamanho do vetor
	 * @return Vetor de multas
	 */
	public static Multa[] lerArquivo(String caminhoArquivo, int tamanhoVetor) {		
		try {				
			FileInputStream stream = new FileInputStream(caminhoArquivo);
			InputStreamReader reader = new InputStreamReader(stream);
			BufferedReader br = new BufferedReader(reader);	
			Multa[] multas = new Multa[tamanhoVetor];
			int i = -1;
			for (String linha = br.readLine(); linha != null; linha = br.readLine()) {
				i++;
				Multa multa = new Multa();
				String[] campos = linha.split(";");
				multa.setPlaca(campos[0]);
				multa.setProprietario(campos[1]);
				multa.setLocal(campos[2]);
				multa.setData(campos[3]);
				multa.setHora(campos[4]);
				multas[i] = multa;				
			}	
			br.close();
			return multas;			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;		
	}

	
	/**
	 * Cria arquivo de multas a partir de um vetor
	 * @param multas Vetor de multas
	 * @param caminhoArquivo Pasta que o arquivo vai ser salvo
	 */
	public static void escreverArquivo(Multa[] multas, String caminhoArquivo) {
		try {
			FileWriter arquivo = new FileWriter(caminhoArquivo);
			PrintWriter gravarArquivo = new PrintWriter(arquivo);
			for (int i = 0; i < multas.length; i++) {
				gravarArquivo.println(multas[i].getPlaca() + multas[i].getProprietario()
						+ multas[i].getLocal() + multas[i].getData() + multas[i].getHora());
			}
			gravarArquivo.close();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}		
	}
	
}
