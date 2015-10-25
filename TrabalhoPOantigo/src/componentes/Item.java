package componentes;

/**Classe que modela o Item (Proprietário)*/

public class Item {

	private String cpf;
	private String funcao;
	private String nome;


	public Item() {
		this.cpf=null;
		this.nome=null;
		this.funcao=null;
	}


	public Item(String nome, String cpf, String funcao) {
		this.nome = nome;
		this.cpf = cpf;
		this.funcao = funcao;
	}


	public String getCpf() {
		return cpf;
	}


	public void setCpf(String cpf) {
		this.cpf = cpf;
	}


	public String getFuncao() {
		return funcao;
	}


	public void setFuncao(String funcao) {
		this.funcao = funcao;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String toString() {
		return nome + ";" + cpf + ";" + funcao;

	}
	


}
