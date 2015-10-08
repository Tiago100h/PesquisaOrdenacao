package Trabalho;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

import Dados.Multa;

public class Apoio {

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
			return multas;
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;		
	}
}
