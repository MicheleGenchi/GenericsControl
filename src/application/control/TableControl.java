package application.control;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class TableControl<E> extends TableView<E> implements Filterable<E> {
	private static MainController main;
	private ObservableList<E> data;
	private FilteredList<E> filteredData;
	private TableViewSelectionModel<E> tsm;
	private Class<E> recordType;

	public TableControl(Class<E> recordType, ObservableList<E> data) {
		this.data = data;
		this.recordType = recordType;
		tsm = this.getSelectionModel();
		tsm.setSelectionMode(SelectionMode.MULTIPLE);
	}

	void loadFromDataBase() {
		List<TableColumn<E, String>> columns = new ArrayList<>();
		Arrays.stream(recordType.getDeclaredFields()).forEach(e -> {
			TableColumn<E, String> currentColumn = new TableColumn<>(e.getName());
			PropertyValueFactory<E, String> p = new PropertyValueFactory<>(e.getName());
			currentColumn.setCellValueFactory(p);

			// Verifica se la colonna corrente é da editare; la setta editabile
			String editabile = "tipo".toLowerCase();
			System.out.print(currentColumn.getText());
			if (currentColumn.getText().toLowerCase() == editabile) {
				System.out.print(" ->  editable column");
				currentColumn.setEditable(true);
			}
			System.out.println();
			columns.add(currentColumn);
		});
		this.setItems(data);
		this.getColumns().setAll(columns);
	}

	@Override
	public void applyFilter(Filter<E> filtro) {
		filteredData = new FilteredList<>(data);
		main.cmbFilter.valueProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				filteredData.setPredicate(e -> {
					// If filter text is empty, display all persons.
					if (newValue == null || newValue.isEmpty()) {
						return true;
					}

					// Compare tipo di ogni riga con questo filtro
					String lowerCaseFilter = newValue.toLowerCase();
					String currentFieldValue;
					try {
						currentFieldValue = (String) recordType.getMethod(filtro.getFieldFilter()).invoke(e);
						if (currentFieldValue.toLowerCase().contains(lowerCaseFilter)) {
							return true; // stesso valore
						}
					} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException
							| NoSuchMethodException | SecurityException e1) {
						e1.printStackTrace();
					}
					return false; // tipo diverso
				});
			}
		});
		this.setItems(filteredData);
	}

	public static void injectionMainController(MainController main) {
		TableControl.main = main;
	}

	void deleteSelectedRows() {
		// Get all the selected items
		ObservableList<Integer> selectedItems = tsm.getSelectedIndices();
		if (selectedItems != null) {
			// Iterate through each item
			for (Integer selectedItem : selectedItems) {
				int sourceIndex = filteredData.getSourceIndexFor(data, selectedItem.intValue());
				// remove
				data.remove(sourceIndex);
			}
		} else {
			System.out.println("No Selected rows");
		}
	}

	void restoreRows() {
	}

	@Override
	public void undoFilter() {
		main.cmbFilter.getSelectionModel().select(-1);
	}

	boolean commit() {
		return true;
	}

}