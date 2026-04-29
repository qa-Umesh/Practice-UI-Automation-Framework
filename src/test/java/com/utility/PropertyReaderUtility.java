package com.utility;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import com.ui.constants.Env;

public class PropertyReaderUtility {

	public static String readProperty(Env env,String propertyName) {
		File file = new File(
				System.getProperty("user.dir") + File.separator + "config" + File.separator + env + ".properties");
		Properties properties = new Properties();

		try {
			FileReader reader = new FileReader(file);
			properties.load(reader);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		String url= properties.getProperty(propertyName).toUpperCase();
		return url;
	}

}
