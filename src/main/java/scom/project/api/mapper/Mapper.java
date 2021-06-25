package scom.project.api.mapper;

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
}
