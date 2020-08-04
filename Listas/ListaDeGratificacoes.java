package Listas;

import java.util.HashMap;
import java.util.Map;

import Classes_Importantes.*;

public class ListaDeGratificacoes {

	private static Map<Empregado, Vencimento> listaDeGratificacoes;

	public static Map<Empregado, Vencimento> getListaDeGratificacoes() {
		return listaDeGratificacoes;
	}

	public static void setListaDeGratificacoes(Map<Empregado, Vencimento> listaDeGratificacoes) {
		ListaDeGratificacoes.listaDeGratificacoes = listaDeGratificacoes;
	}

	public static boolean adicionaGratificacao(int index_funcionario, String data_trabalhada) {
		Vencimento v;
		Empregado e = ListaDeFuncionario.recuperaEmpregado(index_funcionario);

		if (listaDeGratificacoes == null) {
			listaDeGratificacoes = new HashMap<>();
		}

		if (!listaDeGratificacoes.containsKey(e)) {
			v = new Vencimento();
			v.adicionaNaLista(new Desempenho(e.getSalario(), data_trabalhada));

			listaDeGratificacoes.put(e, v);

		} else {
			v = (Vencimento) listaDeGratificacoes.get(e);
			v.adicionaNaLista(new Desempenho(e.getSalario(), data_trabalhada));

		}

		return true;

	}

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

	public static boolean removeGratificacao(int index_funcionario, int index_gratificacao) {
		if (!listaDeGratificacoes.isEmpty() || listaDeGratificacoes != null) {
			Empregado e = ListaDeFuncionario.getListaDeEmpregados().get(index_funcionario);
			Vencimento v = (Vencimento) listaDeGratificacoes.get(e);
			v.removeDaLista(index_gratificacao);
			return true;
		}
		return false;
	}

	public static void mostraLista(int index_funcionario) {
		Empregado e = ListaDeFuncionario.recuperaEmpregado(index_funcionario);
		Vencimento v = listaDeGratificacoes.get(e);
		v.recuperaListaDeGratificacao();
	}

	public static Gratificacao recuperaGratificacao(int index_funcionario, int index_gratificacao) {
		Empregado e = ListaDeFuncionario.getListaDeEmpregados().get(index_funcionario);
		Vencimento v = (Vencimento) listaDeGratificacoes.get(e);
		Gratificacao g = v.recuperaDaLista(index_gratificacao);
		if (g == null)
			System.out.println("Gratificacao Inexistente");
		return g;
	}

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

	public static void criaEmpregado(Empregado e, Vencimento v) {
		if (listaDeGratificacoes == null) {
			listaDeGratificacoes = new HashMap<>();
		}
		listaDeGratificacoes.put(e, v);
	}

}
