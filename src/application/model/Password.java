package application.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

// entity bean ready for loading it in table view
public class Password {
	private StringProperty tipo;
	private StringProperty nome;
	private StringProperty utente;
	private StringProperty password;
	private StringProperty sito;
	private StringProperty note;

	public Password(String tipo, String nome, String utente, String password,
			String sito, String note) {
		this.tipo = new SimpleStringProperty(tipo);
		this.nome = new SimpleStringProperty(nome);
		this.utente = new SimpleStringProperty(utente);
		this.password = new SimpleStringProperty(password);
		this.sito = new SimpleStringProperty(sito);
		this.note = new SimpleStringProperty(note);
	}

	public final StringProperty tipoProperty() {
		return this.tipo;
	}
	
	public final String getTipo() {
		return this.tipoProperty().get();
	}
	
	public final void setTipo(final String tipo) {
		this.tipoProperty().set(tipo);
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
	
	public final StringProperty utenteProperty() {
		return this.utente;
	}
	
	public final String getUtente() {
		return this.utenteProperty().get();
	}
	
	public final void setUtente(final String utente) {
		this.utenteProperty().set(utente);
	}
	
	public final StringProperty passwordProperty() {
		return this.password;
	}
	
	public final String getPassword() {
		return this.passwordProperty().get();
	}
	
	public final void setPassword(final String password) {
		this.passwordProperty().set(password);
	}
	
	public final StringProperty sitoProperty() {
		return this.sito;
	}
	
	public final String getSito() {
		return this.sitoProperty().get();
	}

	public final void setSito(final String sito) {
		this.sitoProperty().set(sito);
	}
	
	public final StringProperty noteProperty() {
		return this.note;
	}
	
	public final String getNote() {
		return this.noteProperty().get();
	}

	public final void setNote(final String note) {
		this.noteProperty().set(note);
	}
}
