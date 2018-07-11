package property_config;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigLoader1 {

  static Properties pro;

	static {
			pro = new Properties();

		try {
			FileInputStream fl = new FileInputStream("config.properties");
			pro.load(fl);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static String getMyValue(String key) {

		String value = pro.getProperty(key);
		return value;

	}

}
