package navigation;

import java.io.IOException;
import java.net.MalformedURLException;

import com.itextpdf.text.DocumentException;

import commons.actions.SelectAction;
import commons.actions.SetValues;
import commons.start.LocalVariables;
import commons.start.StartParameters;

public class Home {
	public static void homeCriarConta(StartParameters sttp, LocalVariables lv) throws MalformedURLException, InterruptedException, IOException, DocumentException {
		
		SetValues.setValores(lv, "botão criar conta", "id", "criar-conta", "clique efetuado", "click", "falha no preenchimento do campo");
		SelectAction.efetiveAction(sttp, lv);
	}

}
