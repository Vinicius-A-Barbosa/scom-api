package scom.project.api.mapper;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;

public class Mapper {
	
	public static <T, S> List<T> convertListEntityToListDTO(List<S> source, Class<T> targetClass) {
		ModelMapper mapper = new ModelMapper();
	    return source
	      .stream()
	      .map(element -> mapper.map(element, targetClass))
	      .collect(Collectors.toList());
	}
	
	public static <T, S> List<T> convertListEntityWithPKToListDTO(List<S> sourceList, Class<T> targetClass, String pkField) {
		List<T> destityList = new ArrayList<>();
		
		try {
			for (S source : sourceList) {
				T destity = targetClass.getConstructor().newInstance();
				for (Field fieldSource : source.getClass().getDeclaredFields()) {
					fieldSource.setAccessible(true);
					
					Object fieldValue = fieldSource.get(source);

					if (fieldSource.getName() == pkField) {
						for (Field innerField : fieldValue.getClass().getDeclaredFields()) {
							innerField.setAccessible(true);
							boolean doesFieldsHaveTheName = checkIfFieldNameExists(destity.getClass().getDeclaredFields(), innerField.getName());
							if (doesFieldsHaveTheName) {
								Object innerFieldValue = innerField.get(fieldValue);
								
								Field fieldDestiny = destity.getClass().getDeclaredField(innerField.getName());
								fieldDestiny.setAccessible(true);
								fieldDestiny.set(destity, innerFieldValue);
							}
						}
					} else {
						boolean doesFieldsHaveTheName = checkIfFieldNameExists(destity.getClass().getDeclaredFields(), fieldSource.getName());
						if (doesFieldsHaveTheName) {
							Field fieldDestiny = destity.getClass().getDeclaredField(fieldSource.getName());
							fieldDestiny.setAccessible(true);
							fieldDestiny.set(destity, fieldValue);
						}
					}
				}
				destityList.add(destity);
			}
		} catch(Exception e) {
			System.out.print("Conversão falhou");
		}
		
		return destityList;
	}
	
	private static boolean checkIfFieldNameExists(Field[] fields, String name) {
		boolean doesFieldsHaveTheName = false;
		for (Field field : fields) {
			if (field.getName() == name) {
				doesFieldsHaveTheName = true;
			}
		}
		return doesFieldsHaveTheName;
	}
}
