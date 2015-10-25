package Principal;

import java.util.Calendar;

import arquivo.GravaArquivo;

public class Main {

	static  String  vetorArquivos[] = new String[15];
	static int vetTam[] = new int [15];	

	public static void main(String[] args) throws Exception {

		int fim = 5;
		
		CarregaVetores();
		
		//TESTE ABB
		//Gerencia.executaABBBalanceada(vetorArquivos[6]);
		//if(fim == 9) return;
		
		String informacoes = ""; 
		GravaArquivo relatorio = new GravaArquivo("src/txts/relatorio.txt");
		
		informacoes = "NUMERO_EXECUCAO|METODO|ARQUIVO|TEMPO\n";

		for(int j = 0; j < 2; j++){

			Calendar cal = Calendar.getInstance();    
			System.out.println(cal.getTime() + "\n");   
			
			for (int i = 0; i < fim; i++) {
				informacoes += j+1 + "|QUICKSORT|" + vetorArquivos[i] + "|" + Gerencia.executaQuick(vetorArquivos[i], vetTam[i]) + "\n";			
			}
	
			System.out.println("--------------------------------------------------------------");
			
			for (int i = 0; i < fim; i++) {
				informacoes += j+1 + "|QUICKSORT com INSERÇÃO|" + vetorArquivos[i] + "|" + Gerencia.executaQuickInsertion(vetorArquivos[i], vetTam[i]) + "\n";			
			}
			
			System.out.println("--------------------------------------------------------------");
			
			for (int i = 0; i < fim; i++) {
				informacoes += j+1 + "|ARVORE ABB BALANCEADA|" + vetorArquivos[i] + "|" + Gerencia.executaABBBalanceada(vetorArquivos[i]) + "\n";			
			}
			
			System.out.println("--------------------------------------------------------------");
	
			for (int i = 0; i < fim; i++) {
				informacoes += j+1 + "|ARVORE AVL|" + vetorArquivos[i] + "|" + Gerencia.executaAVL(vetorArquivos[i]) + "\n";			
			}
			
			System.out.println("--------------------------------------------------------------");
			
			for (int i = 0; i < fim; i++) {
				informacoes += j+1 + "|HASHING ENCADEADO|" + vetorArquivos[i] + "|" + Gerencia.executaHashing(vetorArquivos[i], vetTam[i]) + "\n";			
			}
		}
					
		relatorio.gravaTexto(informacoes);
		relatorio.fechaArquivo();
				
	}

	static public void CarregaVetores(){
		vetorArquivos[0] = "pessoa500ord";
		vetorArquivos[1] = "pessoa500alea";
		vetorArquivos[2] = "pessoa500inv";
		vetorArquivos[3] = "pessoa1000ord";
		vetorArquivos[4] = "pessoa1000alea";
		vetorArquivos[5] = "pessoa1000inv";
		vetorArquivos[6] = "pessoa5000ord";
		vetorArquivos[7] = "pessoa5000alea";
		vetorArquivos[8] = "pessoa5000inv";
		vetorArquivos[9] = "pessoa10000ord";
		vetorArquivos[10] = "pessoa10000alea";
		vetorArquivos[11] = "pessoa10000inv";
		vetorArquivos[12] = "pessoa50000ord";
		vetorArquivos[13] = "pessoa50000alea";
		vetorArquivos[14] = "pessoa50000inv";

		vetTam[0] = 500;
		vetTam[1] = 500;
		vetTam[2] = 500;
		vetTam[3] = 1000;
		vetTam[4] = 1000;
		vetTam[5] = 1000;
		vetTam[6] = 5000;
		vetTam[7] = 5000;
		vetTam[8] = 5000;
		vetTam[9] = 10000;
		vetTam[10] = 10000;
		vetTam[11] = 10000;
		vetTam[12] = 50000;
		vetTam[13] = 50000;
		vetTam[14] = 50000;

	}
}
