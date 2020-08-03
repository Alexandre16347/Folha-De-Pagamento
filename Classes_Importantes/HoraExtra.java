package Classes_Importantes;

public class HoraExtra extends Gratificacao {
	
	public HoraExtra(Double salario, String data_trabalhada, int hora_trabalhada) {
		super.porcentagem = 0.001;
		super.dataTrabalhada = new Data(data_trabalhada);
		super.setTipo(TipoGratificacao.Hora_extra);
		super.calculaGratificacao(salario, hora_trabalhada);
	}

}
