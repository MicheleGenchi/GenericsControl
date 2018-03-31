package PhoneWork;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public enum Nazionali {
						ROMA("06"), 
						TARANTO("099"), 
						BARI("080"), 
						MILANO(	"02");
	private String pattern;

	Nazionali(String pattern) {
		this.pattern=pattern;
	}
	
	public String getPattern() {
		return pattern;
	}

	public boolean match(String numero) {
		Pattern p = Pattern.compile(pattern);
		Matcher m = p.matcher(numero);
		if (m.find()) 
			return true;
		return false;
	}
}
