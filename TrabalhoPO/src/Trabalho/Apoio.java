package Trabalho;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import Dados.Multa;

public class Apoio {

	/**
	 * Le e Grava multas de um arquivo no vetor
	 * @param caminhoArquivo Pasta em que o arquivo se encontra
	 * @param tamanhoVetor Tamanho do vetor
	 * @return Vetor com as multas
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
				multa.setDataHora(Apoio.converterData(campos[3] + campos[4]));				
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
	@SuppressWarnings("deprecation")
	public static void escreverArquivo(Multa[] multas, String caminhoArquivo) {
		try {
			FileWriter arquivo = new FileWriter(caminhoArquivo);
			PrintWriter gravarArquivo = new PrintWriter(arquivo);
			for (int i = 0; i < multas.length; i++) {
				gravarArquivo.println(multas[i].getPlaca() + ";" + multas[i].getProprietario() + ";" + multas[i].getLocal()
						+ ";" + multas[i].getDataHora().getDate() + "/" + (multas[i].getDataHora().getMonth() + 1)
						+ "/" + (multas[i].getDataHora().getYear() + 1900) + ";" + multas[i].getDataHora().getHours()
						+ ":" + multas[i].getDataHora().getMinutes());
			}
			gravarArquivo.close();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}		
	}

	/**
	 * Converte variavel do tipo String de data e hora em variavel do tipo Date
	 * @param dataHora String de data e hora no formato "dd/MM/yyyyHH:mm"
	 * @return Data do tipo Date
	 */
	public static Date converterData(String dataHora){
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyyHH:mm");
		Date data = null;
		try {
			data = formato.parse(dataHora);
		} catch (ParseException e) {
			System.out.println(e.getMessage());;
		}
		return data;		
	}

	/**
	 * Le e grava placas de um arquivo no vetor
	 * @param caminhoArquivo Pasta em que o arquivo se encontra
	 * @param tamanhoVetor Tamanho do vetor
	 * @return Vetor com as placas
	 */
	public static String[] lerPlacas(String caminhoArquivo, int tamanhoVetor){
		try {				
			FileInputStream stream = new FileInputStream(caminhoArquivo);
			InputStreamReader reader = new InputStreamReader(stream);
			BufferedReader br = new BufferedReader(reader);	
			String[] placas = new String[tamanhoVetor];
			int i = -1;
			for (String linha = br.readLine(); linha != null; linha = br.readLine()) {
				i++;
				placas[i] = linha;				
			}	
			br.close();
			return placas;			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;		
	}

	/**
	 * @param indices Vetor com os indices
	 * @param multas Vetor de multas
	 * @param caminhoArquivo Pasta que o arquivo vai ser salvo
	 * @param placas Vetor de placas
	 */
	@SuppressWarnings("deprecation")
	public static void escreveMultasPlacas(int[] indices, Multa[] multas, String caminhoArquivo, String[] placas){		
		try {
			FileWriter arquivo = new FileWriter(caminhoArquivo);
			PrintWriter gravarArquivo = new PrintWriter(arquivo);
			for (int i = 0; i < indices.length; i++) {
				int esquerda = indices[i];
				while (esquerda > 0 && multas[esquerda].getPlaca().equals(multas[esquerda - 1].getPlaca())) {
					esquerda--;
				}
				int direita = indices[i];
				while (direita > 0 && direita < multas.length - 1 && multas[direita].getPlaca().equals(multas[direita + 1].getPlaca())) {
					direita++;
				}
				if (indices[i] == -1) {
					gravarArquivo.println("Placa " + placas[i] + " sem multa.");
				} else {
					gravarArquivo.println("Placa " + multas[indices[i]].getPlaca() + " " + (direita - esquerda + 1) + " multa(s):");
					for (int j = esquerda; j <= direita; j++) {
						gravarArquivo.println(multas[j].getDataHora().getDate() + "/" + (multas[j].getDataHora().getMonth() + 1)
								+ "/" + (multas[j].getDataHora().getYear() + 1900) + " " + multas[j].getDataHora().getHours()
								+ ":" + multas[j].getDataHora().getMinutes());
					}
				}
			}
			gravarArquivo.close();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

}