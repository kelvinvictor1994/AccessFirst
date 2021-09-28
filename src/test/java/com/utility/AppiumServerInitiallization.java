package com.utility;

import java.io.File;

import com.settings.RunFeatures;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;

public class AppiumServerInitiallization extends RunFeatures{
	
	public static void startServer() {
	    //Build the Appium service
	    builder = new AppiumServiceBuilder();
	    builder.withIPAddress("127.0.0.1");
	    builder.usingPort(4723);
	    builder.withCapabilities(capabilities);
	    builder.withAppiumJS(new File("/usr/local/lib/node_modules/appium/build/lib/main.js"));
	    builder.withArgument(GeneralServerFlag.SESSION_OVERRIDE);
	    builder.withArgument(GeneralServerFlag.LOG_LEVEL,"error");

	    //Start the server with the builder
	    service = AppiumDriverLocalService.buildService(builder);
	    service.start();
	}
	
	public static void stopServer() {
	    service.stop();
	}

}
