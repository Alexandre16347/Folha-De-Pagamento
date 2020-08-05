package Classes_Importantes;

import java.util.Calendar;

public class Datas {

	Calendar dataLimite;	//Cria a variavel do calendario

	public boolean setdata(String data) {

		/*
		 * Ira pegar a String digitada pelo usuario que em seguida sera quebrada em um vetor 
		 * e convertida em inteiros, que por sua vez serão adicionadas a variavel de Calendar;
		 * 
		 * Dentre todo esse processo ela sera submetida a algumas excecoes na qual elas podem 
		 * ocorrer nos valores digitados pelo usuario;
		 */
		try {
			/*
			 * Primeira Excecao: Testa a String para saber se o usuario digitou alguma letra ou 
			 * caractere diferente da data aceita (Ex.: 30/12)
			 */
			for (int i = 0; i < data.length(); i++) {
				Character caractere = data.charAt(i);
				if (!(Character.isDigit(caractere)) && !caractere.equals('/')) {
					throw new Exception();
				}
			}
			
			String[] arrayData = data.split("/");									//Quebra a String em um vetor sem a "/", o dia e o mes
			int[] arrayDiaEMes = new int[2];										//Cria um vetor de int para armazenar o dia e o mes da data
			
			arrayDiaEMes[0] = Integer.valueOf(arrayData[0]);						//Converte o dia de String para inteiro
			arrayDiaEMes[1] = Integer.valueOf(arrayData[1]);						//Converte o mes de String para inteiro
			
			/*
			 * Segunda Excecao: Testa o dia e o mes para saber se estao dentro dos parametros de 
			 * calendarios conhecidos 
			 * (dia: de 1 a 30)
			 * (mes: de 1 a 12)
			 */
			if(arrayDiaEMes[0]<1 || arrayDiaEMes[0]>30)									
				throw new Exception();
			if(arrayDiaEMes[1]<1 || arrayDiaEMes[1]>12)
				throw new Exception();
			
			this.dataLimite = Calendar.getInstance();								//Chama a instancia do Calendar
			this.dataLimite.set(Calendar.DAY_OF_MONTH, arrayDiaEMes[0]);			//Atribui o dia ao Calendar
			this.dataLimite.set(Calendar.MONTH, arrayDiaEMes[1]);					//Atribui o mes ao Calendar
			
			return true;
		} catch (Exception e) { 													//Caso algua excecao ocorra
			System.out.println("Digite uma data valida (Ex.: 30/12)");
			return false;
		}

	}

	
	/*
	 * Sobrescreve meu objeto Data para uma melhor apresentacao
	 */
	@Override
	public String toString() {
		return this.dataLimite.get(Calendar.DAY_OF_MONTH) + "/" + this.dataLimite.get(Calendar.MONTH);
	}

	//Construtor
	public Datas(String data) {
		setdata(data);
	}
	
	public Datas() {
		
	}
	

}
