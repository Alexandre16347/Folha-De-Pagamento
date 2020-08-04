package Listas;

import java.util.ArrayList;

import Classes_Importantes.*;

public class ListaDeFuncionario {

	private static ArrayList<Empregado> listaDeEmpregados;

	public static ArrayList<Empregado> getListaDeEmpregados() {
		return listaDeEmpregados;
	}
	
	public static boolean cadastraEmpregado(String nome, String cargo) {
		Vencimento v;
		if (listaDeEmpregados == null) {
			listaDeEmpregados = new ArrayList<Empregado>();
		}

		switch (cargo) {
		case "Funcionário":
			Empregado funcionario = new Funcionario(nome);
			 v = new Vencimento();
			listaDeEmpregados.add(funcionario);
			ListaDeGratificacoes.criaEmpregado(funcionario, v);
			return true;
		case "Gerente":
			Empregado gerente = new Gerente(nome);
			 v = new Vencimento();
			listaDeEmpregados.add(gerente);
			ListaDeGratificacoes.criaEmpregado(gerente, v);
			return true;
		default:
			System.err.println("Erro!! Opção de cargo inválida...");
			return false;
		}

	}

	public static boolean removeEmpregado(int index) {
		if (recuperaEmpregado(index) != null) {
			Empregado e = recuperaEmpregado(index);
			ListaDeGratificacoes.getListaDeGratificacoes().remove(e);
			listaDeEmpregados.remove(index);
			System.out.println("\nEMPREGADO EXCLUIDO");
			return true;
		}
		return false;
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

	public static Empregado recuperaEmpregado(int index) {
		for (Empregado empregado : listaDeEmpregados) {
			if(listaDeEmpregados.indexOf(empregado) == index)
				return empregado;
		}
		Empregado e = null;
		System.err.println("Empregado Inexistente");
		return e;
	}

	public static void recuperaListaDeEmpregados() {
		System.out.println("\n-LISTA-DE-FUNCIONÁRIOS-\n");
		for (Empregado empregado : listaDeEmpregados) {
			System.out.println("Nome: " + empregado.getNome() + "\nCargo: " + empregado.getCargo() + "\nSalário: "
					+ empregado.getSalario() + "\nId: " + listaDeEmpregados.indexOf(empregado) + "\n---------------\n");
		}

	}

}
