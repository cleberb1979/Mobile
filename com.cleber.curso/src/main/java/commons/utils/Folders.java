package commons.utils;

import java.io.File;

import commons.start.StartParameters;

public class Folders {
	public static void generateRootFolder(StartParameters sttp) {
		File dir = new File("/Users/cleberluiz/Desktop/Meurobo/" + sttp.getDateNow());
		dir.mkdir();
	sttp.setDir(dir);
	}
	
	public static void generateSubFolder(StartParameters sttp) {
		File dir2 = new File(sttp.getDir()+ "/Resultado Execucao");
		dir2.mkdir();
		sttp.setDir2(dir2);
		
	}

}
