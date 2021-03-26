package main;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.By;

import commons.appium.AppiumSetup;
import commons.csv.ReadFileCSV;
import commons.start.LocalVariables;
import commons.start.StartParameters;
import commons.utils.Folders;

public class Manager {
	
	public static void managerExecution(StartParameters sttp) throws IOException, InterruptedException {
		
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
			sttp.getDriver().get("http://www.lojaiplace.com.br");
			
			sttp.getDriver().findElement(By.xpath("//*[@id=\"update-mobile-login\"]/div[1]/div[1]/a")).click();
			
			sttp.getDriver().findElement(By.xpath("//*[@id=\"update-mobile-login\"]/div[2]/div/nav/ul[3]/li[1]/a")).click();
		
			sttp.getDriver().findElement(By.xpath("//*[@id=\"newRegisterEmail\"]")).sendKeys("patriciatcluiz@hotmail.com");
			
			sttp.getDriver().findElement(By.xpath("/html/body/div[5]/div/div/div/div[4]/div/div/div[1]/button")).click();
		
			sttp.getDriver().findElement(By.id("input-password")).sendKeys("patty0209");
			
			sttp.getDriver().findElement(By.id("input-cpf")).sendKeys("28338490873");
			
			sttp.getDriver().findElement(By.id("input-fullName")).sendKeys("Patricia Thomaz");
			
			sttp.getDriver().findElement(By.id("input-phone")).sendKeys("11989624969");
			
			sttp.getDriver().findElement(By.id("dia-nascimento")).click();
			
			sttp.getDriver().findElement(By.xpath("//*[@id=\"dia-nascimento\"]/option[3]")).click();
			
			sttp.getDriver().findElement(By.id("mes-nascimento")).click();
			
			sttp.getDriver().findElement(By.xpath("//*[@id=\"mes-nascimento\"]/option[10]")).click();
			
			sttp.getDriver().findElement(By.id("ano-nascimento")).click();
			
			sttp.getDriver().findElement(By.xpath("//*[@id=\"ano-nascimento\"]/option[44]")).click();
			
			sttp.getDriver().findElement(By.name("sexo")).click();
			
			sttp.getDriver().findElement(By.xpath("//*[@id=\"form-pessoa-fisica\"]/div[9]/div[2]/div/select/option[3]")).click();
			
			sttp.getDriver().findElement(By.id("input-cep")).sendKeys("06140040");
			
			sttp.getDriver().findElement(By.id("input-endereco")).sendKeys("Rua Pernambucana");
			
			sttp.getDriver().findElement(By.id("input-numero")).sendKeys("200");
			
			sttp.getDriver().findElement(By.name("complemento")).sendKeys("Bloco 8 apto 33");
			
			sttp.getDriver().findElement(By.id("input-bairro")).sendKeys("Conceição");
			
			sttp.getDriver().findElement(By.id("input-cidade")).sendKeys("Osasco");
			
			sttp.getDriver().findElement(By.id("input-uf")).click();
			
			sttp.getDriver().findElement(By.xpath("//*[@id=\"input-uf\"]/option[26]")).click();
			
			sttp.getDriver().findElement(By.xpath("//*[@id=\"form-pessoa-fisica\"]/div[23]/div[2]/div/input[5]")).click();
			
		}
		
	}
	
	

}
