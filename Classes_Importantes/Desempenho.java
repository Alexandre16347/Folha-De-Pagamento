package Classes_Importantes;

public class Desempenho extends Gratificacao{
	
	public Desempenho(double salario, String data_trabalhada) {
		super.porcentagem = 0.05;
		super.dataTrabalhada = new Datas(data_trabalhada);
		super.setTipo(TipoGratificacao.Desempenho);
		super.calculaGratificacao(salario);
	}
}
