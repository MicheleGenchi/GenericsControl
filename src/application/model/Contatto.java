package application.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

//entity bean ready for loading it in table view
public class Contatto {
	private IntegerProperty id;
	private StringProperty nome;
	private StringProperty cognome;
    private IntegerProperty recapito;
	
	public Contatto(int id, String nome, String cognome, int recapito) {
		this.id=new SimpleIntegerProperty(id);
		this.cognome=new SimpleStringProperty(cognome);
		this.nome=new SimpleStringProperty(nome);
		this.recapito=new SimpleIntegerProperty(recapito);
	}

	public final IntegerProperty idProperty() {
		return this.id;
	}
	

	public final int getId() {
		return this.idProperty().get();
	}
	

	public final void setId(final int id) {
		this.idProperty().set(id);
	}
	

	public final StringProperty nomeProperty() {
		return this.nome;
	}
	

	public final String getNome() {
		return this.nomeProperty().get();
	}
	

	public final void setNome(final String nome) {
		this.nomeProperty().set(nome);
	}
	

	public final StringProperty cognomeProperty() {
		return this.cognome;
	}
	

	public final String getCognome() {
		return this.cognomeProperty().get();
	}
	

	public final void setCognome(final String cognome) {
		this.cognomeProperty().set(cognome);
	}
	

	public final IntegerProperty recapitoProperty() {
		return this.recapito;
	}
	

	public final int getRecapito() {
		return this.recapitoProperty().get();
	}
	

	public final void setRecapito(final int recapito) {
		this.recapitoProperty().set(recapito);
	}
	

}
