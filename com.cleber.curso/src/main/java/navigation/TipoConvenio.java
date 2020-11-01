package navigation;

import java.io.IOException;
import java.net.MalformedURLException;

import com.itextpdf.text.DocumentException;

import commons.actions.SelectAction;
import commons.actions.SetValues;
import commons.start.LocalVariables;
import commons.start.StartParameters;

public class TipoConvenio {
	public static void selecionaTipoConvenio(StartParameters sttp, LocalVariables lv) throws MalformedURLException, InterruptedException, IOException, DocumentException {
		
		if(sttp.getTableLine()[4].equals("Convenio")) {
			
			SetValues.setValores(lv, "convenio", "css", ".FilterToggleBox:nth-child(1) > .FilterToggleBox__icon\n", 
					"click efetuado", "click", "falha no preenchimento do campo email");
			SelectAction.efetiveAction(sttp, lv);
			
		
		}else {
			SetValues.setValores(lv, "particular", "css", ".FilterToggleBox:nth-child(2) > .FilterToggleBox__icon\n", 
					"click efetuado", "click", "falha no preenchimento do campo email");
			SelectAction.efetiveAction(sttp, lv);
			
		}
	}
	
	public static void preencheFormularioConvenio(StartParameters sttp, LocalVariables lv) throws MalformedURLException, InterruptedException, IOException, DocumentException {
		
		SetValues.setValores(lv, "planos empresas", "xpath", "//*[@id=\"root\"]/div/div/div/div[2]/div/div[2]/div/div/div/div[3]", 
				"click efetuado", "click", "falha no preenchimento do campo");
		SelectAction.efetiveAction(sttp, lv);
		
		boolean resp = false;
		int contador = 0;
		while(resp==false) {
			SetValues.setValores(lv, "planos empresas", "xpath", "//*[@id=\"item-"+ contador + "-undefined\"]/p", 
					"click efetuado", "getText", "falha no preenchimento do campo");
			SelectAction.efetiveAction(sttp, lv);
			
			if(lv.getCaptureText().equals(sttp.getTableLine()[5])) {
				SetValues.setValores(lv, "planos empresas", "xpath", "//*[@id=\"item-"+ contador + "-undefined\"]/p", 
						"click efetuado", "click", "falha no preenchimento do campo");
				SelectAction.efetiveAction(sttp, lv);
			resp = true;
			
			}else {
				contador ++;
				
				
			}
			
			
			
		}
		
	}

}
