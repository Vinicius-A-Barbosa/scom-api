package scom.project.api.insertions;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import scom.project.api.util.DateUtils;

public class InsertBogie {
	
	private List<String> cars = new ArrayList<>();
	private List<String> positions = new ArrayList<>();
	
	public InsertBogie() {
		cars.add("MA");
		cars.add("MB");
		cars.add("RA");
		cars.add("RB");
		positions.add("TQ1");
		positions.add("TQ2");
	}

	public void generateBogies(Integer initial, Integer quantity) {
		StringBuilder replace = new StringBuilder();
		replace.append("REPLACE INTO `EQUIPAMENTOS_TRUQUE` VALUES\n");
		Integer bogie = initial * 8 - 7;
		for (Integer count = initial; count < initial + quantity; count ++) {
			for (Integer position = 0; position < 8; position ++) {
				if (position < 4) {
					replace.append(generateBogie(bogie, "Motriz"));
				} else {
					replace.append(generateBogie(bogie, "Reboque"));
				}
				if (count == initial + quantity - 1 && position == 7) {
					replace.append(";\n");
				} else {
					replace.append(",\n");
				}
				bogie++;
			}
		}
		System.out.println(replace.toString());
	}
	
	public String generateBogie(Integer value, String type) {
		StringBuilder replace = new StringBuilder();
		
		String bogieValue = value < 10 ? "0" + value : value.toString();
		replace.append("('TQ");
		replace.append(bogieValue);
		replace.append("', 'Disponível', '");
		replace.append(type);
		replace.append("', 'Série 900')");
		return replace.toString();
	}
	
	public void generateKmBogies(Integer initial, Integer quantity) {
		StringBuilder replace = new StringBuilder();
		replace.append("REPLACE INTO `QUILOMETRAGEM_TRUQUE` VALUES\n");
		
		for (Integer count = initial; count < initial + quantity; count ++) {
			Integer initialBogie = count * 8 - 7;
			for (Integer bogie = initialBogie; bogie < initialBogie + 8; bogie ++) {				
				replace.append(generateKmBogie(bogie, count));
				if (count == initial + quantity - 1 && bogie == initialBogie + 7) {
					replace.append(";\n");
				} else {
					replace.append(",\n");
				}
			}
		}
		System.out.println(replace.toString());
	}
	
	public String generateKmBogie(Integer bogie, Integer train) {
		StringBuilder replace = new StringBuilder();
		LocalDate firstDate = LocalDate.of(2001, 8, 1);
		LocalDate secondDate = firstDate.plusDays(2);
		String bogieValue = bogie < 10 ? "0" + bogie : bogie.toString();
		replace.append("('TQ");
		replace.append(bogieValue);
		replace.append("', '");
		replace.append(DateUtils.getDate(firstDate));
		replace.append("', ");
		replace.append(0);
		replace.append("),\n");
		
		replace.append("('TQ");
		replace.append(bogieValue);
		replace.append("', '");
		replace.append(DateUtils.getDate(secondDate));
		replace.append("', ");
		replace.append(400 + 100*train);
		replace.append(")");
		return replace.toString();
	}
	
	public void generateShiftBogies(Integer initial, Integer quantity) {
		StringBuilder replace = new StringBuilder();
		replace.append("REPLACE INTO `MOVIMENTACOES_TRUQUE` VALUES\n");
		for (Integer count = initial; count < initial + quantity; count ++) {
			Integer bogie = count * 8 - 7; 
			for (Integer car = 0; car < 4; car ++) {
				Integer position = 0;
				for (Integer bogiePosition = 0; bogiePosition < 2; bogiePosition ++) {
					replace.append(generateShiftBogie(bogie, count, car, position));
					if (car == 3 && count == initial + quantity - 1 && bogiePosition == 1) {
						replace.append(";\n");
					} else {
						replace.append(",\n");
					}
					position++;
					bogie++;
				}
			}
		}
		System.out.println(replace.toString());
	}
	
	public String generateShiftBogie(Integer bogie, Integer train, Integer car, Integer position) {
		StringBuilder replace = new StringBuilder();
		LocalDate firstDate = LocalDate.of(2001, 8, 1);
		String trainValue = train < 10 ? "0" + train : train.toString();
		String bogieValue = bogie < 10 ? "0" + bogie : bogie.toString();
		replace.append("('TUE");
		replace.append(trainValue);
		replace.append("', '");
		replace.append(cars.get(car));
		replace.append("', '");
		replace.append(positions.get(position));
		replace.append("', 'TQ");
		replace.append(bogieValue);
		replace.append("', '");
		replace.append(DateUtils.getDate(firstDate));
		replace.append("', null, ");
		replace.append(400 + 100*train);
		replace.append(")");
		return replace.toString();
	}
}
