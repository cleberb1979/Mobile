package navigation;

import java.io.IOException;
import java.net.MalformedURLException;

import org.openqa.selenium.By;

import com.itextpdf.text.DocumentException;

import commons.actions.SelectAction;
import commons.actions.SetValues;
import commons.start.LocalVariables;
import commons.start.StartParameters;
import commons.utils.Alert;

public class RemoverInformacaoUsuario {
	
	public static void removerInformacao(StartParameters sttp, LocalVariables lv) throws MalformedURLException, InterruptedException, IOException, DocumentException {		
	
		
	// Remover o último contato adicionado automaticamente
		
		boolean resp = false;
		
		int contador=1;
		String numeroTelefone;
		while(resp==false) {
			numeroTelefone = sttp.getDriver().findElement(By.xpath("//*[@id=\"moredata\"]/div[1]/ul/li["+contador+"]/span")).getText();
			
			if(numeroTelefone.equals(lv.getNumeroTelefone())) {
				sttp.getDriver().findElement(By.cssSelector(".collection-item:nth-child("+contador+") > .secondary-content > .material-icons")).click();
				resp = true;
				
			}else {
				contador = contador + 1;
			}
		}
		
	// Confirmar a janela javascript "Deseja remover?"

		Alert.trataAlert(sttp, lv, sttp.getDriver());
		
		String paginaInicial = sttp.getDriver().getWindowHandle();

	// Perform the click operation that opens new window

	// Switch to new window opened
		for (String janelasAbertas : sttp.getDriver().getWindowHandles()) {
			sttp.getDriver().switchTo().window(janelasAbertas);
		}
		
		Thread.sleep(10000);
		
		
	// Clicar no link com o texto "Logout"
		
		SetValues.setValores(lv, "logout", "xpath", "/html/body/nav/div/div/ul[1]/li[3]/a", "click efetuado", "click", "falha no preenchimento do campo");
		SelectAction.efetiveAction(sttp, lv);
		System.out.println("Deu certo!!!!");
		
	}

}
