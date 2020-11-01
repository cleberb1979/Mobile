package main;

import java.io.IOException;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.itextpdf.text.DocumentException;

import commons.actions.SelectAction;
import commons.actions.SetValues;
import commons.csv.ReadFileCSV;
import commons.generators.Generators;
import commons.pdf.Pdf;
import commons.properties.SetupProperties;
import commons.start.LocalVariables;
import commons.start.StartParameters;
import commons.utils.CaptureData;
import commons.utils.CaptureScreen;
import commons.utils.Folders;
import navigation.ComboViagem;

public class Main {
	
	
	public static void main(String[] args) throws IOException, DocumentException, InterruptedException {
		
		LocalVariables lv = new LocalVariables();
		String valorSorteado = Generators.generateSelectPayment();
		String valorSorteado2 = Generators.generateSelectEmail();
		
	StartParameters sttp = new StartParameters();
	SetupProperties.setConfig(sttp);
	CaptureData.captureNowData(sttp);
	Folders.generateRootFolder(sttp);
	Folders.generateSubFolder(sttp);
	ReadFileCSV.readCSV(sttp);
	String[]tableLine = null;

	
	boolean firstLine = true;
	 while((tableLine = sttp.getReader().readNext())!= null) {
		 if(firstLine) {
			 firstLine = false;
			 continue;
		 }
		 
		 
		 sttp.setTableLine(tableLine);
		 // System.out.println("teste");
		 Pdf.generatePdf(sttp);
		 Pdf.addHeaderReport(sttp);
		 Pdf.insertSummary(sttp);
		 // sttp.getDocPdf().close();
		 
		 System.setProperty("webdriver.chrome.driver", sttp.getProp().getProperty("Pathchromedriver"));
			ChromeOptions options = new ChromeOptions();
			options.addArguments("screenshot");
		 	sttp.setDriver(new ChromeDriver());
			sttp.getDriver().get(sttp.getProp().getProperty("url3"));
			lv.setRobotMessage("meu primeiro print");
			CaptureScreen.evidenceResult(sttp, lv);
			lv.setRobotMessage("meu segundo print");
			CaptureScreen.evidenceResult(sttp, lv);
			
			lv.setRobotElement("Campos:");
			
			Pdf.createParagraphEnter(sttp, lv);
			// Home.homeCriarConta(sttp, lv);
			// TipoConvenio.selecionaTipoConvenio(sttp, lv);
			// TipoConvenio.preencheFormularioConvenio(sttp, lv);
			// AdicionarRemoverInformacao.adicionarInformacoes(sttp, lv);
			// RemoverInformacaoUsuario.removerInformacao(sttp, lv);
			ComboViagem.testarCombo(sttp, lv);
			sttp.getDocPdf().close();
			
			// try {
				
			// }catch (DocumentException doce) {
				// TODO: handle exception
			// }
			
			
			SetValues.setValores(lv, "email", "name", "email_login", "Cleber", "sendKeys", "falha no preenchimento do campo email");
			SelectAction.efetiveAction(sttp, lv);
			
			
			SetValues.setValores(lv, "email", "id", "email_login", "Cleber", "sendKeys", "falha no preenchimento do campo email");
			SelectAction.efetiveAction(sttp, lv);
			
			sttp.getDocPdf().close();

			
			SetValues.setValores(lv, "botão de entrar", "name", "botao", "", "click", "falha no preenchimento do campo");
			SelectAction.efetiveAction(sttp, lv);
			
			SetValues.setValores(lv, "link", "name", "link", "", "click", "falha no preenchimento do campo");
			SelectAction.efetiveAction(sttp, lv);
			
			SetValues.setValores(lv, "partiallink", "name", "link", "", "click", "falha no preenchimento do campo");
			SelectAction.efetiveAction(sttp, lv);
			
			SetValues.setValores(lv, "tagname", "id", "name", "Cleber", "sendKeys", "falha no preenchimento do campo");
			SelectAction.efetiveAction(sttp, lv);

			SetValues.setValores(lv, "xpath", "name", "link", "", "click", "falha no preenchimento do campo");
			SelectAction.efetiveAction(sttp, lv);

			
	 }
	 
	 
		System.setProperty("webdriver.chrome.driver", sttp.getProp().getProperty("Pathchromedriver"));
		// driver = new ChromeDriver();
		// driver.get(sttp.getProp().getProperty("url"));
	
		// driver.findElement(By.name("q")).sendKeys("exec");
		System.out.println("teste");
		
	}

}
