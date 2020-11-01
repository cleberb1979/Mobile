package commons.utils;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import commons.start.LocalVariables;
import commons.start.StartParameters;

public class CaptureScreen {
	public static String evidenceResult(StartParameters sttp, LocalVariables lv) throws IOException {
		File file = ((TakesScreenshot)sttp.getDriver()).getScreenshotAs(OutputType.FILE);
	
		FileUtils.copyFile(file, new File(sttp.getDir2() +"/" + lv.getRobotMessage() + ".jpg") );
		String pathEvidence = sttp.getDir2() +"/" + lv.getRobotMessage() + ".jpg";
		return pathEvidence;
		
	}

}
	