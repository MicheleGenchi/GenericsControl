package application.control;

import application.model.Contatto;
import application.model.DAO;
import application.model.DAOContattoFactory;
import application.model.DAOFactory;
import application.model.DAOPasswordFactory;
import application.model.Password;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.stage.Window;

@SuppressWarnings("unused")
public class MainController extends Application {
	@FXML
	BorderPane root;
	@FXML
	TableControl<?> tableControl;
	@FXML
	ComboBox<String> cmbFilter;
	private Window primaryStage;

	private <E> TableControl<E> creaTabella(DAO<E> source) {
		ObservableList<E> data = null;
		if (source.leggi()) {
			data = source.getData();
			return new TableControl<E>(source.getEntity(), data);
		}
		return null;
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		this.primaryStage = primaryStage;
		TableControl.injectionMainController(this);

/* Gestione tabella Password */
		DAOFactory<Password> source=new DAOPasswordFactory();
		source.setSql("SELECT * FROM password");
		TableControl<Password> tableControl = (TableControl<Password>) creaTabella(source.get("mysql"));
		tableControl.loadFromDataBase();
		// setta Filtro Password
		Filter<Password> filtro = new Filter<>(tableControl.getItems());
		filtro.setFieldFilter("getTipo");
		ObservableList<String> dataFilter = filtro.get();
		cmbFilter = new ComboBox<String>(dataFilter);
		tableControl.applyFilter(filtro);

/* Gestione Tabella Contatto 
		DAOFactory<Contatto> source=new DAOContattoFactory();
		source.setSql("SELECT * FROM rubrica.contatto");
		TableControl<Contatto> tableControl= (TableControl<Contatto>) creaTabella(source.get("mysql"));
		tableControl.loadFromDataBase();
		// Setta controllo filtro Contatto
		Filter<Contatto> filtro = new Filter<>(tableControl.getItems());
		filtro.setFieldFilter("getNome");
		ObservableList<String> dataFilter = filtro.get();
		cmbFilter = new ComboBox<String>(dataFilter);
		tableControl.applyFilter(filtro);
*/
		root = new BorderPane(tableControl);

		// Bottom
		Button restoreBtn = new Button("Restore");
		restoreBtn.setOnAction(e -> tableControl.restoreRows());
		Button deleteBtn = new Button("Delete");
		deleteBtn.setOnAction(e -> tableControl.deleteSelectedRows());
		Button commitBtn = new Button("Commit");
		commitBtn.setOnAction(e -> tableControl.commit());
		HBox comandiBottom = new HBox(restoreBtn, deleteBtn, commitBtn);
		root.setBottom(comandiBottom);

		// Top
		Button undoBtn = new Button("UndoFilter");
		undoBtn.setOnAction(e -> tableControl.undoFilter());
		HBox comandiTop = new HBox(cmbFilter, undoBtn);
		root.setTop(comandiTop);
		Scene scene = new Scene(root, 1500, 500);
		primaryStage.setScene(scene);
		primaryStage.centerOnScreen();
		primaryStage.sizeToScene();
		primaryStage.show();
	}

	public Window getPrimaryStage() {
		return primaryStage;
	}
}
