package Classes_Importantes;

import java.util.Calendar;

public class Data {
	
	Calendar dataLimite;

	public void setdata(String data) {
		
		String[] arrayData = data.split("/");
		int[] arrayDiaEMes = new int[2];
		arrayDiaEMes[0] = Integer.valueOf(arrayData[0]);
		arrayDiaEMes[1] = Integer.valueOf(arrayData[1]);
		
		this.dataLimite = Calendar.getInstance();
		this.dataLimite.set(Calendar.DAY_OF_MONTH, arrayDiaEMes[0]);
		this.dataLimite.set(Calendar.MONTH, arrayDiaEMes[1]);
		
		
	}
	
	@Override
	public String toString() {
		
		return this.dataLimite.get(Calendar.DAY_OF_MONTH) + "/" + this.dataLimite.get(Calendar.MONTH);
	}
	
	Data(String data){
		setdata(data);
	}
	
}
