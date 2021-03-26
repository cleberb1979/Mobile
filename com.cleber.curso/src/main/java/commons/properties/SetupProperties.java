package commons.properties;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import commons.start.StartParameters;

public class SetupProperties {
	
	public static Properties setConfig(StartParameters sttp) throws IOException {
		
		Properties prop = new Properties();
		FileInputStream file = new FileInputStream("src/main/resources/config.properties");
		prop.load(file);
		
		return prop;
		
	}

}
