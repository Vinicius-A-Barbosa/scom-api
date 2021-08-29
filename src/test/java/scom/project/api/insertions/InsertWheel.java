package scom.project.api.insertions;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import scom.project.api.util.DateUtils;

public class InsertWheel {
private List<String> positions = new ArrayList<>();
	
	public InsertWheel() {
		positions.add("RD");
		positions.add("RE");
	}

	public void generateWheels(Integer initial, Integer quantity) {
		StringBuilder replace = new StringBuilder();
		replace.append("REPLACE INTO `EQUIPAMENTOS_RODA` VALUES\n");
		Integer wheel = initial * 32 - 31;
		for (Integer count = initial; count < initial + quantity; count ++) {
			for (Integer bogie = 0; bogie < 8; bogie ++) {
				for (Integer axle = 0; axle < 2; axle ++) {
					for (Integer position = 0; position < 2; position ++) {
						replace.append(generateWheel(wheel));
						if (count == initial + quantity - 1 && bogie == 7 && axle == 1 && position == 1) {
							replace.append(";\n");
						} else {
							replace.append(",\n");
						}
						wheel++;
					}
				}
			}
		}
		System.out.println(replace.toString());
	}
	
	public String generateWheel(Integer value) {
		StringBuilder replace = new StringBuilder();
		
		String wheelValue = value < 10 ? "0" + value : value.toString();
		replace.append("('R");
		replace.append(wheelValue);
		replace.append("', 'Disponível");
		replace.append("', 'Série 900')");
		return replace.toString();
	}
	
	public void generateKmWheels(Integer initial, Integer quantity) {
		StringBuilder replace = new StringBuilder();
		replace.append("REPLACE INTO `QUILOMETRAGEM_RODA` VALUES\n");
		Integer wheel = initial * 32 - 31;
		for (Integer count = initial; count < initial + quantity; count ++) {
			for (Integer bogie = 0; bogie < 8; bogie ++) {
				for (Integer axle = 0; axle < 2; axle ++) {
					for (Integer position = 0; position < 2; position ++) {
						replace.append(generateKmWheel(wheel, count));
						if (count == initial + quantity - 1 && bogie == 7 && axle == 1 && position == 1) {
							replace.append(";\n");
						} else {
							replace.append(",\n");
						}
						wheel++;
					}
				}
			}
		}
		System.out.println(replace.toString());
	}
	
	public String generateKmWheel(Integer wheel, Integer train) {
		StringBuilder replace = new StringBuilder();
		LocalDate firstDate = LocalDate.of(2001, 8, 1);
		LocalDate secondDate = firstDate.plusDays(2);
		String wheelValue = wheel < 10 ? "0" + wheel : wheel.toString();
		replace.append("('R");
		replace.append(wheelValue);
		replace.append("', '");
		replace.append(DateUtils.getDate(firstDate));
		replace.append("', ");
		replace.append(0);
		replace.append("),\n");
		
		replace.append("('R");
		replace.append(wheelValue);
		replace.append("', '");
		replace.append(DateUtils.getDate(secondDate));
		replace.append("', ");
		replace.append(400 + 100*train);
		replace.append(")");
		return replace.toString();
	}
	
	public void generateShiftWheels(Integer initial, Integer quantity) {
		StringBuilder replace = new StringBuilder();
		replace.append("REPLACE INTO `MOVIMENTACOES_RODA` VALUES\n");
		Integer axle = initial * 16 - 15;
		Integer wheel = initial * 32 - 31;
		for (Integer count = initial; count < initial + quantity; count ++) {
			for (Integer bogie = 0; bogie < 8; bogie ++) {
				for (Integer axlePosition = 0; axlePosition < 2; axlePosition ++) {
					for (Integer position = 0; position < 2; position ++) {
						replace.append(generateShiftWheel(wheel, count, axle, position));
						if (count == initial + quantity - 1 && bogie == 7 && axlePosition == 1 && position == 1) {
							replace.append(";\n");
						} else {
							replace.append(",\n");
						}
						wheel++;
					}
					axle++;
				}
			}
		}
		System.out.println(replace.toString());
	}
	
	public String generateShiftWheel(Integer wheel, Integer train, Integer axle, Integer position) {
		StringBuilder replace = new StringBuilder();
		LocalDate firstDate = LocalDate.of(2001, 8, 1);
		String axleValue = axle < 10 ? "0" + axle : axle.toString();
		String wheelValue = wheel < 10 ? "0" + wheel : wheel.toString();
		replace.append("('E");
		replace.append(axleValue);
		replace.append("', '");
		replace.append(positions.get(position));
		replace.append("', 'R");
		replace.append(wheelValue);
		replace.append("', '");
		replace.append(DateUtils.getDate(firstDate));
		replace.append("', null, ");
		replace.append(400 + 100*train);
		replace.append(")");
		return replace.toString();
	}
}
