package com.utility;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import com.ui.pojo.User;

public class CsvReaderUtility {

	public static Iterator<User> getloginData(String csvName) {
		File loginDataFile = new File(
				System.getProperty("user.dir") + File.separator + "testData" + File.separator + csvName);
		FileReader fileReader;
		CSVReader csvReader;
		String[] line;
		User user;
		List<User> userList = null;
		try {
			fileReader = new FileReader(loginDataFile);
			csvReader = new CSVReader(fileReader);
			csvReader.readNext();

			userList = new ArrayList<User>();
			while ((line = csvReader.readNext()) != null) {
				user = new User(line[0], line[1]);
				userList.add(user);
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (CsvValidationException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return userList.iterator();
	}

}
