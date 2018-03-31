package PhoneWork;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Mobile {
	String numero;
	String prfx;
	String operatore;
	
	public Mobile(String numero) {
		Pattern pattern=Pattern.compile("(\\d{2,3})?(\\d{3})(\\d{7})");
		Matcher match=pattern.matcher(numero);
		String app=match.replaceAll("$1 $2 $3");
		String[] split=app.split(" ");
		prfx=split[0];
		operatore=split[1];
		this.numero=split[2];
	}
	
	public String getPrefix() {
		if (!prfx.isEmpty()) {
			for (Prefissi pfx:Prefissi.values()) 
				if (pfx.match(prfx))
					return prfx;
			return "Prefisso non valido";
		}
		return prfx;
	}
	
	public String getOperatore() {
		if (!operatore.isEmpty()) {
			for (Operatori opt:Operatori.values()) 
				if (opt.match(operatore))
					return operatore;
			return "Operatore non valido";
		}
		return operatore;
	}
	
	public boolean isMobile() {
		if (getPrefix()=="Prefisso non valido" | 
				getOperatore()=="Operatore non valido") 
			return false;
		return true;
	}
	
	public String getNumero() {
		return numero;
	}
	
	@Override
	public String toString() {
		return getPrefix()+" "+getOperatore()+"/"+numero;
	}
}
