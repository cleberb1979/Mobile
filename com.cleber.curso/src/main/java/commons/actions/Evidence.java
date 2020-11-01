package commons.actions;

import java.io.IOException;

import com.itextpdf.text.DocumentException;

import commons.pdf.Pdf;
import commons.start.LocalVariables;
import commons.start.StartParameters;
import commons.utils.CaptureScreen;

public class Evidence {
	public static void evidenceResult(StartParameters sttp, LocalVariables lv) throws IOException, DocumentException {
		if (sttp.getCondition() == true) {
			lv.setPathEvidence(CaptureScreen.evidenceResult(sttp, lv));
			Pdf.addReportImage(sttp, lv);
		
		}else {
			lv.setPathEvidence(CaptureScreen.evidenceResult(sttp, lv));
			Pdf.addReportImage(sttp, lv);

		}	
		
		
	}

}
