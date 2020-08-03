package Classes_Importantes;

public class Gratificacao {
	
	protected double porcentagem;
	protected TipoGratificacao tipo;
	protected Data dataTrabalhada;
	protected double valorDaGraftificacao = 0;
	
	public boolean equals(Gratificacao g, Gratificacao gg) {
		if(g.getValor() == gg.getValor() && gg.getTipo().equals(gg.getTipo())) {
			return true;
		}
		return false;
	}
	
	@Override
	public String toString() {
		
		return "Tipo gratificação: " + getTipo() + "\nValor da gratificação: " + getValorDaGraftificacao() + 
				"\nData trabalhada: " + getDataTrabalhada(); 
	}
	
	public TipoGratificacao getTipo() {
		return tipo;
	}
	public void setTipo(TipoGratificacao tipo) {
		this.tipo = tipo;
	}
	public Data getDataTrabalhada() {
		return dataTrabalhada;
	}
	public void setValor(double valor) {
		this.valorDaGraftificacao = valor;
	}
	
	public void setDataTrabalhada(String dataTrabalhada) {
		this.dataTrabalhada.setdata(dataTrabalhada);
	}
	
	public double getValorDaGraftificacao() {
		return valorDaGraftificacao;
	}

	public double getValor() {
		return valorDaGraftificacao;
	}

	public double calculaGratificacao(double salario) {
		this.valorDaGraftificacao = salario * this.porcentagem;

		return this.valorDaGraftificacao;
	}
	
	public double calculaGratificacao(double salario, int hora_trabalhada) {
		this.valorDaGraftificacao = salario * this.porcentagem * hora_trabalhada;

		return this.valorDaGraftificacao;
	}
}
