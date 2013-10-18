/**
 * 
 */
package com.manage.complex.util;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;



/**
 * @author Amrendra Kumar 
 *
 */
public class MailService  implements ManageComplexConstant{

	String PDFCONTENTTYPE = "application/pdf";	
	String JPGCONTENTTYPE = "image/jpeg";
	String TIFFCONTENTTYPE = "image/tiff";
	
	public static void main(String[] arg){
		byte[] content = null;
		//sendMailSSL(content,"","test","");
	}
	public  int sendMailSSL(String sub,String bodyText,String toMail) {
		
		if (true) {
			 System.setProperty("https.proxyHost", "web-proxy.atl.hp.com");
			 System.setProperty("https.proxyPort","8088");
			 System.setProperty("http.proxyHost", "web-proxy.atl.hp.com");
			 System.setProperty("http.proxyPort","8088");
				
			}
		Properties props = new Properties();
		
		// hp 
		// String host = "smtp.hpl.hp.com";
		String host = "smtp.gmail.com";
		
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.class",
				"javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "465");
		
		
		//Session session = coordManagementHelper.getMailSession();
      // String toMail = "managecomplex1@gmail.com";
       //String sub = "Action required: Reset your Manage complex password";
       final String  fromMail ="managecomplex1@gmail.com";
       final String password ="amrendraanshuman";
       
       System.out.println(" user name and pawaord  "+toMail  + "   " +"  "+fromMail);
      /* Session session = Session.getInstance(props,
	   			new javax.mail.Authenticator() {	
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(fromMail,password);
				}
			});*/
      /* Session session = null;
     //  System.out.println( " session   "+session.toString());
     
       if(session==null){
    	  // System.out.println( " session   "+session.toString());
	       session = Session.getInstance(props,
	   			new javax.mail.Authenticator() {	
	   				protected PasswordAuthentication getPasswordAuthentication() {
	   					return new PasswordAuthentication(fromMail,password);
	   				}
	   			});
    	   
  	  		Session session = Session.getInstance(props,null);
    	  
	       System.out.println( " session  after  "+session.toString());
	       }*/
		try {
 
			Session session = Session.getInstance(props,null);
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(fromMail));
			message.setRecipients(Message.RecipientType.TO,
					InternetAddress.parse(toMail));
			message.setSubject(sub);
			message.setText(bodyText);
			//message.setText("Hello "+"userName"+"\n\n "+"To begin the password-reset process" +	"");
			/*// call enhance service
			if(coordManagementHelper.getEnhanceDoc().equalsIgnoreCase("enhanceDoc")){
				content = getEnhanceDoc(content);
				message.setContent(getMulPart(content,PDFCONTENTTYPE,title,"pdfcolor"));
			}else{
				message.setContent(getMulPart(content,contentType,title,docType));	
			}*/
			
		//	message.setContent(getMulPart(content,contentType,title,docType));
			/*Transport transport =session.getTransport("smtps");
			transport.connect(host,465,fromMail,password);
			transport.sendMessage(message,message.getAllRecipients());
			transport.close();*/
			
			Transport transport = session.getTransport("smtp");
			transport.connect("smtp.gmail.com", fromMail, password);
			transport.sendMessage(message, message.getAllRecipients());
			transport.close();


			//Transport.send(message);
		//	session.
			System.out.println("Done");
			//System.out.println("##########################       end  SendMailSSL        ################### ");
 return 200;
		} catch (MessagingException e) {
			System.out.println("  mail service   exception  getMessage "+e.getMessage());
			//System.out.println("  mail service   e.getStackTrace() "+e.getStackTrace() );
			
			// "Send Email Failed"
			//everNoteError.jsp
			
			throw new RuntimeException(e);
		}
		
	
	}
	
public   Multipart getMulPart(byte[] content,String contentType,String title,String docType) throws MessagingException {
	System.out.println("##########################       inside getMulPart        ################### ");
		byte[] attachmentData =content;
		//MimeMessage msg = new MimeMessage(session);
		Multipart mp = new MimeMultipart();
		MimeBodyPart attachment = new MimeBodyPart();
		
		String fileName = "";
			//title+"."+docType;
		if (docType.startsWith("Jpeg")) {
			fileName = title + ".jpg";
		} else {
			if(docType.startsWith("tif")){
				fileName = title + ".tif";
			}else{
			fileName = title + ".pdf";
			}
		}
		System.out.println(" mail file name  "+fileName);
		attachment.setFileName(fileName);
		attachment.setContent(attachmentData, contentType);
		mp.addBodyPart(attachment);
		
		//msg.setContent(mp);
		System.out.println("##########################       end getMulPart        ################### ");
		return mp;
}
public int SendMailTLS (byte[] content,String contentType,String title,String docType){
	System.out.println(" inside SendMailTLS      ");
	
	String host = "smtp.gmail.com";
	int port = 587;

	 String toMail = "managecomplex1@gmail.comm";
     String sub = "test";
     final String  fromMail ="managecomplex1@gmail.com";
     final String password ="managecomplex1@gmail.com";
     
	Properties props = new Properties();
	props.put("mail.smtp.auth", "true");
	props.put("mail.smtp.starttls.enable", "true");

	Session session = Session.getInstance(props);

	try {

		Message message = new MimeMessage(session);
		message.setFrom(new InternetAddress(fromMail));
		message.setRecipients(Message.RecipientType.TO,
			InternetAddress.parse(toMail));
		message.setSubject(sub);
		message.setText("Dear Mail Crawler," +
				"\n\n No spam to my email, please!");
		message.setContent(getMulPart(content,contentType,title,docType));
		Transport transport = session.getTransport("smtp");
		transport.connect(host, port, fromMail, password);
		Transport.send(message);

		System.out.println("Done");
		System.out.println(" inside SendMailTLS      ");
	return 200;
} catch (MessagingException e) {
	System.out.println("  mail service   exception  getMessage "+e.getMessage());
	System.out.println("  mail service   e.getStackTrace() "+e.getStackTrace() );
	throw new RuntimeException(e);
}
}
public int sendYahoomail (byte[] content,String contentType,String title,String docType){

	Properties props = new Properties();
	
	// hp 
	// String host = "smtp.hpl.hp.com";
	//String host = "smtp.gmail.com";
	//String host = "mail.yahoo.com";
	//props.put("mail.smtp.host", host);
	// To see what is going on behind the scene
	
	
	props.put("mail.smtp.host", "smtp.mail.yahoo.com");
	props.put("mail.smtp.auth", "true");
	props.put("mail.debug", "true");
// call enhance service
	/*if(coordManagementHelper.getEnhanceDoc().equalsIgnoreCase("enhanceDoc")){
		content = getEnhanceDoc(content);
	}*/
	// smtp.mail.yahoo.com
	//Session session = coordManagementHelper.getMailSession();
	 String toMail = "send.anshuman@gmail.com";
     String sub = "test";
     final String  fromMail ="managecomplex1@gmail.com";
     final String password ="amrendraanshuman";
     
   
   System.out.println(" user name and pawaord  "+toMail  + "   " +"  "+fromMail);
	try {

		Session session = Session.getInstance(props,null);
		Message message = new MimeMessage(session);
		message.setFrom(new InternetAddress(fromMail));
		message.setRecipients(Message.RecipientType.TO,
				InternetAddress.parse(toMail));
		message.setSubject(sub);
		message.setText("Dear Mail Crawler," +
				"\n\n No spam to my email, please!");
		//message.setContent(getMulPart(content,contentType,title,docType));
		/*//message.setContent(getMulPart(content,PDFCONTENTTYPE,title,"jpegcolor"));
		if(coordManagementHelper.getEnhanceDoc().equalsIgnoreCase("enhanceDoc")){
			content = getEnhanceDoc(content);
			message.setContent(getMulPart(content,PDFCONTENTTYPE,title,"pdfcolor"));
		}else{
			message.setContent(getMulPart(content,contentType,title,docType));	
		}*/
		
		/*Transport transport =session.getTransport("smtps");
		transport.connect(host,465,fromMail,password);
		transport.sendMessage(message,message.getAllRecipients());
		transport.close();*/
		
		Transport transport = session.getTransport("smtp");
		transport.connect("smtp.mail.yahoo.com", fromMail, password);
		transport.sendMessage(message, message.getAllRecipients());
		transport.close();


		//Transport.send(message);
	//	session.
		System.out.println("Done");
		System.out.println("##########################       end  SendMailSSL        ################### ");

	return 200;

} catch (MessagingException e) {
	System.out.println("  mail service   exception  getMessage "+e.getMessage());
	System.out.println("  mail service   e.getStackTrace() "+e.getStackTrace() );
	throw new RuntimeException(e);
}
}

public int sendHpMail (byte[] content,String contentType,String title,String docType){

	Properties props = new Properties();
	
	String host = "smtp.hpl.hp.com";
	props.setProperty("mail.smtp.host", host);  
	
	
	// smtp.mail.yahoo.com
	//Session session = coordManagementHelper.getMailSession();
	 String toMail = "managecomplex1@gmail.com";
     String sub = "test";
     final String  fromMail ="managecomplex1@gmail.com";
     final String password ="amrendraanshuman";
     
   
   System.out.println(" user name and pawaord  "+toMail  + "   " +"  "+fromMail);
	try {

		Session session = Session.getInstance(props,null);
		Message message = new MimeMessage(session);
		message.setFrom(new InternetAddress(fromMail));
		message.setRecipients(Message.RecipientType.TO,
				InternetAddress.parse(toMail));
		message.setSubject(sub);
		message.setText("Dear Mail Crawler," +
				"\n\n No spam to my email, please!");
		message.setContent(getMulPart(content,contentType,title,docType));
		
		/*Transport transport =session.getTransport("smtps");
		transport.connect(host,465,fromMail,password);
		transport.sendMessage(message,message.getAllRecipients());
		transport.close();*/
		// This is rediff mail 
		/*mailProp.setProperty("mail.transport.protocol","smtp"); 
        mailProp.setProperty("mail.host","mailHost"); 
        mailProp.setProperty("mail.smtp.port","25"); 
        mailProp.setProperty("mail.user",userName); 
        mailProp.setProperty("mail.password",password);*/ 
		
		Transport transport = session.getTransport("smtp");
		transport.connect("smtp.hpl.hp.com", fromMail, password);
		transport.sendMessage(message, message.getAllRecipients());
		transport.close();


		//Transport.send(message);
	//	session.
		System.out.println("Done");
		System.out.println("##########################       end  SendMailSSL        ################### ");

	return 200;

} catch (MessagingException e) {
	System.out.println("  mail service   exception  getMessage "+e.getMessage());
	System.out.println("  mail service   e.getStackTrace() "+e.getStackTrace() );
	throw new RuntimeException(e);
}
}

/**
 * This method is enhanced the doc 
 * @param content
 * @return
 *//*
private byte[] getEnhanceDoc(byte[] content){
	
	System.out.println("got request for Scan2Email ::getEnhanceDoc()" + content.length);
	
	byte[]	outputImg = null;
	int port =new Integer( EverNoteAppConfig.getStringProperty(EverNoteAppConst.PORT));
	String restUrl = EverNoteAppConfig.getStringProperty(EverNoteAppConst.REST_URL);
	System.out.println(" port no  "+port + " rest Url  "+restUrl);
	try {
		ImgServiceClient client1 = new ImgServiceClient();
			outputImg = client1.docEnhancerService(restUrl,
					port, content, "", null);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	System.out.println("got request for Scan2Email::getEnhanceDoc()");
	
return outputImg;
}
*/

public int sendHotmail (byte[] content,String contentType,String title,String docType){

	Properties props = new Properties();
	
	// hp 
	// String host = "smtp.hpl.hp.com";
	//String host = "smtp.gmail.com";
	//String host = "mail.yahoo.com";
	//props.put("mail.smtp.host", host);
	// To see what is going on behind the scene
	
	
	props.put("mail.smtp.host", "smtp.live.com");
	props.put("mail.smtp.auth", "true");
	props.put("mail.debug", "true");
// call enhance service
	/*if(coordManagementHelper.getEnhanceDoc().equalsIgnoreCase("enhanceDoc")){
		content = getEnhanceDoc(content);
	}*/
	// smtp.mail.yahoo.com
	//Session session = coordManagementHelper.getMailSession();
   String fromMail = "amarbawan@hotmail.co.uk";
   String toMail = "managecomplex1@gmail.com";
   String sub = "test";
   final String password ="amrendraanshuman";
   
	 //coordManagementHelper.getPassword();
   
   System.out.println(" user name and pawaord  "+toMail  + "   " +"  "+fromMail);
	try {

		Session session = Session.getInstance(props,null);
		Message message = new MimeMessage(session);
		message.setFrom(new InternetAddress(fromMail));
		message.setRecipients(Message.RecipientType.TO,
				InternetAddress.parse(toMail));
		message.setSubject(sub);
		message.setText("Dear Mail Crawler," +
				"\n\n No spam to my email, please!");
		//message.setContent(getMulPart(content,contentType,title,docType));
		//message.setContent(getMulPart(content,PDFCONTENTTYPE,title,"jpegcolor"));
		/*if(coordManagementHelper.getEnhanceDoc().equalsIgnoreCase("enhanceDoc")){
			content = getEnhanceDoc(content);
			message.setContent(getMulPart(content,PDFCONTENTTYPE,title,"pdfcolor"));
		}else{
			message.setContent(getMulPart(content,contentType,title,docType));	
		}*/
		
		/*Transport transport =session.getTransport("smtps");
		transport.connect(host,465,fromMail,password);
		transport.sendMessage(message,message.getAllRecipients());
		transport.close();*/
		
		Transport transport = session.getTransport("smtp");
		transport.connect("smtp.live.com", fromMail, password);
		transport.sendMessage(message, message.getAllRecipients());
		transport.close();


		//Transport.send(message);
	//	session.
		System.out.println("Done");
		System.out.println("##########################       end  SendMailSSL        ################### ");

	return 200;

} catch (MessagingException e) {
	System.out.println("  mail service   exception  getMessage "+e.getMessage());
	System.out.println("  mail service   e.getStackTrace() "+e.getStackTrace() );
	throw new RuntimeException(e);
}
}

public int sendAolmail (byte[] content,String contentType,String title,String docType){
	Properties props = new Properties();
	
	// hp 
	// String host = "smtp.hpl.hp.com";
	//String host = "smtp.gmail.com";
	//String host = "mail.yahoo.com";
	//props.put("mail.smtp.host", host);
	// To see what is going on behind the scene
	
	
	props.put("mail.smtp.host", "smtp.aol.com");
	props.put("mail.smtp.auth", "true");
	props.put("mail.debug", "true");
// call enhance service
	/*if(coordManagementHelper.getEnhanceDoc().equalsIgnoreCase("enhanceDoc")){
		content = getEnhanceDoc(content);
	}*/
	// smtp.mail.yahoo.com
	//Session session = coordManagementHelper.getMailSession();
	 String toMail = "managecomplex1@gmail.com";
     String sub = "test";
   final String  fromMail =  "amrendra.kumar@aol.com";
   final String password ="10101983";
   
   System.out.println(" user name and pawaord  "+toMail  + "   " +"  "+fromMail);
	try {

		Session session = Session.getInstance(props,null);
		Message message = new MimeMessage(session);
		message.setFrom(new InternetAddress(fromMail));
		message.setRecipients(Message.RecipientType.TO,
				InternetAddress.parse(toMail));
		message.setSubject(sub);
		message.setText("Dear Mail Crawler," +
				"\n\n No spam to my email, please!");
		//message.setContent(getMulPart(content,contentType,title,docType));
		//message.setContent(getMulPart(content,PDFCONTENTTYPE,title,"jpegcolor"));
		/*if(coordManagementHelper.getEnhanceDoc().equalsIgnoreCase("enhanceDoc")){
			content = getEnhanceDoc(content);
			message.setContent(getMulPart(content,PDFCONTENTTYPE,title,"pdfcolor"));
		}else{
			message.setContent(getMulPart(content,contentType,title,docType));	
		}*/
		
		/*Transport transport =session.getTransport("smtps");
		transport.connect(host,465,fromMail,password);
		transport.sendMessage(message,message.getAllRecipients());
		transport.close();*/
		
		Transport transport = session.getTransport("smtp");
		transport.connect("smtp.aol.com", fromMail, password);
		transport.sendMessage(message, message.getAllRecipients());
		transport.close();


		//Transport.send(message);
	//	session.
		System.out.println("Done");
		System.out.println("##########################       end  SendMailSSL        ################### ");

	return 200;

} catch (MessagingException e) {
	System.out.println("  mail service   exception  getMessage "+e.getMessage());
	System.out.println("  mail service   e.getStackTrace() "+e.getStackTrace() );
	throw new RuntimeException(e);
}
}

}
