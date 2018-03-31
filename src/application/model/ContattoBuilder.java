package application.model;

import javafx.util.Builder;

public class ContattoBuilder implements Builder<Contatto>{
	private Integer id;
	private String nome;
	private String cognome;
    private Integer recapito;
    
	@Override
	public Contatto build() {
		return new Contatto(id, nome, cognome, recapito);
	}

	public ContattoBuilder setId(Integer id) {
		this.id = id;
		return this;
	}

	public ContattoBuilder setNome(String nome) {
		this.nome = nome;
		return this;
	}

	public ContattoBuilder setCognome(String cognome) {
		this.cognome = cognome;
		return this;
	}

	public ContattoBuilder setRecapito(Integer recapito) {
		this.recapito = recapito;
		return this;
	}
}
