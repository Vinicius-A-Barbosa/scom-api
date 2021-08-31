package scom.project.api.insertions;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import scom.project.api.util.DateUtils;

public class InsertConverter {
	
	private List<String> cars = new ArrayList<>();
	
	public InsertConverter() {
		cars.add("RA");
		cars.add("RB");
	}
	
	public void generateConverters(Integer initial, Integer quantity) {
		StringBuilder replace = new StringBuilder();
		replace.append("REPLACE INTO `EQUIPAMENTOS_CONVERSOR` VALUES\n");

		Integer converter = initial * 2 - 1;
		for (Integer count = initial; count < initial + quantity; count ++) {
			Integer initialConverter = count * 2 - 1;
			for (Integer position = initialConverter; position < initialConverter + 2; position ++) {				
				replace.append(generateConverter(converter));
				if (position == initialConverter + 1 && count == initial + quantity - 1) {
					replace.append(";\n");
				} else {					
					replace.append(",\n");
				}
				converter++;
			}
		}
		System.out.println(replace.toString());
	}
	
	public String generateConverter(Integer value) {
		StringBuilder replace = new StringBuilder();
		
		String converterValue = value < 10 ? "0" + value : value.toString();
		replace.append("('CV" + converterValue + "', 'Disponível', 'Série 900')");
		return replace.toString();
	}
	
	public void generateKmConverters(Integer initial, Integer quantity) {
		StringBuilder replace = new StringBuilder();
		replace.append("REPLACE INTO `QUILOMETRAGEM_CONVERSOR` VALUES\n");
		Integer converter = initial * 2 - 1;
		for (Integer count = initial; count < initial + quantity; count ++) {
			Integer initialConverter = count * 2 - 1;
			for (Integer position = initialConverter; position < initialConverter + 2; position ++) {				
				replace.append(generateKmConverter(converter, count));
				if (position == initialConverter + 1 && count == initial + quantity - 1) {
					replace.append(";\n");
				} else {					
					replace.append(",\n");
				}
				converter++;
			}
		}
		System.out.println(replace.toString());
	}
	
	public String generateKmConverter(Integer converter, Integer train) {
		StringBuilder replace = new StringBuilder();
		LocalDate firstDate = LocalDate.of(2001, 8, 1);
		LocalDate secondDate = firstDate.plusDays(2);
		String converterValue = converter < 10 ? "0" + converter : converter.toString();
		replace.append("('CV");
		replace.append(converterValue);
		replace.append("', '");
		replace.append(DateUtils.getDate(firstDate));
		replace.append("', ");
		replace.append(0);
		replace.append("),\n");
		
		replace.append("('CV");
		replace.append(converterValue);
		replace.append("', '");
		replace.append(DateUtils.getDate(secondDate));
		replace.append("', ");
		replace.append(400 + 100*train);
		replace.append(")");
		return replace.toString();
	}
	
	public void generateShiftConverters(Integer initial, Integer quantity) {
		StringBuilder replace = new StringBuilder();
		replace.append("REPLACE INTO `MOVIMENTACOES_CONVERSOR` VALUES\n");
		Integer converter = initial * 2 - 1;
		for (Integer count = initial; count < initial + quantity; count ++) {
			Integer initialConverter = count * 2 - 1;
			Integer car = 0;
			for (Integer position = initialConverter; position < initialConverter + 2; position ++) {				
				replace.append(generateShiftConverter(converter, count, car));
				if (position == initialConverter + 1 && count == initial + quantity - 1) {
					replace.append(";\n");
				} else {					
					replace.append(",\n");
				}
				car++;
				converter++;
			}
		}
		System.out.println(replace.toString());
	}
	
	public String generateShiftConverter(Integer converter, Integer train, Integer car) {
		StringBuilder replace = new StringBuilder();
		LocalDate firstDate = LocalDate.of(2001, 8, 1);
		String trainValue = train < 10 ? "0" + train : train.toString();
		String converterValue = converter < 10 ? "0" + converter : converter.toString();
		replace.append("('TUE");
		replace.append(trainValue);
		replace.append("', '");
		replace.append(cars.get(car));
		replace.append("', 'CV");
		replace.append(converterValue);
		replace.append("', '");
		replace.append(DateUtils.getDate(firstDate));
		replace.append("', null, ");
		replace.append(400 + 100*train);
		replace.append(")");
		return replace.toString();
	}
}
