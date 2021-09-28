package com.utility;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;



import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class WaitTimeJson {

	
	public String readjsonfromurl() throws Exception {
		URL url = new URL("https://app-qa.nyumc.org/api_wait/time/tisch");
		InputStream is = url.openConnection().getInputStream();
		BufferedReader bf = new BufferedReader(new InputStreamReader(is));
		JsonParser jsonparser = new JsonParser();
		Object obj = jsonparser.parse(bf);
		JsonObject jsonobj = (JsonObject)obj;
		String retval = jsonobj.get("wait_time").getAsString();
		return retval;
		
	}
}
