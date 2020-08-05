package Classes_Importantes;

import java.util.Calendar;

public class Datas {

	Calendar dataLimite;

	public void setdata(String data) {

		
		try {
			for (int i = 0; i < data.length(); i++) {
				Character caractere = data.charAt(i);
				if (!(Character.isDigit(caractere)) && !caractere.equals('/')) {
					throw new Exception();
				}
			}
			
			String[] arrayData = data.split("/");
			int[] arrayDiaEMes = new int[2];
			
			arrayDiaEMes[0] = Integer.valueOf(arrayData[0]);
			arrayDiaEMes[1] = Integer.valueOf(arrayData[1]);
			
			if(arrayDiaEMes[0]<1 || arrayDiaEMes[0]>30)
				throw new Exception();
			if(arrayDiaEMes[1]<1 || arrayDiaEMes[1]>12)
				throw new Exception();
			
			this.dataLimite = Calendar.getInstance();
			this.dataLimite.set(Calendar.DAY_OF_MONTH, arrayDiaEMes[0]);
			this.dataLimite.set(Calendar.MONTH, arrayDiaEMes[1]);
			System.out.println("GRATIFICACAO ADICIONADA");
		} catch (Exception e) {
			System.out.println("Digite uma data valida (Ex.: 30/12)");
		}

	}

	@Override
	public String toString() {

		return this.dataLimite.get(Calendar.DAY_OF_MONTH) + "/" + this.dataLimite.get(Calendar.MONTH);
	}

	Datas(String data) {
		setdata(data);
	}

}
