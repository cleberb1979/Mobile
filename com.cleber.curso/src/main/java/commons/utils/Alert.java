package commons.utils;

import org.openqa.selenium.WebDriver;

import commons.start.LocalVariables;
import commons.start.StartParameters;

public class Alert {
	
	public static String trataAlert(StartParameters sttp, LocalVariables lv, WebDriver driver) {

		try {
			String msgCapturada;
			// String mensagem = driver.switchTo().alert().getText();
			driver.switchTo().alert().accept();
			

			Thread.sleep(2000);
			
			return null;

		} catch (Throwable e) {

			System.out.println("");
			return null;
		}

	}

	private void accept() {
		// TODO Auto-generated method stub
		
	}

	private void dismiss() {
		// TODO Auto-generated method stub
		
	}

	private String getText() {
		// TODO Auto-generated method stub
		return null;
	}

}
