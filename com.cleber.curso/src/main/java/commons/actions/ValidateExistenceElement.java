package commons.actions;

import org.openqa.selenium.By;

import commons.start.LocalVariables;
import commons.start.StartParameters;

public class ValidateExistenceElement {
	public static boolean verifyByName(StartParameters sttp, LocalVariables lv) throws InterruptedException {
		
		for(int i=0; i<60; i++) {
			try {
				sttp.getDriver().findElement(By.name(lv.getRobotValueAttribute()));
				return true;
			}catch(Throwable e) {
				Thread.sleep(1000);
				continue;
				
			}
		}
		return false;
		
	}
public static boolean verifyById(StartParameters sttp, LocalVariables lv) throws InterruptedException {
		
		for(int i=0; i<60; i++) {
			try {
				sttp.getDriver().findElement(By.id(lv.getRobotValueAttribute()));
				return true;
			}catch(Throwable e) {
				Thread.sleep(1000);
				continue;
				
			}
		}
		return false;
		
	}

public static boolean verifyByCss(StartParameters sttp, LocalVariables lv) throws InterruptedException {
	
	for(int i=0; i<60; i++) {
		try {
			sttp.getDriver().findElement(By.cssSelector(lv.getRobotValueAttribute()));
			return true;
		}catch(Throwable e) {
			Thread.sleep(1000);
			continue;
			
		}
	}
	return false;
	
}

public static boolean verifyBylinkText(StartParameters sttp, LocalVariables lv) throws InterruptedException {
	
	for(int i=0; i<60; i++) {
		try {
			sttp.getDriver().findElement(By.linkText(lv.getRobotValueAttribute()));
			return true;
		}catch(Throwable e) {
			Thread.sleep(1000);
			continue;
			
		}
	}
	return false;
}

public static boolean verifyByname(StartParameters sttp, LocalVariables lv) throws InterruptedException {
	
	for(int i=0; i<60; i++) {
		try {
			sttp.getDriver().findElement(By.name(lv.getRobotValueAttribute()));
			return true;
		}catch(Throwable e) {
			Thread.sleep(1000);
			continue;
			
		}
	}
	return false;
}

public static boolean verifyBypartialLinkText(StartParameters sttp, LocalVariables lv) throws InterruptedException {
	
	for(int i=0; i<60; i++) {
		try {
			sttp.getDriver().findElement(By.partialLinkText(lv.getRobotValueAttribute()));
			return true;
		}catch(Throwable e) {
			Thread.sleep(1000);
			continue;
			
		}
	}
	return false;
}

public static boolean verifyBytagName(StartParameters sttp, LocalVariables lv) throws InterruptedException {
	
	for(int i=0; i<60; i++) {
		try {
			sttp.getDriver().findElement(By.tagName(lv.getRobotValueAttribute()));
			return true;
		}catch(Throwable e) {
			Thread.sleep(1000);
			continue;
			
		}
	}
	return false;
}

public static boolean verifyByxpath(StartParameters sttp, LocalVariables lv) throws InterruptedException {
	
	for(int i=0; i<60; i++) {
		try {
			sttp.getDriver().findElement(By.xpath(lv.getRobotValueAttribute()));
			return true;
		}catch(Throwable e) {
			Thread.sleep(1000);
			continue;
			
		}
	}
	return false;
}

}

