package commons.start;

import java.io.IOException;

import commons.properties.SetupProperties;
import commons.utils.CaptureData;
import commons.utils.Folders;

public class SetupAppium {
	public static void initAutomation(StartParameters sttp) {
		
		try {
			sttp.setProp(SetupProperties.setConfig(sttp));
			CaptureData.captureNowData(sttp);
			Folders.generateRootFolder(sttp);
			
		}catch (IOException e) {
		System.out.println("Arquivo de Properties não localizado");
			// TODO: handle exception
		
		}
	}

}
