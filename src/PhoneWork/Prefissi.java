package PhoneWork;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public enum Prefissi {
						FRANCIA("(\\+33){1}"), 
						ITALIA("(\\+39){1}"), 
						REGNOUNITO("(\\+44){1}"), 
						SPAGNA("(\\+34){1}");
	private String pattern;
	
	public String getPattern() {
		return pattern;
	}
	
	Prefissi(String pattern) {
		this.pattern=pattern;
	}

	public boolean match(String numero) {
		Pattern p=Pattern.compile(this.pattern);
		Matcher m=p.matcher(numero);
		if (m.find()) 
			return true;
		return false;
	}
}
