package br.ce.cursowagnerappium;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.springframework.util.Assert;

import commons.appium.AppiumSetup;
import commons.csv.ReadFileCSV;
import commons.start.LocalVariables;
import commons.start.StartParameters;
import commons.utils.Folders;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;

public class FormularioTeste {
	
	public static void devePreencherCampoTexto(StartParameters sttp) throws MalformedURLException, IOException, InterruptedException {
		
		LocalVariables lv = new LocalVariables();
		ReadFileCSV.readCSV(sttp);
		String [] tableLine = null;
		sttp.setFirstLine(true);
		
		while((tableLine = sttp.getReader().readNext())!= null) {
			sttp.setTableLine(tableLine);
			if(sttp.getFirstLine() == true) {
				sttp.setFirstLine(false);
				continue;
			}
			Folders.generateSubFolder(sttp);
			AppiumSetup.setConfigMobile(sttp);
			Thread.sleep(10000);
			
			//Selecionar Formulário
			sttp.getDriver().findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget."
					+ "LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[1]/android.widget.TextView\r\n"
					+ "")).click();
			
			Thread.sleep(3000);
			
			//Escrever Nome
			sttp.getDriver().findElement(By.xpath("//android.widget.EditText[@content-desc=\"nome\"]\r\n"
					+ "")).sendKeys("Cleber Benga Luiz");
			
			//Clicar no Combo
			sttp.getDriver().findElement(By.xpath("//android.widget.Spinner[@content-desc=\"console\"]/android.widget.TextView\r\n"
					+ "")).click();
			
			//Selecionar Elemento Combo
			sttp.getDriver().findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.CheckedTextView[3]\r\n"
					+ "")).click();
			
			//Clicar no CheckBox
			sttp.getDriver().findElement(MobileBy.AccessibilityId("check")).click();
			
			//Clicar no Switch
			sttp.getDriver().findElement(MobileBy.AccessibilityId("switch")).click();
			
			//Clicar no Salvar
			sttp.getDriver().findElement(By.xpath("//android.widget.Button[@content-desc=\"save\"]/android.widget.TextView\r\n"
					+ "")).click();

						
		}
	}
}
		
		
		
	
	

	


