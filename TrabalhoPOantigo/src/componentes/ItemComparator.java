package componentes;


/**Classe que compara e aordena os itens caso o cpf seja iguais
 *@author Derlandy Belchior, Kevin Sossai, Marilio Freire de Almeida, Mauricio Valentin Junior 
 */

public  class  ItemComparator  {
	/**
	 * Se o i1 for igual ao i2 retona 0
	 * Se o i1 for menor do que i2 retona -1
	 * Se o i1 for maior do que i2 retona 1
	 * @param i1
	 * @param i2
	 * @return
	 */
	public static  int compare(Item i1, Item i2){
		
		int nomeComp = i1.getNome().compareToIgnoreCase(i2.getNome());
		
		if(nomeComp != 0){
			return nomeComp;
		}
		
		int cpfComp =  i1.getCpf().compareToIgnoreCase(i2.getCpf());
		
		if(cpfComp != 0){
			return cpfComp;
		}
		
		return i1.getFuncao().compareToIgnoreCase(i2.getFuncao());
		
	}

}
