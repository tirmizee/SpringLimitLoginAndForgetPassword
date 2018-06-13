package com.tirmizee.core.component;

import java.util.List;
import java.util.Set;

import org.dozer.Mapper;
import org.springframework.data.domain.Page;

public interface IMapper extends Mapper{

	<T> List<T> map(List<?> source, Class<T> destinationClass);
	
	<T> Set<T> map(Set<?> source, Class<T> destinationClass);
	
	<T> Page<T> map(Page<?> source, Class<T> destinationClass);

}
