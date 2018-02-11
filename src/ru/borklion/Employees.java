package ru.borklion;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Employees {
	private Map<String, String[]> data;
	private Map<String, String[]> data1;
	
	public Employees() {
		this.initEmpl();
	}
	
	private void initEmpl() {
		data = new HashMap<String, String[]>();
		data1 =new HashMap<String, String[]>();
		data.put("ЦЧБ" , new String[] {"ОТП Тамбовский","ОТП Воронежский"});
		data.put("СЗБ", new String[] {"ОТП Тульский"});
		data1.put("ОТП Тамбовский", new String[] {"Кульнев Борис Александрович","Прокофьев Александр Владимирович"});
	}

	public String[] getTerBanks() {
		Set<String> terBanks = data.keySet();
		return terBanks.toArray(new String[terBanks.size()]);
	}
	
	public String[] getGOSBs(String terBank) {
		return data.get(terBank);
	}
	
	public String[] getEmployees(String gosb) {
		return data1.get(gosb);
	}
}
