package com.utility;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.google.gson.Gson;
import com.ui.constants.Env;
import com.ui.pojo.Config;
import com.ui.pojo.Data;
import com.ui.pojo.Environment;
import com.ui.pojo.User;

public class JSONReaderUtility {

	public static Environment readConfigData(Env env) {

		Gson gson = new Gson();

		File file = new File(
				System.getProperty("user.dir") + File.separator + "config" + File.separator + "config.json");

		FileReader fileReader = null;
		try {
			fileReader = new FileReader(file);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		Config config = gson.fromJson(fileReader, Config.class);
		Environment environment = config.getEnvironments().get(env.name());
		return environment;
	}

	public static Iterator<Object[]> readLoginData(String jsonFileName) {
		Gson gson = new Gson();
		File loginDatafile = new File(
				System.getProperty("user.dir") + File.separator + "testData" + File.separator + jsonFileName + ".json");
		FileReader loginDataReader = null;

		try {
			loginDataReader = new FileReader(loginDatafile);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		Data data = gson.fromJson(loginDataReader, Data.class);
		List<Object[]> userList = new ArrayList<Object[]>();
		for (User user : data.getData()) {
			userList.add(new Object[] { user });
		}

		return userList.iterator();

	}

}
