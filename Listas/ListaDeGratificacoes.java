package Listas;

import java.util.HashMap;
import java.util.Map;

import Classes_Importantes.*;

public class ListaDeGratificacoes {

	private static Map<Empregado, Vencimento> listaDeGratificacoes;							//Criacao de um mapa para referenciar o Empregado
																							//a sua lista de Gratificacoes

	//Metodo para adicionar uma nova Gratificacao (Por desempenho) ao Empregado
	public static boolean adicionaGratificacao(int index_funcionario, String data_trabalhada) {
		Vencimento v;
		Empregado e = ListaDeFuncionario.recuperaEmpregado(index_funcionario);

		if (listaDeGratificacoes == null) {
			listaDeGratificacoes = new HashMap<>();
		}

		v = (Vencimento) listaDeGratificacoes.get(e);
		v.adicionaNaLista(new Desempenho(e.getSalario(), data_trabalhada));
		
		return true;

	}
	
	//Metodo para adicionar uma nova Gratificacao (Por hora extra) ao Empregado
	public static boolean adicionaGratificacao(int index_funcionario, String data_trabalhada, int horas_trabalhadas) {
		Vencimento v;
		Empregado e = ListaDeFuncionario.recuperaEmpregado(index_funcionario);

		if (listaDeGratificacoes == null) {
			listaDeGratificacoes = new HashMap<>();
		}

		v = (Vencimento) listaDeGratificacoes.get(e);
		v.adicionaNaLista(new HoraExtra(e.getSalario(), data_trabalhada, horas_trabalhadas));

		return true;

	}
	
	//Metodo para mostar toda a Folha de Pagamento ao Usuario
	public static void mostraFolhaDePagamento() {
		if (listaDeGratificacoes == null || listaDeGratificacoes.isEmpty()) {
			System.out.println(
					"\n\n-------------------------------------------------- FOLHA DE PAGAMENTO ---------------------------------------------------\n");
			System.err.println("\n\t\t\t\t\tNÃO POSSUI FUNCIONARIOS PARA APRESENTAR");
			System.out.println(
					"\n\n-------------------------------------------------------------------------------------------------------------------------\n");

		} else {
			System.out.println(
					"\n\n-------------------------------------------------- FOLHA DE PAGAMENTO ---------------------------------------------------\n");
			System.out.println(
					"Nome\t\tCargo\t\tSalário Base\tQtde. de Gratificações\t   Valor das Gratificações\tVencimento mensal\n");
			for (Empregado empregado : ListaDeFuncionario.getListaDeEmpregados()) {

				listaDeGratificacoes.get(empregado).valorDaGratificacao();

				System.out.printf("%-16s%-17sR$ %-10s%12s\t\t\t  R$ %-23sR$ %-17s\n", empregado.getNome(),
						empregado.getCargo(), empregado.getSalario(), listaDeGratificacoes.get(empregado).getContGrat(),
						listaDeGratificacoes.get(empregado).getValorMensal(),
						(empregado.getSalario() + listaDeGratificacoes.get(empregado).getValorMensal()));

			}
			System.out.println(
					"\n\n-------------------------------------------------------------------------------------------------------------------------\n");

		}
	}

	//Metodo para refenciar um novo Empregado a sua lista de Gratificacao 
	public static void criaEmpregado(Empregado e, Vencimento v) {
		if (listaDeGratificacoes == null) {
			listaDeGratificacoes = new HashMap<>();
		}
		listaDeGratificacoes.put(e, v);
	}

	//Metodo para a remocao de uma Gratificacao do Empregado
	public static boolean removeGratificacao(int index_funcionario, int index_gratificacao) {
		if (!listaDeGratificacoes.isEmpty() || listaDeGratificacoes != null) {						//Testa para saber se o Empregado possui Gratificacoes
			Empregado e = ListaDeFuncionario.getListaDeEmpregados().get(index_funcionario);			//Se tiver recupera o Empregado
			Vencimento v = (Vencimento) listaDeGratificacoes.get(e);								//Recupera a lista de Gratificacoes do Empregado
			v.removeDaLista(index_gratificacao);													//Remove a Gratifiacacao escolhida
			return true;
		}
		return false;
	}

	//Metodo para mostrar ao usuario a lista de gratificacoes do Empregado
	public static void mostraLista(int index_funcionario) {
		Empregado e = ListaDeFuncionario.recuperaEmpregado(index_funcionario);
		Vencimento v = listaDeGratificacoes.get(e);
		v.recuperaListaDeGratificacao();
	}

	
	//Criacao de Geters e Seters renomeados
	
	public static Gratificacao recuperaGratificacao(int index_funcionario, int index_gratificacao) {
		Empregado e = ListaDeFuncionario.getListaDeEmpregados().get(index_funcionario);
		Vencimento v = (Vencimento) listaDeGratificacoes.get(e);
		Gratificacao g = v.recuperaDaLista(index_gratificacao);
		if (g == null)
			System.out.println("Gratificacao Inexistente");
		return g;
	}
	
	public static Map<Empregado, Vencimento> getListaDeGratificacoes() {
		return listaDeGratificacoes;
	}

}
