package MaquinaHumano;

import Listas.*;

public class Main {

	public static void main(String[] args) {

		ListaDeFuncionario.cadastraEmpregado("Clóvis", "Funcionário");
		ListaDeFuncionario.cadastraEmpregado("Roberval", "Gerente");
		ListaDeFuncionario.cadastraEmpregado("Bartolomeu", "Funcionário");
		ListaDeFuncionario.cadastraEmpregado("Clayton", "Gerente");	
		
		ListaDeGratificacoes.adicionaGratificacao(0, "25/04");
		ListaDeGratificacoes.adicionaGratificacao(0, "26/04", 1);
		ListaDeGratificacoes.adicionaGratificacao(2, "28/04");
		ListaDeGratificacoes.adicionaGratificacao(3, "30/04", 2);
		ListaDeGratificacoes.adicionaGratificacao(3, "01/05", 3);
		ListaDeGratificacoes.adicionaGratificacao(1, "27/04", 3);
		
		IU.IUPrincipal();


	}

}
