import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;
public class EmailSender{ 
	public static void send(String from,String password,String to,String sub,String msg){
	Properties properties = new Properties(); 
	properties.put("mail.smtp.host","smtp.gmail.com");
	properties.put("mail.smtp.socketFactory.port","465");
	properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
	properties.put("mail.smtp.auth","true");
	properties.put("mail.smtp.port","465");
	
	//properties.setProperty("mail.smtp.host", host); 
	
	Session session = Session.getDefaultInstance(properties,new javax.mail.Authenticator(){
		protected PasswordAuthentication getPasswordAuthentication(){
			return new PasswordAuthentication(from,password);
		}
	});
	// default session 
	try { 
		MimeMessage message = new MimeMessage(session); // email message 
		//message.setFrom(new InternetAddress(from)); // setting header fields 
		message.addRecipient(Message.RecipientType.TO, new InternetAddress(to)); 
		message.setSubject(sub); // subject line 
		// actual mail body 
		message.setText(msg);
		// Send message 
		Transport.send(message);
		System.out.println("Email Sent successfully...."); 
		} 
catch (MessagingException mex)
		{
		mex.printStackTrace();
		}
	} 
 
}