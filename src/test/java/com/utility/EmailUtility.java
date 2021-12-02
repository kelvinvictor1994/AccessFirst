package com.utility;

import java.util.Properties;

import javax.mail.BodyPart;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.internet.MimeMultipart;
import javax.mail.search.SearchTerm;
import javax.mail.search.SubjectTerm;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;

public class EmailUtility {
	
	public void SendEmail() {
		
		try {
			HtmlEmail email = new HtmlEmail();
		  email.setHostName("smtp.gmail.com");
		  email.setSmtpPort(465);
		  email.setAuthenticator(new DefaultAuthenticator(PropertyReader.properyReader("Frommailid"), PropertyReader.properyReader("Mailidpassword")));
		  email.setSSLOnConnect(true);
		  email.setFrom(PropertyReader.properyReader("Frommailid"));
		  email.setSubject(PropertyReader.properyReader("MailSubject"));
		  String to = PropertyReader.properyReader("Tomailid");
		  email.addTo(to.split(","));

			email.setHtmlMsg("<div style='font-size: 20px; color: black;'>Automation Test Report for AccessFirst 2.0</div>");

		  EmailAttachment attachment = new EmailAttachment();
		  String userdir = System.getProperty("user.dir");
		  attachment.setPath(userdir+PropertyReader.properyReader("extentreportpath"));
		  attachment.setDisposition(EmailAttachment.ATTACHMENT);
		  email.attach(attachment);
		  email.send();
		} catch (EmailException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  
	}
	
	public String searchEmails() throws Exception {
		String host = "imap.gmail.com";
		String port = "995";
		String username = PropertyReader.properyReader("Frommailid");
		String password = PropertyReader.properyReader("Mailidpassword");
		String subject = "AccessFirst App from NYU Langone";
		String content = null;
		
		Properties property = new Properties();
		property.put("mail.imap.host", host);
		property.put("mail.imap.port", port);
		
		Session session = Session.getDefaultInstance(property);
		
		Store store = session.getStore("imaps");
		store.connect(host, username, password);
		
		Folder folderInbox = store.getFolder("INBOX");
		folderInbox.open(Folder.READ_ONLY);
		
		SearchTerm search = new SubjectTerm(subject);

		Message[] foundmsg = folderInbox.search(search);
		
			Message message = foundmsg[foundmsg.length-1];
			String type = message.getContentType();
			//System.out.println(message.getContent());
			if(type.contains("multipart/MIXED"))
					{
			Multipart multipart = (Multipart) message.getContent();
			BodyPart bodypart = multipart.getBodyPart(0);
			//System.out.println(bodypart.getContentType());
			
			MimeMultipart mimemultipart = (MimeMultipart) bodypart.getContent();
			BodyPart bodypart2 = mimemultipart.getBodyPart(0);
			content = (String) bodypart2.getContent();
			//System.out.println(content);
					}
			else {
			content = (String) message.getContent();
			}
			String[] sa = content.split("<b>");
			  String otpsplit = sa[1];
			  String otp = otpsplit.substring(0, 10);	
			  System.out.println(otp);
			
		folderInbox.close(false);
		store.close();
		return otp;
	}



}
