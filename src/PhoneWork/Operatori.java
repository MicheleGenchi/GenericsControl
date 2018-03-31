package PhoneWork;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public enum Operatori {
						VODAFONE("(34\\d|383){1}"), 
						TIM("(33[013456789]|36[012368]|385){1}"), 
						WIND("(32[0234789]|38[0389]){1}"), 
						TRE("(39[01237]){1}");
	private String pattern;
	
	Operatori(String pattern) {
		this.pattern = pattern;
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
