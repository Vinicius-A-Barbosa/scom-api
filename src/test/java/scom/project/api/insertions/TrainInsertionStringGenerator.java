package scom.project.api.insertions;

import org.junit.Test;

public class TrainInsertionStringGenerator {
	
	@Test
	public void generateEquipmentsInsertion() {
		InsertTrain insertTrain = new InsertTrain();
		Integer initialValue = 31;
		Integer quantity = 5;
		insertTrain.generateTrains(initialValue, quantity);
		insertTrain.generateKmTrains(initialValue, quantity);
		
		InsertConverter insertConverter = new InsertConverter();
		insertConverter.generateConverters(initialValue, quantity);
		insertConverter.generateKmConverters(initialValue, quantity);
		insertConverter.generateShiftConverters(initialValue, quantity);
		
		InsertBogie insertBogie = new InsertBogie();
		insertBogie.generateBogies(initialValue, quantity);
		insertBogie.generateKmBogies(initialValue, quantity);
		insertBogie.generateShiftBogies(initialValue, quantity);
		
		InsertEngine insertEngine = new InsertEngine();
		insertEngine.generateEngines(initialValue, quantity);
		insertEngine.generateKmEngines(initialValue, quantity);
		insertEngine.generateShiftEngines(initialValue, quantity);
		
		InsertAxle insertAxle = new InsertAxle();
		insertAxle.generateAxles(initialValue, quantity);
		insertAxle.generateKmAxles(initialValue, quantity);
		insertAxle.generateShiftAxles(initialValue, quantity);
		
		InsertWheel insertWheel = new InsertWheel();
		insertWheel.generateWheels(initialValue, quantity);
		insertWheel.generateKmWheels(initialValue, quantity);
		insertWheel.generateShiftWheels(initialValue, quantity);
	}
}
