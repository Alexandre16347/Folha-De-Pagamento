package Listas;

import java.util.ArrayList;

import Classes_Importantes.Gratificacao;

public class Vencimento {
	

	private double valorMensal = 0;													//Ciacao de variaveis usadas
	private int contGrat = 0;

	protected ArrayList<Gratificacao> lista;										//Cria minha lista de Gratificacoes

	public Vencimento() {
		lista = new ArrayList<Gratificacao>();
	}

	//Metodo para cadastrar o Gratificacao
	public boolean adicionaNaLista(Gratificacao g) {
		return lista.add(g);
	}
	
	//Metodo para calcular o valor de todas as Gratificacoes com o salario do Empregado
	public double valorDaGratificacao() {
		if (!lista.isEmpty() || getLista() != null) {
			setContGrat(0);
			setValorMensal(0);
			for (Gratificacao gratificacao : lista) {
				setContGrat(getContGrat() + 1);
				setValorMensal(gratificacao.getValorDaGraftificacao() + getValorMensal());
			}
			return getValorMensal();
		}
		return 0;

	}

	//Remove Gratificacoes
	public void removeDaLista(int index) {
		if (recuperaDaLista(index) != null) {
			lista.remove(index);
			System.out.println("GRATIFICACAO EXCLUIDA");
		}

	}
	
	//Metodo para recuperar a lista de Gratificacoes completa do Empregado
	public Gratificacao recuperaDaLista(int index) {

		for (Gratificacao gratificacao : lista) {									//Percorre a lista

			if (lista.indexOf(gratificacao) == index)								//Testa cada Gratificacao para encontrar a procurada
				return gratificacao;
		}
		Gratificacao g = null;														//Caso não encontre nenhm Empregado cria um novo e o atribue nulo
		System.err.println("Gratificacao Inexistente");
		return g;
	}
	
	//Metodo que recupera toda a lista de Gratificacao do Empregado e mostra ao usuario
	public void recuperaListaDeGratificacao() {

		if (lista.isEmpty()) {
			System.err.println("O empregado não possui gratificações...");
		} else {
			System.out.println("\n-LISTA-DE-VENCIMENTOS-\n");
			for (Gratificacao g : lista) {
				System.out.println("\nGratificação: " + g + "\nIndex: " + lista.indexOf(g));
			}
		}
	}
	
	
	//Criacao de Geters e Seters renomeados

	public void atualizaData(int index, String nova_data) {
		Gratificacao g = recuperaDaLista(index);
		g.setDataTrabalhada(nova_data);

	}

	public double getValorMensal() {
		return valorMensal;
	}

	public void setValorMensal(double valorMensal) {
		this.valorMensal = valorMensal;
	}

	public int getContGrat() {
		return contGrat;
	}

	public void setContGrat(int contGrat) {
		this.contGrat = contGrat;
	}
	
	public ArrayList<Gratificacao> getLista() {
		return lista;
	}

}
