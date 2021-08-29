package scom.project.api.insertions;

import java.time.LocalDate;

import scom.project.api.util.DateUtils;

public class InsertTrain {
	
	public void generateTrains(Integer initial, Integer quantity) {
		StringBuilder replace = new StringBuilder();
		replace.append("REPLACE INTO `EQUIPAMENTOS_TREM` VALUES\n");
		
		for (Integer count = initial; count < initial + quantity; count ++) {
			replace.append(generateTrain(count));
			if (count < quantity) {
				replace.append(",\n");
			} else {					
				replace.append(";\n");
			}
		}
		System.out.println(replace.toString());
	}
	
	public String generateTrain(Integer value) {
		StringBuilder replace = new StringBuilder();
		
		String trainValue = value < 10 ? "0" + value : value.toString();
		replace.append("('TUE" + trainValue + "', 'Disponível', 'Série 900')");
		return replace.toString();
	}
	
	public void generateKmTrains(Integer initial, Integer quantity) {
		StringBuilder replace = new StringBuilder();
		replace.append("REPLACE INTO `QUILOMETRAGEM_TREM` VALUES\n");
		
		for (Integer count = initial; count < initial + quantity; count ++) {
			replace.append(generateKmTrain(count));
			if (count < quantity) {
				replace.append(",\n");
			} else {					
				replace.append(";\n");
			}
		}
		System.out.println(replace.toString());
	}
	
	public String generateKmTrain(Integer value) {
		StringBuilder replace = new StringBuilder();
		LocalDate firstDate = LocalDate.of(2001, 8, 1);
		LocalDate secondDate = firstDate.plusDays(2);
		String trainValue = value < 10 ? "0" + value : value.toString();
		replace.append("('TUE");
		replace.append(trainValue);
		replace.append("', '");
		replace.append(DateUtils.getDate(firstDate));
		replace.append("', ");
		replace.append(0);
		replace.append("),\n");
		
		replace.append("('TUE");
		replace.append(trainValue);
		replace.append("', '");
		replace.append(DateUtils.getDate(secondDate));
		replace.append("', ");
		replace.append(400 + 100*value);
		replace.append(")");
		return replace.toString();
	}
}
