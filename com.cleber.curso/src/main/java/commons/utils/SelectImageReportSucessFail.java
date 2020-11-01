package commons.utils;

import commons.start.LocalVariables;
import commons.start.StartParameters;

public class SelectImageReportSucessFail {
	public static String selecImagePassError(StartParameters sttp, LocalVariables lv) {
		String pathImage = null;
		
		if(lv.getStatus().equals("pass")) {
			pathImage = sttp.getProp().getProperty("sucess");
		
		}else {
			pathImage = sttp.getProp().getProperty("error");
			
		}
			return pathImage;
		
	}

}	


