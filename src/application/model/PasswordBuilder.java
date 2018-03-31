package application.model;

import javafx.util.Builder;

public class PasswordBuilder implements Builder<Password> {
	private String tipo;
	private String nome;
	private String utente;
	private String password;
	private String sito;
	private String note;
	
	@Override
	public Password build() {
		return new Password(tipo, nome, utente, password, sito, note);
	}

	public PasswordBuilder setTipo(String tipo) {
		this.tipo = tipo;
		return this;
	}

	public PasswordBuilder setNome(String nome) {
		this.nome = nome;
		return this;
	}

	public PasswordBuilder setUtente(String utente) {
		this.utente = utente;
		return this;
	}

	public PasswordBuilder setPassword(String password) {
		this.password = password;
		return this;
	}

	public PasswordBuilder setSito(String sito) {
		this.sito = sito;
		return this;
	}

	public PasswordBuilder setNote(String note) {
		this.note = note;
		return this;
	}
}
