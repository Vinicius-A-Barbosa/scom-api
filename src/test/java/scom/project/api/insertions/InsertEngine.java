package scom.project.api.insertions;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import scom.project.api.util.DateUtils;

public class InsertEngine {
private List<String> positions = new ArrayList<>();
	
	public InsertEngine() {
		positions.add("M1");
		positions.add("M2");
	}

	public void generateEngines(Integer initial, Integer quantity) {
		StringBuilder replace = new StringBuilder();
		replace.append("REPLACE INTO `EQUIPAMENTOS_MOTOR` VALUES\n");
		Integer engine = initial * 8 - 7;
		for (Integer count = initial; count < initial + quantity; count ++) {
			for (Integer truque = 0; truque < 8; truque ++) {
				if (truque < 4) {
					for (Integer position = 0; position < 2; position ++) {
							replace.append(generateEngine(engine));
							if (count == initial + quantity - 1 && truque == 3 && position == 1) {
								replace.append(";\n");
							} else {
								replace.append(",\n");
							}
							engine++;
					}
				}
			}
		}
		System.out.println(replace.toString());
	}
	
	public String generateEngine(Integer value) {
		StringBuilder replace = new StringBuilder();
		
		String engineValue = value < 10 ? "0" + value : value.toString();
		replace.append("('M");
		replace.append(engineValue);
		replace.append("', 'Disponível");
		replace.append("', 'Série 900')");
		return replace.toString();
	}
	
	public void generateKmEngines(Integer initial, Integer quantity) {
		StringBuilder replace = new StringBuilder();
		replace.append("REPLACE INTO `QUILOMETRAGEM_MOTOR` VALUES\n");
		Integer engine = initial * 8 - 7;
		for (Integer count = initial; count < initial + quantity; count ++) {
			for (Integer truque = 0; truque < 8; truque ++) {
				if (truque < 4) {
					for (Integer position = 0; position < 2; position ++) {
						replace.append(generateKmEngine(engine, count));
						if (count == initial + quantity - 1 && truque == 3 && position == 1) {
							replace.append(";\n");
						} else {
							replace.append(",\n");
						}
						engine++;
					}
				}
			}
		}
		System.out.println(replace.toString());
	}
	
	public String generateKmEngine(Integer engine, Integer train) {
		StringBuilder replace = new StringBuilder();
		LocalDate firstDate = LocalDate.of(2001, 8, 1);
		LocalDate secondDate = firstDate.plusDays(2);
		String engineValue = engine < 10 ? "0" + engine : engine.toString();
		replace.append("('M");
		replace.append(engineValue);
		replace.append("', '");
		replace.append(DateUtils.getDate(firstDate));
		replace.append("', ");
		replace.append(0);
		replace.append("),\n");
		
		replace.append("('M");
		replace.append(engineValue);
		replace.append("', '");
		replace.append(DateUtils.getDate(secondDate));
		replace.append("', ");
		replace.append(400 + 100*train);
		replace.append(")");
		return replace.toString();
	}
	
	public void generateShiftEngines(Integer initial, Integer quantity) {
		StringBuilder replace = new StringBuilder();
		replace.append("REPLACE INTO `MOVIMENTACOES_MOTOR` VALUES\n");
		Integer engine = initial * 8 - 7;
		Integer bogie = initial * 8 - 7;
		for (Integer count = initial; count < initial + quantity; count ++) {
			for (Integer truque = 0; truque < 8; truque ++) {
				if (truque < 4) {
					for (Integer position = 0; position < 2; position ++) {
						replace.append(generateShiftEngine(engine, count, bogie, position));
						if (count == initial + quantity - 1 && truque == 3 && position == 1) {
							replace.append(";\n");
						} else {
							replace.append(",\n");
						}
						engine++;
					}
				}
				bogie++;
			}
		}
		System.out.println(replace.toString());
	}
	
	public String generateShiftEngine(Integer engine, Integer train, Integer bogie, Integer position) {
		StringBuilder replace = new StringBuilder();
		LocalDate firstDate = LocalDate.of(2001, 8, 1);
		String bogieValue = bogie < 10 ? "0" + bogie : bogie.toString();
		String engineValue = engine < 10 ? "0" + engine : engine.toString();
		replace.append("('TQ");
		replace.append(bogieValue);
		replace.append("', '");
		replace.append(positions.get(position));
		replace.append("', 'M");
		replace.append(engineValue);
		replace.append("', '");
		replace.append(DateUtils.getDate(firstDate));
		replace.append("', null, ");
		replace.append(400 + 100*train);
		replace.append(")");
		return replace.toString();
	}
}
