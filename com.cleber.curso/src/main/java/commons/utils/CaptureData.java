package commons.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import commons.start.StartParameters;

public class CaptureData {
	public static void captureNowData(StartParameters sttp) {
		DateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd hh-mm");
		Date date = new Date();
		sttp.setDateNow(dateformat.format(date));
		
	}

}
