package commons.actions;

import java.io.IOException;
import java.net.MalformedURLException;

import com.itextpdf.text.DocumentException;

import commons.start.LocalVariables;
import commons.start.StartParameters;

public class SelectAction {
	public static boolean efetiveAction(StartParameters sttp, LocalVariables lv) throws MalformedURLException, InterruptedException, IOException, DocumentException {
		DefineAction.defineAction(lv);
		
		if(ExecutionAction.executionAction(sttp, lv)==false)return false;
		return true;
		
	}
	

}
