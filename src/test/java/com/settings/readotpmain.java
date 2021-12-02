package com.settings;

import com.utility.EmailUtility;
import com.utility.FAMApi;

public class readotpmain {


	public static void main(String[] args)  {
		FAMApi fam = new FAMApi();
		EmailUtility email = new EmailUtility();
		
		//email.searchEmails();

		String JSessionID = fam.loginToFam();
		System.out.println("The session id is - " + JSessionID);
		fam.disableMember(JSessionID);
//		try {
//			Thread.sleep(20000);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
		//fam.sendActivationLink("EF72730F6B23694D210EA2B483017CBE.webappdev-jvwlcdcqvm001");
		fam.sendActivationLink(JSessionID);
		fam.createPassword();
	}

}
