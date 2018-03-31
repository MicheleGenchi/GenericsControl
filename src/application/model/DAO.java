package application.model;

import java.util.List;

import javafx.collections.ObservableList;

public interface DAO<T> {
	void scrivi();
	boolean leggi();
	Class<T> getEntity();
	ObservableList<T> getData();
	void setData(List<T> data);
}
