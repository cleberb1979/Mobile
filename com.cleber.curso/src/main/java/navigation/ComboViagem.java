package navigation;

import java.io.IOException;
import java.net.MalformedURLException;

import com.itextpdf.text.DocumentException;

import commons.actions.SelectAction;
import commons.actions.SetValues;
import commons.start.LocalVariables;
import commons.start.StartParameters;
import utils.InsereData;

public class ComboViagem {
	
	public static void testarCombo(StartParameters sttp, LocalVariables lv) throws MalformedURLException, InterruptedException, IOException, DocumentException {
	
		// Clicar no login
		
		SetValues.setValores(lv, "portal do cliente", "xpath", "//*[@id=\"montreal-topbar\"]/div/a[2]", "click efetuado", "click", "falha no preenchimento do campo");
		SelectAction.efetiveAction(sttp, lv);
		
		// Switch to new window opened

				for (String janelasAbertas : sttp.getDriver().getWindowHandles()) {
					sttp.getDriver().switchTo().window(janelasAbertas);

				}
				SetValues.setValores(lv, "login", "xpath", "//input[@type='text']", "click efetuado", "click", "falha no preenchimento do campo");
				SelectAction.efetiveAction(sttp, lv);			
				
		// No campo Login, informar CPF
		
		SetValues.setValores(lv, "login", "xpath", "//input[@type='text']", "76841057872", "sendKeys", "falha no preenchimento do campo");
		SelectAction.efetiveAction(sttp, lv);
				
		// No campo senha, informar senha
		SetValues.setValores(lv, "senha", "xpath", "//input[@type='password']", "9192", "sendKeys", "falha no preenchimento do campo");
		SelectAction.efetiveAction(sttp, lv);
		
		// Clicar Acesse sua Conta
		
		SetValues.setValores(lv, "Acesse sua conta", "css", ".col-sm-offset-1 > .btn-large", "click efetuado", "click", "falha no preenchimento do campo");
		SelectAction.efetiveAction(sttp, lv);
		
		// Switch to new window opened
			for (String janelasAbertas : sttp.getDriver().getWindowHandles()) {
				sttp.getDriver().switchTo().window(janelasAbertas);
			}

		// Fechar a popup
		
		SetValues.setValores(lv, "fecha popup", "xpath", "//div[@id='popUpGuru']/img", "click efetuado", "click", "falha no preenchimento do campo");
		SelectAction.efetiveAction(sttp, lv);
		// System.out.println("Deu certo!");
		
		// Selecionar Destino
		
		SetValues.setValores(lv, "destino", "id", "destino_value", "click efetuado", "click", "falha no preenchimento do campo");
		SelectAction.efetiveAction(sttp, lv);

		
		SetValues.setValores(lv, "cidade", "id", "destino_value", "Rio de Janeiro", "sendKeys", "falha no preenchimento do campo");
		SelectAction.efetiveAction(sttp, lv);
		Thread.sleep(5000);

		
		SetValues.setValores(lv, "Rio de Janeiro", "xpath", "//div[@id='destino_dropdown']/div[3]/div", "click efetuado", "click", "falha no preenchimento do campo");
		SelectAction.efetiveAction(sttp, lv);
		Thread.sleep(5000);
		
			
		// Clicar no formulário para escolher Entrada
		
		InsereData.insereDataEntrada(sttp, lv);
		
		// Clicar no formulário para escolher Saída

		InsereData.insereDataSaida(sttp, lv);
		
		
		
		
		// SetValues.setValores(lv, "Novembro", "xpath", "//*[@id=\"ui-datepicker-div\"]/div[2]", "click efetuado", "getText", "falha no preenchimento do campo");
		// SelectAction.efetiveAction(sttp, lv);
		
		// Point datePicker = sttp.getDriver().findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div[2]")).getLocation();
		// new SelectAction().equals("Novembro 2020");
		
				
	}
}

		
	
	
	
	


