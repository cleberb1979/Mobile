package main;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.itextpdf.text.DocumentException;

import br.ce.cursowagnerappium.FormularioTeste;
import commons.actions.SelectAction;
import commons.actions.SetValues;
import commons.csv.ReadFileCSV;
import commons.generators.Generators;
import commons.pdf.Pdf;
import commons.properties.SetupProperties;
import commons.start.LocalVariables;
import commons.start.SetupAppium;
import commons.start.StartParameters;
import commons.utils.CaptureData;
import commons.utils.CaptureScreen;
import commons.utils.Folders;
import navigation.ComboViagem;

public class Main {

	public static void main(String[] args) throws IOException, DocumentException, InterruptedException {
		StartParameters sttp = new StartParameters();
		SetupAppium.initAutomation(sttp);
		//Manager.managerExecution(sttp);
		FormularioTeste.devePreencherCampoTexto(sttp);		
		
	}

}
