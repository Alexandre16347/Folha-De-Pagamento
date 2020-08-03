package Classes_Importantes;

public abstract class Empregado {

	protected String nome, cargo;
	protected double salario;

	@Override
	public String toString() {
		return "----- PERFIL DO FUNCIONÁRIO -----\nNome: " + getNome() + "\nCargo: " + getCargo() + "\nSalário Base: "
				+ getSalario() + "\n---------------------------------\n";
	}

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
