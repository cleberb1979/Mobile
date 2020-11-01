package utils;

import java.io.IOException;
import java.net.MalformedURLException;

import org.openqa.selenium.By;

import com.itextpdf.text.DocumentException;

import commons.actions.SelectAction;
import commons.actions.SetValues;
import commons.start.LocalVariables;
import commons.start.StartParameters;

public class InsereData {
	
	public static void insereDataEntrada(StartParameters sttp, LocalVariables lv) throws MalformedURLException, InterruptedException, IOException, DocumentException {
		
		SetValues.setValores(lv, "entrada", "name", "dtCheckIn", "click efetuado", "click", "falha no preenchimento do campo");
		SelectAction.efetiveAction(sttp, lv);
		
		
		String dia = "15";
		String mes = "Outubro";
		
		boolean capturaMes = false;
		boolean verificaMesAtual = true;
		String[]separaAno = null;
		String texto = null;
		
		while(capturaMes == false) {
			if(verificaMesAtual == true) {
				texto = sttp.getDriver().findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div[1]/div/div")).getText();
				
				verificaMesAtual = false;

			}else {
				texto = sttp.getDriver().findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div[2]/div/div")).getText();
				separaAno = texto.split(" ");
				
			}
			
			if(separaAno[0].equals(mes)){
				SetValues.setValores(lv, "dia", "linkText", dia, "click efetuado", "click", "falha no preenchimento do campo");
				SelectAction.efetiveAction(sttp, lv);
				capturaMes = true;
				
			}else {
				SetValues.setValores(lv, "mes", "xpath", "//*[@id=\"ui-datepicker-div\"]/div[2]/div/a\n", "click efetuado", "click", "falha no preenchimento do campo");
				SelectAction.efetiveAction(sttp, lv);
			}

		}

	
	}
	public static void insereDataSaida(StartParameters sttp, LocalVariables lv) throws MalformedURLException, InterruptedException, IOException, DocumentException {
		
		String diaSaida = "30";
		String mesSaida = "Outubro";
		String anoSaida = "2020";
		
		boolean capturaMesSaida = false;
		
		while(capturaMesSaida == false) {
			String texto1 = sttp.getDriver().findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div[2]/div/div")).getText();
			String[]separaAno = texto1.split(" ");
			
			if(separaAno[0].equals(mesSaida)) {
				SetValues.setValores(lv, "dia", "linkText", diaSaida, "click efetuado", "click", "falha no preenchimento do campo");
				SelectAction.efetiveAction(sttp, lv);
				capturaMesSaida = true;
				
			}else {
				SetValues.setValores(lv, "mes", "xpath", "//*[@id=\"ui-datepicker-div\"]/div[2]/div/a", "click efetuado", "click", "falha no preenchimento do campo");
				SelectAction.efetiveAction(sttp, lv);
			}
		}

	}
	
	

}
