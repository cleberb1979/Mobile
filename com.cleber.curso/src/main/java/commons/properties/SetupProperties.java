package commons.properties;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import commons.start.StartParameters;

public class SetupProperties {
	
	public static void setConfig(StartParameters sttp) throws IOException {
		
		Properties prop = new Properties();
		FileInputStream file = new FileInputStream("/Users/cleberluiz/Desktop/Meurobo/config.properties");
		prop.load(file);
		
		sttp.setProp(prop);
		
		
	}

}
