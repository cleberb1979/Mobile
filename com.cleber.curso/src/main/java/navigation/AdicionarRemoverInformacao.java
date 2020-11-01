package navigation;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import com.itextpdf.text.DocumentException;

import commons.actions.Evidence;
import commons.actions.SelectAction;
import commons.actions.SetValues;
import commons.start.LocalVariables;
import commons.start.StartParameters;

public class AdicionarRemoverInformacao {
	
	public static void adicionarInformacoes(StartParameters sttp, LocalVariables lv) throws MalformedURLException, InterruptedException, IOException, DocumentException {
		sttp.getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		
		// Clicar no link que possui o texto "Sign in"
		SetValues.setValores(lv, "sign in", "xpath", "/html/body/nav/div/div/ul[1]/li/a", "click efetuado", "click", "falha no preenchimento do campo");
		SelectAction.efetiveAction(sttp, lv);
		
		// Efetuando Login Id
		SetValues.setValores(lv, "login", "xpath", "//*[@id=\"signinbox\"]/div[1]/form/div[2]/div[1]/input", "julio0001", "sendKeys", "falha no preenchimento do campo");
		SelectAction.efetiveAction(sttp, lv);
		
		// Efetuando Login Password
		SetValues.setValores(lv, "password", "xpath", "//*[@id=\"signinbox\"]/div[1]/form/div[2]/div[2]/input", "123456", "sendKeys", "falha no preenchimento do campo");
		SelectAction.efetiveAction(sttp, lv);
		
		// Clicar em Sign in
		SetValues.setValores(lv, "entrou!", "xpath", "//*[@id=\"signinbox\"]/div[2]/a", "click efetuado", "click", "falha no preenchimento do campo");
		SelectAction.efetiveAction(sttp, lv);
		lv.setRobotMessage("Login realizado com sucesso");
		sttp.setCondition(true);
		Evidence.evidenceResult(sttp, lv);
		
		
		// Clicar dentro do elemento "Hi,Julio"
		SetValues.setValores(lv, "botao usuário logado", "xpath", "//a[@href='http://www.juliodelima.com.br/taskit/me']", "click efetuado", "click", "falha no preenchimento do campo");
		SelectAction.efetiveAction(sttp, lv);

		// Clicar no link que possui o texto "MORE DATA ABOUT YOU"
		SetValues.setValores(lv, "link more data about you", "xpath", "//a[contains(text(),'More data about you')]", "click efetuado", "click", "falha no preenchimento do campo");
		SelectAction.efetiveAction(sttp, lv);
		
		// Identificar a popup onde está o formulário de id addmoredata
		SetValues.setValores(lv, "botão addmoredata", "xpath", "//div[@id='moredata']/div[2]/button", "click efetuado", "click", "falha no preenchimento do campo");
		SelectAction.efetiveAction(sttp, lv);

		// No combo de name "type" escolhe a opção Phone
		SetValues.setValores(lv, "phone", "xpath", "//select[@name='type']", "Phone", "select", "falha no preenchimento do campo");
		SelectAction.efetiveAction(sttp, lv);
		
		// No campo de name "contact" digitar "+5511999999999"
		lv.setNumeroTelefone("+5511444445551");
		SetValues.setValores(lv, "contato", "xpath", "//input[@name='contact']", lv.getNumeroTelefone(), "sendKeys", "falha no preenchimento do campo");
		SelectAction.efetiveAction(sttp, lv);
		
		// Clicar no link de text "SAVE" que está no popup
		SetValues.setValores(lv, "salvar", "xpath", "//*[@id=\"addmoredata\"]/div[2]/a", "click efetuado", "click", "falha no preenchimento do campo");
		SelectAction.efetiveAction(sttp, lv);
		lv.setRobotMessage("Dados incluídos com sucesso");
		sttp.setCondition(true);
		Evidence.evidenceResult(sttp, lv);
		
		
	}
	
}
