package com.tirmizee.core.datatable;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.NullHandling;
import org.springframework.data.domain.Sort.Order;

import com.tirmizee.core.annotaion.SortColumn;

/**
 * build annotaion {@link SortColumn}
 * 
 * @author pratya yeekhaday
 *
 */
public class PageRequestHelper {
	
	public static  PageRequest build(RequestTable<?> requestData,Class<?> clazz){
		int page = (int) (requestData.getStart()/requestData.getLength()),
			size = (int) requestData.getLength();
		return new PageRequest(page, size, buildSort(requestData,clazz));
	}
	
	private static Sort buildSort(RequestTable<?> requestData,Class<?> clazz) {
		List<Sort.Order> listOrderBy = new ArrayList<Sort.Order>();
		Field[] fields = clazz.getDeclaredFields();
		for (OrderData orderData : requestData.getOrders()) {
			Sort.Direction direction = Sort.Direction.fromStringOrNull(orderData.getDir());
			String requestColumn = requestData.getColumns().get(orderData.getColumn().intValue()).getData();
			addOrderBy(direction,requestColumn,listOrderBy,fields);
		}
		return  listOrderBy.isEmpty() ? null : new Sort(listOrderBy);
	}

	private static void addOrderBy(Direction direction, String requestColumn, List<Order> results, Field[] fields) {
		for (Field field : fields) {
			if (field.isAnnotationPresent(SortColumn.class) && field.getName().equals(requestColumn)) {
				SortColumn sortColumns = field.getAnnotation(SortColumn.class);
				for (String column : sortColumns.value()) {
					results.add(new Order(direction, column, NullHandling.NATIVE));
				}
				break;
			}
		}
	}
	
}
