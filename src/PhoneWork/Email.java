package PhoneWork;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Email {
	private String email;
	
	public Email(String stringa) {
		this.setEmail(stringa);
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email=email;
	}

	public boolean isEmail() {
		Pattern pattern=Pattern.compile("\\w+@\\w+.\\w{2,3}");
		Matcher match=pattern.matcher(email);
		return match.matches();
	}
	
	@Override
	public String toString() {
		return email;
	}
}
