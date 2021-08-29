package scom.project.api.insertions;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import scom.project.api.util.DateUtils;

public class InsertAxle {
	private List<String> positions = new ArrayList<>();
	
	public InsertAxle() {
		positions.add("E1");
		positions.add("E2");
	}

	public void generateAxles(Integer initial, Integer quantity) {
		StringBuilder replace = new StringBuilder();
		replace.append("REPLACE INTO `EQUIPAMENTOS_EIXO` VALUES\n");
		Integer axle = initial * 16 - 15;
		for (Integer count = initial; count < initial + quantity; count ++) {
			for (Integer truque = 0; truque < 8; truque ++) {
				for (Integer position = 0; position < 2; position ++) {
					if (truque < 4) {
						replace.append(generateAxle(axle, "Motriz"));
					} else {
						replace.append(generateAxle(axle, "Reboque"));
					}
					if (count == initial + quantity - 1 && truque == 7 && position == 1) {
						replace.append(";\n");
					} else {
						replace.append(",\n");
					}
					axle++;
				}
			}
		}
		System.out.println(replace.toString());
	}
	
	public String generateAxle(Integer value, String type) {
		StringBuilder replace = new StringBuilder();
		
		String axleValue = value < 10 ? "0" + value : value.toString();
		replace.append("('E");
		replace.append(axleValue);
		replace.append("', 'Disponível', '");
		replace.append(type);
		replace.append("', 'Série 900')");
		return replace.toString();
	}
	
	public void generateKmAxles(Integer initial, Integer quantity) {
		StringBuilder replace = new StringBuilder();
		replace.append("REPLACE INTO `QUILOMETRAGEM_EIXO` VALUES\n");
		Integer axle = initial * 16 - 15;
		for (Integer count = initial; count < initial + quantity; count ++) {
			for (Integer truque = 0; truque < 8; truque ++) {
				for (Integer position = 0; position < 2; position ++) {
					replace.append(generateKmAxle(axle, count));
					if (count == initial + quantity - 1 && truque == 7 && position == 1) {
						replace.append(";\n");
					} else {
						replace.append(",\n");
					}
					axle++;
				}
			}
		}
		System.out.println(replace.toString());
	}
	
	public String generateKmAxle(Integer axle, Integer train) {
		StringBuilder replace = new StringBuilder();
		LocalDate firstDate = LocalDate.of(2001, 8, 1);
		LocalDate secondDate = firstDate.plusDays(2);
		String axleValue = axle < 10 ? "0" + axle : axle.toString();
		replace.append("('E");
		replace.append(axleValue);
		replace.append("', '");
		replace.append(DateUtils.getDate(firstDate));
		replace.append("', ");
		replace.append(0);
		replace.append("),\n");
		
		replace.append("('E");
		replace.append(axleValue);
		replace.append("', '");
		replace.append(DateUtils.getDate(secondDate));
		replace.append("', ");
		replace.append(400 + 100*train);
		replace.append(")");
		return replace.toString();
	}
	
	public void generateShiftAxles(Integer initial, Integer quantity) {
		StringBuilder replace = new StringBuilder();
		replace.append("REPLACE INTO `MOVIMENTACOES_EIXO` VALUES\n");
		Integer axle = initial * 16 - 15;
		Integer bogie = initial * 8 - 7;
		for (Integer count = initial; count < initial + quantity; count ++) {
			for (Integer bogiePosition = 0; bogiePosition < 8; bogiePosition ++) {
				for (Integer position = 0; position < 2; position ++) {
					replace.append(generateShiftAxle(axle, count, bogie, position));
					if (count == initial + quantity - 1 && bogiePosition == 7 && position == 1) {
						replace.append(";\n");
					} else {
						replace.append(",\n");
					}
					axle++;
				}
				bogie++;
			}
		}
		System.out.println(replace.toString());
	}
	
	public String generateShiftAxle(Integer axle, Integer train, Integer bogie, Integer position) {
		StringBuilder replace = new StringBuilder();
		LocalDate firstDate = LocalDate.of(2001, 8, 1);
		String bogieValue = bogie < 10 ? "0" + bogie : bogie.toString();
		String axleValue = axle < 10 ? "0" + axle : axle.toString();
		replace.append("('TQ");
		replace.append(bogieValue);
		replace.append("', '");
		replace.append(positions.get(position));
		replace.append("', 'E");
		replace.append(axleValue);
		replace.append("', '");
		replace.append(DateUtils.getDate(firstDate));
		replace.append("', null, ");
		replace.append(400 + 100*train);
		replace.append(")");
		return replace.toString();
	}
}
