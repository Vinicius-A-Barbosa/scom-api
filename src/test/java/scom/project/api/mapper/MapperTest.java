package scom.project.api.mapper;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import scom.project.api.dto.AxleKilometersDTO;
import scom.project.api.repository.entity.AxleKilometersEntity;

public class MapperTest {

	@Test
	public void testConvertingWithPK() {
		
		List<AxleKilometersEntity> expectedEntity = new ArrayList<>();
		AxleKilometersEntity axleKilometersEntity1 = new AxleKilometersEntity();
		axleKilometersEntity1.setAxleKilometersPK("A", LocalDate.of(2020, 7, 3));
		axleKilometersEntity1.setAxleKm(3);
		AxleKilometersEntity axleKilometersEntity2 = new AxleKilometersEntity();
		axleKilometersEntity2.setAxleKilometersPK("B", LocalDate.of(2020, 8, 5));
		axleKilometersEntity2.setAxleKm(5);
		
		expectedEntity.add(axleKilometersEntity1);
		expectedEntity.add(axleKilometersEntity2);
		
		List<AxleKilometersDTO> expectedDTO = new ArrayList<>();
		AxleKilometersDTO axleKilometersDTO1 = new AxleKilometersDTO();
		axleKilometersDTO1.setAxleCode("A");
		axleKilometersDTO1.setAxleDateKm(LocalDate.of(2020, 7, 3));
		axleKilometersDTO1.setAxleKm(3);
		AxleKilometersDTO axleKilometersDTO2 = new AxleKilometersDTO();
		axleKilometersDTO2.setAxleCode("B");
		axleKilometersDTO2.setAxleDateKm(LocalDate.of(2020, 8, 5));
		axleKilometersDTO2.setAxleKm(5);
		
		expectedDTO.add(axleKilometersDTO1);
		expectedDTO.add(axleKilometersDTO2);
		
		List<AxleKilometersDTO> resultDTO = new ArrayList<>();
		resultDTO = Mapper.convertListEntityWithPKToListDTO(expectedEntity, AxleKilometersDTO.class, "axleKilometersPK");
		Assert.assertEquals(expectedDTO, resultDTO);
		
		List<AxleKilometersEntity> resultEntity = new ArrayList<>();
		resultEntity = Mapper.convertListDTOToListEntityWithPK(expectedDTO, AxleKilometersEntity.class, "axleKilometersPK");
		Assert.assertEquals(expectedEntity, resultEntity);
	}
}
