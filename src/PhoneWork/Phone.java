package PhoneWork;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Phone {
	String numero;
	String prfx;
	String local;
	
	public Phone(String numero) {
		Pattern pattern=Pattern.compile("(\\d{2,3})?(\\d{3}\\d?)(\\d{7})");
		Matcher match=pattern.matcher(numero);
		String app=match.replaceAll("$1 $2 $3");
		String[] split=app.split(" ");
		prfx=split[0];
		local=split[1];
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
	
	public String getLocal() {
		if (!local.isEmpty()) {
			for (Nazionali naz:Nazionali.values()) 
				if (naz.match(local))
					return local;
			return "Local non valido";
		}
		return local;
	}
	
	public boolean isPhone() {
		if (getPrefix()=="Prefisso non valido" & 
				getLocal()=="Local non valido") 
			return false;
		return true;
	}

	public String getNumero() {
		return numero;
	}
	
	@Override
	public String toString() {
		return getPrefix()+" "+getLocal()+"/"+numero;
	}
}
