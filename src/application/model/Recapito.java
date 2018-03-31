package application.model;

import PhoneWork.Email;
import PhoneWork.Mobile;
import PhoneWork.Phone;

//entity bean ready for loading it in table view
public class Recapito {
	public int id;
	public String tipo = "";
	public String valore = "";

	public Recapito(String tipo, String valore,int id) {
		this.setTipo(tipo, valore);
		this.id=id;
	}

	public Recapito(String tipo, String valore) {
		this(tipo,valore,0);
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo, String valore) {
		this.tipo = tipo;
		switch (tipo) {
			case "CELLULARE": 
				Mobile mioMobile = new Mobile(valore);
				if (mioMobile.isMobile()) {
					this.valore=mioMobile.toString();
				}
				break;
			case "FISSO":
				Phone mioPhone = new Phone(valore);
				if (mioPhone.isPhone()) {
					this.valore=mioPhone.toString();
				}
				break;
			case "EMAIL":
				Email miaEmail = new Email(valore);
				if (miaEmail.isEmail()) {
					this.valore=miaEmail.toString();
				}
				break;
			default: this.valore=valore;
		}

	}

	public String getValue() {
		return valore;
	}

	public void setValue(String valore) {
		this.valore = valore;
	}

	@Override
	public String toString() {
		return tipo + " " + valore;
	}

}
