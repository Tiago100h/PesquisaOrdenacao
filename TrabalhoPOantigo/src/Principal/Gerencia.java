package Principal;

import vetores.VetorHashing;
import vetores.VetorItem;
import arquivo.GravaArquivo;
import arquivo.LeArquivo;
import arquivo.LeNome;
import arvores.ArvoreAVL;
import arvores.ArvoreBinaria;

public class Gerencia {

	/** QUICKSORT**/
	public static double executaQuick(String arquivo, int tam) throws Exception{
		
		double inicio;
		LeArquivo entrada =null;
		VetorItem vetItem = null;

		GravaArquivo saidaPesq = new GravaArquivo("src/resultadosPesq/resutPesqBinQuick"+arquivo+".txt") ;
		String vetStringCpf[] = new String[200]; 	
		LeNome entradaCpf = new LeNome("src/txts/nomes.txt");
		vetStringCpf = entradaCpf.leNome(200);

		inicio = System.currentTimeMillis();
		entrada = new LeArquivo("src/txts/"+arquivo+".txt");
		vetItem = new VetorItem(tam);
		vetItem = entrada.leVetor(tam);
		vetItem.quicksort();	

		GravaArquivo saidaOrd = new GravaArquivo("src/resultadosOrdenacao/Quick"+arquivo+".txt");
		saidaOrd.gravaArquivo(vetItem);
		saidaOrd.fechaArquivo();

		saidaPesq.gravaTexto(vetItem.chamaPesqBinaria(vetStringCpf));
		saidaPesq.fechaArquivo();

		System.out.println("Tempo QUICKSORT " + arquivo + " = " + (System.currentTimeMillis() - inicio));
		return System.currentTimeMillis() - inicio;
	}
	
	/** QUICKSORT COM INSERÇÃO**/
	public static double executaQuickInsertion(String arquivo, int tam) throws Exception{
		
		double inicio;
		LeArquivo entrada = null;
		VetorItem vetItem = null;
		
		GravaArquivo saidaPesq = new GravaArquivo("src/resultadosPesq/resutPesqBinQuickInsertion"+arquivo+".txt") ;
		String vetStringNomes[] = new String[200]; 	
		LeNome entradaNome = new LeNome("src/txts/nomes.txt");
		vetStringNomes = entradaNome.leNome(200);
		
		inicio = System.currentTimeMillis();
		entrada = new LeArquivo("src/txts/"+arquivo+".txt");
		vetItem = new VetorItem(tam);
		vetItem = entrada.leVetor(tam);
		vetItem.quicksortInsercao();			

		GravaArquivo saidaOrd = new GravaArquivo("src/resultadosOrdenacao/QuickInsertion"+arquivo+".txt");
		saidaOrd.gravaArquivo(vetItem);
		saidaOrd.fechaArquivo();

		saidaPesq.gravaTexto(vetItem.chamaPesqBinaria(vetStringNomes));
		saidaPesq.fechaArquivo();

		System.out.println("Tempo QUICKINSERTION " + arquivo + " = " +(System.currentTimeMillis() - inicio));
		return System.currentTimeMillis() - inicio;

	}
	
	/** Vetor de HASHING**/
	public static double executaHashing(String arquivo, int tam) throws Exception{
		
		double inicio;
		LeArquivo entrada = null;
		VetorHashing hash = new VetorHashing(tam);

		GravaArquivo saidaPesq = new GravaArquivo("src/resultadosPesq/resutPesqHash"+arquivo+".txt") ;
		String vetStringNomes[] = new String[200]; 	
		LeNome entradaNome = new LeNome("src/txts/nomes.txt");
		vetStringNomes = entradaNome.leNome(200);

		inicio = System.currentTimeMillis();
		entrada = new LeArquivo("src/txts/"+arquivo+".txt");
		hash = entrada.leHash(tam);
		
		saidaPesq.gravaTexto(hash.chamaPesquisaHash(vetStringNomes, tam));
		saidaPesq.fechaArquivo();

		System.out.println("Tempo VETOR HASHING " + arquivo + " = " +(System.currentTimeMillis() - inicio));
		return System.currentTimeMillis() - inicio;
	}
	
	/** Arvore ABB Balanceada**/
	public static double executaABBBalanceada(String arquivo) throws Exception{
		
		double inicio;
		LeArquivo entrada = null;
		ArvoreBinaria arv = new ArvoreBinaria();

		String vetStringNomes[] = new String[200]; 	
		LeNome entradaNomes = new LeNome("src/txts/nomes.txt");
		vetStringNomes = entradaNomes.leNome(200);

		GravaArquivo saidaPesq = new GravaArquivo("src/resultadosPesq/resutPesqABBBala"+arquivo+".txt") ;
		inicio = System.currentTimeMillis();
		entrada = new LeArquivo("src/txts/" + arquivo + ".txt");
		arv = entrada.leArvBalanceada();	
		
		GravaArquivo saidaOrd = new GravaArquivo("src/resultadosOrdenacao/ABBBalanceada"+arquivo+".txt");
		saidaOrd.gravarArquivo(arv);
		saidaOrd.fechaArquivo();
		
		arv.chamaPesquisaABB(vetStringNomes);
		saidaPesq.gravaTexto(ArvoreBinaria.achadosARV);
		saidaPesq.fechaArquivo();
		ArvoreBinaria.achadosARV = "";
		System.out.println("Tempo ABB BALANCEADA " + arquivo + " = " + (System.currentTimeMillis() - inicio));
		
		return System.currentTimeMillis() - inicio;
	}
	
	/** Arvore AVL**/
	public static double executaAVL(String arquivo) throws Exception{
		double inicio;
		LeArquivo entrada =null;
		ArvoreAVL avl = new ArvoreAVL();

		GravaArquivo saidaNome = new GravaArquivo("src/resultadosPesq/resutPesqAVL"+arquivo+".txt") ;
		String vetStringNomes[] = new String[200]; 	
		LeNome entradaNomes = new LeNome("src/txts/nomes.txt");
		vetStringNomes = entradaNomes.leNome(200);

		inicio = System.currentTimeMillis();
		entrada = new LeArquivo("src/txts/"+arquivo+".txt");
		avl = entrada.leAVL();

		GravaArquivo saidaOrd = new GravaArquivo("src/resultadosOrdenacao/ArvoreAVL"+arquivo+".txt");
		saidaOrd.gravarArquivo(avl);
		saidaOrd.fechaArquivo();
		
		avl.chamaPesquisaAVL(vetStringNomes);
		saidaNome.gravaTexto(ArvoreAVL.achadosAVL);
		saidaNome.fechaArquivo();
		ArvoreAVL.achadosAVL="";
		System.out.println("Tempo AVL " + arquivo + " = " + (System.currentTimeMillis() - inicio));
		return System.currentTimeMillis() - inicio;
	}
	


}
