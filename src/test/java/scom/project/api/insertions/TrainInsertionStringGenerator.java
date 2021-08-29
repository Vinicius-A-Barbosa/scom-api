package scom.project.api.insertions;

import org.junit.Test;

public class TrainInsertionStringGenerator {
	
	@Test
	public void generateEquipmentsInsertion() {
		InsertTrain insertTrain = new InsertTrain();
		insertTrain.generateTrains(1, 3);
		insertTrain.generateKmTrains(1, 3);
		
		InsertConverter insertConverter = new InsertConverter();
		insertConverter.generateConverters(1, 3);
		insertConverter.generateKmConverters(1, 3);
		insertConverter.generateShiftConverters(1, 3);
		
		InsertBogie insertBogie = new InsertBogie();
		insertBogie.generateBogies(1, 3);
		insertBogie.generateKmBogies(1, 3);
		insertBogie.generateShiftBogies(1, 3);
		
		InsertEngine insertEngine = new InsertEngine();
		insertEngine.generateEngines(1, 3);
		insertEngine.generateKmEngines(1, 3);
		insertEngine.generateShiftEngines(1, 3);
		
		InsertAxle insertAxle = new InsertAxle();
		insertAxle.generateAxles(1, 3);
		insertAxle.generateKmAxles(1, 3);
		insertAxle.generateShiftAxles(1, 3);
		
		InsertWheel insertWheel = new InsertWheel();
		insertWheel.generateWheels(1, 3);
		insertWheel.generateKmWheels(1, 3);
		insertWheel.generateShiftWheels(1, 3);
	}
}
