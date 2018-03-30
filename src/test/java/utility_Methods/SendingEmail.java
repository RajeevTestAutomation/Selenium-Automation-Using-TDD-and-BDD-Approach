package utility_Methods;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.SimpleEmail;
import org.junit.Test;

public class SendingEmail {
	
	 @Test

  public void Email () throws Exception {
	     
		 System.out.println("=======  Test Started ======");
		 
	Email email = new SimpleEmail();
	
	email.setHostName("smtp.gmail.com");
	
	email.setSmtpPort(465);
	
	email.setAuthenticator(new DefaultAuthenticator("sqt.rajeev@gmail.com", "chaudhary@@"));
	
	email.setSSLOnConnect(true);
	email.setFrom("sqt.rajeev@gmail.com");
	email.setSubject("Selenim Test Report");
	email.setMsg("This is a test mail from selenium... :-)");
	email.addTo("sqt.rajeev@gmail.com");
	email.send();
	
	
	 System.out.println("=======  Email Sent ======");
	
	 }
	
}
