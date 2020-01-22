package utilities;

import java.util.Date;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class check_mail {
	
	public static void main(String[] args) {
		Automail();
	}
	
	public static void Automail() {
	/*	
		Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465"); 
        Session session = Session.getDefaultInstance(props,
        new javax.mail.Authenticator() {
                            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("rohitv.iprogrammer@gmail.com","Webdriver@123");
            }
        });

    try {

        Message message = new MimeMessage(session);
        message.setFrom(new InternetAddress("rohitv.iprogrammer@gmail.com"));
        message.setRecipients(Message.RecipientType.TO,
                InternetAddress.parse("rohitvyas300@gmail.com"));
        message.setSubject("Testing Subject");
        message.setText("Test Mail");

        Transport.send(message);

        System.out.println("Done");

    } catch (MessagingException e) {
        throw new RuntimeException(e);
    }
	*/	
		
	
	        final String username = "rohitv.iprogrammer@gmail.com";
	        final String password = "Webdriver@123";

	        Properties props = new Properties();
	        props.put("mail.smtp.auth", true);
	        props.put("mail.smtp.starttls.enable", true);
	        props.put("mail.smtp.host", "smtp.gmail.com");
	        props.put("mail.smtp.port", "587");
//	        props.put("proxySet","true"); 
//	        props.put("socksProxyHost","192.168.155.1");
//	        props.put("socksProxyPort","1080");

	        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
	                    protected PasswordAuthentication getPasswordAuthentication() {
	                        return new PasswordAuthentication(username, password);
	                    }
	                });

	        try {

	            Message message = new MimeMessage(session);
	            message.setFrom(new InternetAddress("rohitv@iprogrammer.com"));
	            message.setRecipients(Message.RecipientType.TO,
	                    InternetAddress.parse("rohitvyas300@gmail.com"));	            	                    	            
	            message.addRecipients(Message.RecipientType.CC, InternetAddress.parse("shitoleujjwal@gmail.com,ujshitol@in.ibm.com,moink@iprogrammer.com,supriyag@iprogrammer.com"));
	            //message.addRecipients(Message.RecipientType.CC, InternetAddress.parse("ujshitol@in.ibm.com"));
	            //message.addRecipients(Message.RecipientType.CC, InternetAddress.parse("moink@iprogrammer.com"));
	            	            		
	            message.setSubject("Test Automation Report" +  new Date());		            
	            //message.setText("Auto Generated Test Automation Report Please don't reply");
	            message.setText("passwordttt");
	            message.setSentDate(new Date());	            
	            
	            
	            //MimeBodyPart messageBodyPart = new MimeBodyPart();
	            Multipart multipart = new MimeMultipart();

	            MimeBodyPart messageBodyPart = new MimeBodyPart();
	            //String path = System.getProperty("user.dir");
	            
	            System.out.println(PropertiesAndConstants.CurrentDirectory);
	            String file = PropertiesAndConstants.CurrentDirectory+"/test-output/emailable-report.html";
	            String fileName = "reports.html";
	            DataSource source = new FileDataSource(file);
	            messageBodyPart.setDataHandler(new DataHandler(source));
	            messageBodyPart.setFileName(fileName);	            
	            multipart.addBodyPart(messageBodyPart);	            
	            message.setContent(multipart);

	            System.out.println("Email Sending in progress..");

	            Transport.send(message);
	            System.out.println("Email sent :)");            

	        } catch (MessagingException e) {
	            e.printStackTrace();
	        }
	             
	    }

}
