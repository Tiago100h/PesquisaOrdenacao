package vetores;

import componentes.Item;
import componentes.ListaSimples;
import componentes.NoItem;

public class VetorHashing { //trocar o nome para VetorHash
	private ListaSimples [] vetHashing; // uma veotor de lista Sipls
	private int tamanho; 

	public VetorHashing(int tam) {
		int porc;
		porc =  (tam * 10)/100;
		tam += porc;
		//System.out.println("tamhoooooooo"+tam);
		this.vetHashing= new ListaSimples[tam];
		this.tamanho=tam;
		for (int i = 0; i < this.tamanho; i++) {
			this.vetHashing[i] = new ListaSimples(); 
		}
	}

	public ListaSimples getVetHashing(int i) {
		return this.vetHashing[i];
	}
	public int getTamanho() {
		return tamanho;
	}

	public void insere(Item elem, int tam){
		//	String cpf= elem.getCpf().toLowerCase(); //toLowercase  muda letra maisculas para minusculas.
		int pos = 0;
		String nome= elem.getNome(); 
		if( tam == 500){ pos = funcaoHash500(nome);}
		if( tam == 1000){ pos = funcaoHash1000(nome);}
		if( tam == 5000){ pos = funcaoHash5000(nome);}
		if( tam == 10000){ pos = funcaoHash10000(nome);}
		if( tam == 50000){ pos = funcaoHash50000(nome);}
		//System.out.println("Posição "+ pos+" " + elem.toString());
		this.vetHashing[pos].inserir(elem);
	}

	
	public int funcaoHash500(String nome){
		int mod;
		int m = 0 ;
		char carac;
		for (int i=0; i<nome.length(); i++){

			carac = nome.charAt(i);
			m += Character.getNumericValue(carac);
		}
		mod = (m % 503);
		//System.out.println("PAssou aki");

		return mod;
	}
	public int funcaoHash1000(String nome){
		int m=0 ;
		char carac;
		for (int i=0; i<nome.length(); i++){

			carac = nome.charAt(i);
			m += Character.getNumericValue(carac);
		}
		m = (m % 1009);
		return m;
	}

	public int funcaoHash5000(String nome){
		int m=0 ;
		char carac;
		for (int i=0; i<nome.length(); i++){

			carac = nome.charAt(i);
			m += Character.getNumericValue(carac);
		}
		m = (m % 5003);
		return m;
	}

	public int funcaoHash10000(String nome){
		int m=0 ;
		char carac;
		for (int i=0; i<nome.length(); i++){

			carac = nome.charAt(i);
			m += Character.getNumericValue(carac);
		}
		m = (m % 10007);
		return m;
	}

	public int funcaoHash50000(String nome){
		int m=0 ;
		char carac;
		for (int i=0; i<nome.length(); i++){

			carac = nome.charAt(i);
			m += Character.getNumericValue(carac);
		}
		m = (m % 50021);
		return m;
	}


	public String chamaPesquisaHash(String []vetString , int tam){
		String resu = "";
		for (int i = 0; i < vetString.length; i++) {	
			if ((pesquisaHash(vetString[i], tam)) != "")
				resu+=pesquisaHash(vetString[i], tam);
			
			else
				resu+=vetString[i] +" NOME INEXISTENTE\n";
		}
			return resu;
		}

		public  String pesquisaHash(String nome , int tam){
			String str = "";
			NoItem aux;
			int pos = 0;
			if( tam == 500){ pos = this.funcaoHash500(nome);}
			if( tam == 1000){ pos = this.funcaoHash1000(nome);}
			if( tam == 5000){ pos = this.funcaoHash5000(nome);;}
			if( tam == 10000){ pos = this.funcaoHash5000(nome);;}
			if( tam == 50000){ pos = funcaoHash50000(nome);}
			if (pos>=0 && pos<this.tamanho){
				if (this.vetHashing[pos].getPrim()!=null){
					aux = this.getVetHashing(pos).getPrim();
					while (aux != null){
						if (aux.getInfo().getNome().compareTo(nome)==0)
							str += aux.getInfo().toString()+"\n";
						aux = aux.getProx();
					}
				}				
			}
			return str;
		}
		
		
		public String toString(){
			String msg = "";
			for (int i = 0; i < this.vetHashing.length;i++)
			{
				msg+= this.vetHashing[i].toString() + "\n";
			}
			return msg;		 
		}

	}





