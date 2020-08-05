package Classes_Importantes;

public abstract class Empregado {

	protected String nome, cargo;								//Criacao das variaveis de um Empregado
	protected double salario;

	
	/*
	 * Sobrescreve o metodo toString para uma melhor apresentacao ao usuario
	 */
	@Override
	public String toString() {
		return "\n----- PERFIL DO FUNCIONÁRIO -----\nNome: " + getNome() + "\nCargo: " + getCargo() + "\nSalário Base: "
				+ getSalario() + "\n---------------------------------\n";
	}

	//Criacao de Geters e Seters
	
	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setSalario(double novoSalario) {
		this.salario = novoSalario;
	}

	public double getSalario() {
		return salario;
	}
}
