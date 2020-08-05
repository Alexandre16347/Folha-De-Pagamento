package Classes_Importantes;

public class Gratificacao {
	
	protected double porcentagem;											//Criacao das varaveis de uma Gratificacao
	protected TipoGratificacao tipo;
	protected Datas dataTrabalhada;
	protected double valorDaGraftificacao = 0;
	
	//Calcula o valor da gatificacao (de desempenho) atraves da porcentagem e o salario
	public double calculaGratificacao(double salario) {
		this.valorDaGraftificacao = salario * this.porcentagem;

		return this.valorDaGraftificacao;
	}
	
	//Calcula o valor da gatificacao (de hora extra) atraves da porcentagem e o salario
	public double calculaGratificacao(double salario, int hora_trabalhada) {
		try {
			if(hora_trabalhada <= 0)
				throw new Exception();
			this.valorDaGraftificacao = salario * this.porcentagem * hora_trabalhada;
		} catch(Exception e) {
			System.out.println("VERIFIQUE O AS HORAS TRABALHADAS");
		}
		

		return this.valorDaGraftificacao;
	}


	/*
	 * Sobrescreve o metodo toString para uma melhor apresentacao ao usuario
	 */
	@Override
	public String toString() {
		
		return "Tipo gratificação: " + getTipo() + "\nValor da gratificação: " + getValorDaGraftificacao() + 
				"\nData trabalhada: " + getDataTrabalhada(); 
	}
	
	//Criacao de Geters e Seters
	
	public TipoGratificacao getTipo() {
		return tipo;
	}
	public void setTipo(TipoGratificacao tipo) {
		this.tipo = tipo;
	}
	public Datas getDataTrabalhada() {
		return dataTrabalhada;
	}
	public void setValor(double valor) {
		this.valorDaGraftificacao = valor;
	}
	
	public boolean setDataTrabalhada(String dataTrabalhada) {
		if(this.dataTrabalhada.setdata(dataTrabalhada))
			return true;
		return false;
	}
	
	public double getValorDaGraftificacao() {
		return valorDaGraftificacao;
	}

	public double getValor() {
		return valorDaGraftificacao;
	}
}
