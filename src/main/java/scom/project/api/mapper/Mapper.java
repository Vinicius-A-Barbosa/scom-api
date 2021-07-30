package scom.project.api.mapper;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;

public class Mapper {
	
	public static <T, S> List<T> convertListSourceToListDestination(List<S> source, Class<T> targetClass) {
		ModelMapper mapper = new ModelMapper();
	    return source
	      .stream()
	      .map(element -> mapper.map(element, targetClass))
	      .collect(Collectors.toList());
	}
	
	public static <T, S> T convertSourceToDestination(S source, Class<T> targetClass) {
	    try {
	    	T destiny = targetClass.getConstructor().newInstance();
			for (Field fieldSource : source.getClass().getDeclaredFields()) {
				fieldSource.setAccessible(true);
				
				Object fieldValue = fieldSource.get(source);

				boolean doesFieldsHaveTheName = checkIfFieldNameExists(destiny.getClass().getDeclaredFields(), fieldSource.getName());
				if (doesFieldsHaveTheName) {
					Field fieldDestiny = destiny.getClass().getDeclaredField(fieldSource.getName());
					fieldDestiny.setAccessible(true);
					fieldDestiny.set(destiny, fieldValue);
				}
			}
			return destiny;
	    } catch(Exception e) {
	    	System.out.print("Conversão falhou");
	    	return null;
	    }
	}
	
	public static <T, S> List<T> convertListEntityWithPKToListDTO(List<S> sourceList, Class<T> targetClass, String pkField) {
		List<T> destinyList = new ArrayList<>();
		
		try {
			for (S source : sourceList) {
				T destiny = convertEntityWithPKToDTO(source, targetClass, pkField);
				if (destiny != null) {					
					destinyList.add(destiny);
				}
			}
		} catch(Exception e) {
			System.out.print("Conversão falhou");
		}
		
		return destinyList;
	}
	
	public static <T, S> List<T> convertListDTOToListEntityWithPK(List<S> sourceList, Class<T> targetClass, String pkField) {
		List<T> destinyList = new ArrayList<>();
		
		try {
			for (S source : sourceList) {
				T destiny = convertDTOToEntityWithPK(source, targetClass, pkField);
				if (destiny != null) {					
					destinyList.add(destiny);
				}
			}
		} catch(Exception e) {
			System.out.print("Conversão falhou");
		}
		
		return destinyList;
	}
	
	public static <T, S> T convertEntityWithPKToDTO(S source, Class<T> targetClass, String pkField) {
	    try {
	    	T destiny = targetClass.getConstructor().newInstance();
	    	for (Field fieldSource : source.getClass().getDeclaredFields()) {
				fieldSource.setAccessible(true);
				
				Object fieldValue = fieldSource.get(source);

				if (fieldSource.getName() == pkField) {
					for (Field innerField : fieldValue.getClass().getDeclaredFields()) {
						innerField.setAccessible(true);
						boolean doesFieldsHaveTheName = checkIfFieldNameExists(destiny.getClass().getDeclaredFields(), innerField.getName());
						if (doesFieldsHaveTheName) {
							Object innerFieldValue = innerField.get(fieldValue);
							
							Field fieldDestiny = destiny.getClass().getDeclaredField(innerField.getName());
							fieldDestiny.setAccessible(true);
							fieldDestiny.set(destiny, innerFieldValue);
						}
					}
				} else {
					boolean doesFieldsHaveTheName = checkIfFieldNameExists(destiny.getClass().getDeclaredFields(), fieldSource.getName());
					if (doesFieldsHaveTheName) {
						Field fieldDestiny = destiny.getClass().getDeclaredField(fieldSource.getName());
						fieldDestiny.setAccessible(true);
						fieldDestiny.set(destiny, fieldValue);
					}
				}
			}
			return destiny;
	    } catch(Exception e) {
	    	System.out.print("Conversão falhou");
	    	return null;
	    }
	}
	
	public static <T, S> T convertDTOToEntityWithPK(S source, Class<T> targetClass, String pkField) {
	    try {
	    	T destiny = targetClass.getConstructor().newInstance();
			for (Field fieldDestiny : destiny.getClass().getDeclaredFields()) {
				fieldDestiny.setAccessible(true);
				
				if (fieldDestiny.getName() == pkField) {
					Object destinyValue = fieldDestiny.get(destiny);
					for (Field innerFieldDestiny : destinyValue.getClass().getDeclaredFields()) {
						boolean doesFieldsHaveTheName = checkIfFieldNameExists(source.getClass().getDeclaredFields(), innerFieldDestiny.getName());
						if (doesFieldsHaveTheName) {
							innerFieldDestiny.setAccessible(true);
							Field sourceField = source.getClass().getDeclaredField(innerFieldDestiny.getName());
							sourceField.setAccessible(true);
							Object sourceValue = sourceField.get(source);
							innerFieldDestiny.set(destinyValue, sourceValue);
						}
					}
					fieldDestiny.set(destiny, destinyValue);
				} else {
					boolean doesFieldsHaveTheName = checkIfFieldNameExists(source.getClass().getDeclaredFields(), fieldDestiny.getName());
					if (doesFieldsHaveTheName) {
						Field sourceField = source.getClass().getDeclaredField(fieldDestiny.getName());
						sourceField.setAccessible(true);
						Object sourceValue = sourceField.get(source);
						fieldDestiny.set(destiny, sourceValue);
					}
				}
			}
			return destiny;
	    } catch(Exception e) {
	    	System.out.print("Conversão falhou");
	    	return null;
	    }
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
