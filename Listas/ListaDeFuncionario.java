package Listas;

import java.util.ArrayList;

import Classes_Importantes.*;

public class ListaDeFuncionario {

	private static ArrayList<Empregado> listaDeEmpregados;					//Cria minha lista de Empregados

	public static ArrayList<Empregado> getListaDeEmpregados() {
		return listaDeEmpregados;
	}
	
	//Metodo para cadastrar o funcionario
	public static boolean cadastraEmpregado(String nome, String cargo) {
		Vencimento v;
		if (listaDeEmpregados == null) {									//Primeiro Testa para saber se a lista de funcionario ja existe
			listaDeEmpregados = new ArrayList<Empregado>();					//Se nao existe ele cria uma nova
		}

		switch (cargo) {													//Vai selecionar o tipo do cargo do funcionario
		case "Funcionário":										
			Empregado funcionario = new Funcionario(nome);					//Cria um Novo Empregado do tipo Funcionario
			 v = new Vencimento();											//Vencimento é onde ficam as listas de gratificacoes de cada Empregado
			listaDeEmpregados.add(funcionario);								//Adiciona o novo Empregado a lista
			ListaDeGratificacoes.criaEmpregado(funcionario, v);				//Referencia o Empregado a sua respectiva lista de Gratificacoes
			return true;
		case "Gerente":										
			Empregado gerente = new Gerente(nome);							//Cria um Novo Empregado do tipo Gerente
			 v = new Vencimento();											//Vencimento é onde ficam as listas de gratificacoes de cada Empregado
			listaDeEmpregados.add(gerente);									//Adiciona o novo Empregado a lista
			ListaDeGratificacoes.criaEmpregado(gerente, v);					//Referencia o Empregado a sua respectiva lista de Gratificacoes
			return true;
		default:															//Caso o usuario tente adicionar um Empregado diferente
			System.err.println("Erro!! Opção de cargo inválida...");
			return false;
		}

	}

	//Remove o empregado e sua respectiva lista de gratificacoes
	public static boolean removeEmpregado(int index) {
		if (recuperaEmpregado(index) != null) {								//Primeiro ele testa para saber se o Empregado existe (se nao é nulo)
			Empregado e = recuperaEmpregado(index);							//Se existir ele recupera e atribue a um avariavel
			ListaDeGratificacoes.getListaDeGratificacoes().remove(e);		//Remove sua lista de gratificacao
			listaDeEmpregados.remove(index);								//Remove o empregado da lista
			System.out.println("\nEMPREGADO EXCLUIDO");
			return true;
		}
		return false;
	}

	//Metodo que recupera toda a lista de Empregado e mostra ao usuario
	public static void recuperaListaDeEmpregados() {
		System.out.println("\n-LISTA-DE-FUNCIONÁRIOS-\n");
		for (Empregado empregado : listaDeEmpregados) {
			System.out.println("Nome: " + empregado.getNome() + "\nCargo: " + empregado.getCargo() + "\nSalário: "
					+ empregado.getSalario() + "\nId: " + listaDeEmpregados.indexOf(empregado) + "\n---------------\n");
		}

	}
	
	//Criacao de Geters e Seters renomeados
	
	public static Empregado recuperaEmpregado(int index) {
		if(!listaDeEmpregados.isEmpty()) {									//Testa para saber se a lista de Empregados esta vazia
			for (Empregado empregado : listaDeEmpregados) {					//Percorre a lista	
				if(listaDeEmpregados.indexOf(empregado) == index)			//Testa cada Empregado para encontrar o procurado
					return empregado;
			}
		}
		Empregado e = null;													//Caso não encontre nenhm Empregado cria um novo e o atribue nulo
		System.err.println("Empregado Inexistente");
		return e;
	}
	
	public static void atualizaEmpregadoNome(int index, String novo_nome) {
		recuperaEmpregado(index).setNome(novo_nome);
	}

	public static void atualizaEmpregado(int index, double novo_salario) {
		recuperaEmpregado(index).setSalario(novo_salario);
	}

	public static void atualizaEmpregado(int index, String novo_nome, Double novo_salario) {
		recuperaEmpregado(index).setNome(novo_nome);
		recuperaEmpregado(index).setSalario(novo_salario);
	}

}
