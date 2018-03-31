package application.control;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Set;
import java.util.TreeSet;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Filter<E> {
private String fieldFilter;
private ObservableList<E> data;

	public Filter(ObservableList<E> data) {
		this.data=data;
	}

	public Filter<E> setFieldFilter(String fieldFilter) {
		this.fieldFilter=fieldFilter;
		return this; 
	}

	public ObservableList<String> get() {
		Set<String> filter=new TreeSet<>();
		data.forEach(e -> {
			try {
				Method m=(Method) e.getClass().getMethod(fieldFilter);
				filter.add(m.invoke(e).toString());
			} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException
					| NoSuchMethodException | SecurityException e1) {
				e1.printStackTrace();
			}
		});
		return FXCollections.observableArrayList(filter);
	}

	public String getFieldFilter() {
		return fieldFilter;
	}
	
}
