package commons.csv;

import java.io.FileNotFoundException;
import java.io.FileReader;

import com.opencsv.CSVReader;

import commons.start.StartParameters;

public class ReadFileCSV {
	public static void readCSV(StartParameters sttp) throws FileNotFoundException {
		CSVReader reader = new CSVReader(new FileReader(sttp.getProp().getProperty("massadedados")),';');
		sttp.setReader(reader);
		
		
	}

}
